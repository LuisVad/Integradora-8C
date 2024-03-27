package utez.edu.mx.Integradora8C.Dtos.Auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioTokenDto {
    @NotNull
    private Usuarios usuarios;
    @NotBlank
    private String token;
}
