package cloud.tteams.identity.user.application.command.changepassword;

import jakarta.validation.constraints.NotBlank;

public record UserChangePasswordRequest(@NotBlank String email, @NotBlank String oldPassword,
                                        @NotBlank String newPassword) {
}
