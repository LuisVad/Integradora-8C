package utez.edu.mx.Integradora8C.Dtos.BitacoraDatos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BitacoraDatosDto {

    //Columna idMovimiento
    private String idMovimiento;

    //Columna tipoPeticion
    private String tipoPeticion;

    //Columna cargaJson
    private String cargaJson;

    //Columna ip
    private String ip;

    //Columna creadoEl
    private Timestamp creadoEl;

    //Columna active
    private char active;

    //Aquí ira relación usuarios_id_usuario

}
