package ec.gob.registrocivil.identity.user.application.command.register.data;

import java.util.UUID;

public class RegisterCitizenRequest {

    private String nui;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private UUID telephoneOperator;

    public RegisterCitizenRequest() {
    }

    public RegisterCitizenRequest(String nui, String firstName, String lastName, String email, String phone,
            UUID telephoneOperator) {
        this.nui = nui;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.telephoneOperator = telephoneOperator;
    }

    public String getNui() {
        return nui;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UUID getTelephoneOperator() {
        return telephoneOperator;
    }

}
