package utez.edu.mx.Integradora8C.Dtos.Roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolesDto {

    //Columna idRol
    private String idRol;

    //Columna nombre
    private String nombre;

    //Columna ultimaModificacion
    private Timestamp ultimaModificacion;

    //Columna active
    private char active;

    //Relación
}
