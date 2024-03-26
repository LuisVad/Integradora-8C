package utez.edu.mx.Integradora8C.Dtos.Roles;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.Integradora8C.Entities.Roles.Roles;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class  RolesDto {
    private String idRol;
    @NotBlank(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;
    private Timestamp ultimaModificacion;
    @NotBlank(message = "El active no puede ser nulo")
    private Boolean active;


    public Roles toEntity(){
        Timestamp ultimaModificacion = this.ultimaModificacion == null ? new Timestamp(System.currentTimeMillis()) : this.ultimaModificacion;
        Roles role = new Roles(idRol, nombre, ultimaModificacion, active, null);
        return role;
    }

}
