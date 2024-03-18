package utez.edu.mx.Integradora8C.Dtos.CategoriasServicios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.Integradora8C.Entities.CategoriasServicios.CategoriasServicios;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriasServiciosDto {

    private String idCategoria;

    @NotBlank(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    private Timestamp ultimaModificacion;

    private Boolean active;

    public CategoriasServicios toEntity(){
        Timestamp ultimaModificacion = this.ultimaModificacion == null ? new Timestamp(System.currentTimeMillis()) : this.ultimaModificacion;
        return new CategoriasServicios(idCategoria, nombre, ultimaModificacion, true);
    }
}
