package utez.edu.mx.Integradora8C.Dtos.Usuarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuariosDto {

    //Columna idUsuario
    private String idUsuario;

    //Columna nombres
    private String nombres;

    //Columna primerApellido
    private String primerApellido;

    //Columna segundoApellido
    private String segundoApellido;

    //Columna telefono
    private String telefono;

    //Columna correo
    private String correo;

    //Columna ultimaModificacion
    private Timestamp ultimaModificacion;

    //Columna active
    private char active;

    //Aquí ira relación roles_id_rol
}
