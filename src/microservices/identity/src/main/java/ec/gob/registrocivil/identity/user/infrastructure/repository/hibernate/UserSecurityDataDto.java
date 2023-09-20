package ec.gob.registrocivil.identity.user.infrastructure.repository.hibernate;

import java.util.Map;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;

//@Entity
//@Table(name = "jpa_usersecuritydata")
public class UserSecurityDataDto {

    @Id
    @Column
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    Map<String, String> securityQuestion;

    @Column
    private Long registrationCode;

    @Column
    private Long recoveryCode;
}
