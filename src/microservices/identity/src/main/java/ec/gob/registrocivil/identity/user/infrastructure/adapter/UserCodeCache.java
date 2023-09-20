package ec.gob.registrocivil.identity.user.infrastructure.adapter;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserCodeCache {

    private static final Logger logger = LoggerFactory.getLogger(UserCodeCache.class);
    private Map<String, LocalTime> codeList;

    public UserCodeCache() {
        this.codeList = new HashMap<>();
    }

    public void create(String email) {
        String registationCode = RandomStringUtils.randomNumeric(6);
        LocalTime expiration = LocalTime.now().plusMinutes(5);
        codeList.put(registationCode, expiration);
        logger.info(registationCode);
        // TODO: aquí enviar correo con código
    }

    public HttpStatus check(String code) {
        if (this.codeList.containsKey(code)) {
            LocalTime expiration = this.codeList.get(code);
            if (expiration.isAfter(LocalTime.now())) {
                this.codeList.remove(code);
                return HttpStatus.OK;
            } else {
                return HttpStatus.BAD_REQUEST;
            }
        }
        return HttpStatus.NOT_FOUND;
    }

    @Scheduled(fixedRate = 30000)
    public void cleanUserCodeCache() {
        logger.info("Executing scheduled registration security code cache maintenance");
        this.codeList.entrySet().stream().forEach(entry -> {
            if (entry.getValue().isBefore(LocalTime.now())) {
                logger.info("Expired code: " + entry.getKey() + " deleted on cache maintenance");
                this.codeList.remove(entry.getKey());
            }
        });
    }

}
