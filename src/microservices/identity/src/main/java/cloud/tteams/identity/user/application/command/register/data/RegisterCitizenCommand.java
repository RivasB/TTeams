package cloud.tteams.identity.user.application.command.register.data;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class RegisterCitizenCommand implements ICommand {

    private UUID id;

    private String nui;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private UUID telephoneOperator;

    public RegisterCitizenCommand() {
    }

    public RegisterCitizenCommand(String nui, String firstName, String lastName, String email, String phone,
            UUID telephoneOperator) {
        this.id = UUID.randomUUID();
        this.nui = nui;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.telephoneOperator = telephoneOperator;
    }

    public static RegisterCitizenCommand fromRequest(RegisterCitizenRequest request) {

        return new RegisterCitizenCommand(
                request.getNui(),
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPhone(), 
                request.getTelephoneOperator());
    }

    public UUID getId() {
        return id;
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

    public void setPhone(String code) {
        this.phone = code;
    }

    public UUID getTelephoneOperator() {
        return telephoneOperator;
    }

    @Override
    public ICommandMessage getMessage() {
        // Solo para pruebas
        return new RegisterCitizenMessage(id, phone);
    }

}
