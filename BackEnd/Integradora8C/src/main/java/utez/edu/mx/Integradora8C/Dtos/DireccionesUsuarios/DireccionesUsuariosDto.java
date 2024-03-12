package utez.edu.mx.Integradora8C.Dtos.DireccionesUsuarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.Integradora8C.Entities.Direcciones.Direcciones;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DireccionesUsuariosDto {

    private String idDireccionUsuario;

    private Direcciones direcciones;

    private Usuarios usuarios;
}
