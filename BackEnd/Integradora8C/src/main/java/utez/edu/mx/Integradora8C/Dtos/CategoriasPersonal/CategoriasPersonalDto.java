package utez.edu.mx.Integradora8C.Dtos.CategoriasPersonal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriasPersonalDto {

    //Columna idMovimiento
    private String idCategoria;

    //Columna nombre
    private String nombre;

    //Columna ultimaModificacion
    private String ultimaModificacion;

    //Columna active
    private char active;

}
