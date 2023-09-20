package ec.gob.registrocivil.identity.user.application.command.changepassword;

public class UserChangePasswordRequest {

    private String nui;

    private String oldPassword;

    private String newPassword;

    public UserChangePasswordRequest(String nui, String oldPassword, String newPassword) {
        this.nui = nui;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getNui() {
        return nui;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

}
