package cloud.tteams.identity.user.application.command.register.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record RegisterUserRequest(@NotEmpty(message = "El nombre es obligatorio") String firstName,
                                  @NotEmpty(message = "Los apellidos son obligatorios") String lastName,
                                  @Email(message = "El correo debe cumplir con la nomeclatura estandar <<user@dominio.red>>") @NotEmpty(message = "El correo electrónico es obligatorio") String email,
                                  @Positive @NotEmpty(message = "El teléfono es obligatorio") String phone,
                                  @NotEmpty(message = "La contraseña no puede estar vacia") String password) {

}
