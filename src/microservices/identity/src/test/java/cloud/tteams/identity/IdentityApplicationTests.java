package cloud.tteams.identity;

import org.springframework.boot.test.context.SpringBootTest;
/*
import cloud.tteams.identity.shared.domain.MessagePaginatedResponse;
import cloud.tteams.identity.shared.domain.DomainException;
import domain.user.cloud.tteams.identity.UserId;
import domain.user.cloud.tteams.identity.UserState;
import domain.user.cloud.tteams.identity.UserType;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
*/

@SpringBootTest
class IdentityApplicationTests {

    /*
     * @Autowired
     * DomainUserService domainUserService;
     *
     * //TODO: UUID usados
     * UserId id1 = new UserId(UUID.randomUUID());
     * UserId id2 = new UserId(UUID.randomUUID());
     * UserId id3 = new UserId(UUID.randomUUID());
     * UserId id4 = new UserId(UUID.randomUUID());
     *
     * //TODO: condiciones de busqueda.
     * String sortType = "asc";
     * String sortBy = "firstName";
     * Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() :
     * Sort.by(sortBy).descending();
     *
     * Integer pageNo = 0;
     * Integer pageSize = 5;
     * Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
     * String filter = "";
     *
     * @BeforeEach
     * void createUser(){
     * domainUserService.createUser(id1.getValue(), "Yannier",
     * "Penna Escalona", "89042735963", "ypescalona@gmail.com", "Qaz/*9991232",
     * "CITIZEN", "ACTIVE");
     * domainUserService.createUser(id2.getValue(), "Alex",
     * "Davir", "5245542", "alex@gmail.com", "Qaz/*9991232", "CITIZEN", "ACTIVE");
     * domainUserService.createUser(id3.getValue(), "Luis",
     * "Daniel", "5684571", "luis@gmail.com", "Qaz/*9991232", "CITIZEN", "ACTIVE");
     * domainUserService.createUser(id4.getValue(), "Omar",
     * "Puig", "5414272", "omi@gmail.com", "Qaz/*9991232", "CITIZEN", "ACTIVE");
     * }
     *
     * @AfterEach
     * void deleteAll(){
     * domainUserService.delete(id1);
     * domainUserService.delete(id2);
     * domainUserService.delete(id3);
     * domainUserService.delete(id4);
     * }
     *
     * @Test
     * void getPaginatedUsersTest() {
     * MessagePaginatedResponse list = domainUserService.getPaginatedUsers(pageable,
     * filter);
     *
     * Assertions.assertEquals(list.getData().size(), 5);
     * }
     *
     * @Test
     * void updateUserTest() {
     * String firstName = "Juanito";
     * String lastName = "Penna Escalona";
     * String identification = "89042735963";
     * String email = "yp@gmail.com";
     * String type = UserType.MANAGER.toString();
     * String state = UserState.INACTIVE.toString();
     *
     * domainUserService.updateUser(id1.getValue(), firstName, lastName,
     * identification, email, type, state);
     *
     * //TODO: condicion de busqueda
     * filter = "Juanito";
     * MessagePaginatedResponse list = domainUserService.getPaginatedUsers(pageable,
     * filter);
     *
     * Assertions.assertEquals(list.getData().size(), 1);
     * }
     *
     * /**
     * El delete, no está reaccionando correctamente ante un UUID invalido.
     */
    /*
     * @Test
     * void deleteExceptionTest() {
     * //TODO: UUID no existente
     * UserId idTest = new
     * UserId(UUID.fromString("3ab24dd2-1d0f-4693-a93e-088b9a44f0f8"));
     *
     * org.assertj.core.api.Assertions.assertThatExceptionOfType(DomainException.
     * class)
     * .isThrownBy(() -> domainUserService.delete(idTest))
     * .withMessage("User not found.");
     * }
     */

}
