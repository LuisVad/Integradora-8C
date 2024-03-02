package utez.edu.mx.Integradora8C.Dtos.Personal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonalDto {

    //Columna idPersonal
    private String idPersonal;

    //Aquí ira relación categorias_personal_id_categoria

    //Aquí ira relación usuarios_id_usuario

    //Columna ultimaModificacion
    private Timestamp ultimaModificacion;

    //Columna active
    private char active;
}
