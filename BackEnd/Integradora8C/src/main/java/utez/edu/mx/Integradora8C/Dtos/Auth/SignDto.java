package utez.edu.mx.Integradora8C.Dtos.Auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SignDto {
    @NotBlank
    @NotEmpty
    private String correo;
    @NotBlank
    @NotEmpty
    private String contrasenia;
}
