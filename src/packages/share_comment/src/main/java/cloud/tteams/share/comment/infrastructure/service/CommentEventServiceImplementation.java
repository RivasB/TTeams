package cloud.tteams.share.comment.infrastructure.service;

import cloud.tteams.share.comment.domain.service.ICommentDomainService;
import cloud.tteams.share.user.domain.*;
import cloud.tteams.share.user.infrastructure.service.UserEventService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommentEventServiceImplementation {
    private static final Logger logger = LoggerFactory.getLogger(UserEventService.class);
    private final ICommentDomainService service;

    public CommentEventServiceImplementation(ICommentDomainService service) {
        this.service = service;
    }

    @KafkaListener(topics = "${topic.comment.name:comment}", containerFactory = "kafkaListenerContainerFactory",
            groupId ="${spring.application.name}-shared-user-group")
    public void consumer(String message) {
        JSONObject eventMessage = new JSONObject(message);
        try {
            UUID id = UUID.fromString(eventMessage.getJSONObject("data").getJSONObject("id").getString("value"));
            String firstName = eventMessage.getJSONObject("data").getJSONObject("firstName").getString("value");
            String lastName = eventMessage.getJSONObject("data").getJSONObject("lastName").getString("value");
            String identification = eventMessage.getJSONObject("data").getJSONObject("identification").getString("value");
            String email = eventMessage.getJSONObject("data").getJSONObject("email").getString("value");
            String phone = eventMessage.getJSONObject("data").getJSONObject("phone").getString("value");
            UserState state = eventMessage.getJSONObject("data").getString("state").equals("ACTIVE")
                    ? UserState.ACTIVE
                    : UserState.INACTIVE;
            User user = new User(new UserId(id), new UserFirstName(firstName), new UserLastName(lastName),
                    new UserIdentification(identification), new UserEmail(email), new UserPhone(phone), state);
            if (eventMessage.getString("type").equals("CREATED")) {
                logger.info("Received USER CREATED EVENT >>>>>>>>>> with USER-ID={}", id);
                if (!service.existsById(user.getId())) {
                    service.createUser(user);
                    logger.info("USER {} created successfully", id);
                } else {
                    logger.info("USER {} already exists", id);
                }
            }
            if (eventMessage.getString("type").equals("UPDATED")) {
                logger.info("Received USER UPDATED EVENT >>>>>>>>>> with USER-ID={}", id);
                if (service.existsById(user.getId()))
                    service.updateUser(user);
                logger.info("USER {} updated successfully", id);
            }
            if (eventMessage.getString("type").equals("DELETED")) {
                logger.info("Received USER UPDATED EVENT >>>>>>>>>> with USER-ID={}", id);
                if (service.existsById(user.getId()))
                    service.delete(new UserId(id));
                logger.info("USER {} deleted successfully", id);
            }
        }
        catch(Exception ex){
            logger.error("Error creating User Entity from message", ex);
        }
    }
}
