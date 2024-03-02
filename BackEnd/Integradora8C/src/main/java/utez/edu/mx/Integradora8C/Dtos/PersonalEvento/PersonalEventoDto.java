package utez.edu.mx.Integradora8C.Dtos.PersonalEvento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonalEventoDto {
    //Columna idPersonalEvento
    private String idPersonalEvento;

    //Aquí ira relación personal_id_personal

    //Aquí ira relación eventos_id_evento

    //Columna ultimaModificacion
    private Timestamp ultimaModificacion;

    //Columna active
    private char active;
}
