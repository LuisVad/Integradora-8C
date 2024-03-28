package utez.edu.mx.Integradora8C.Dtos.ServiciosPaquete;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.Integradora8C.Entities.Paquetes.Paquetes;
import utez.edu.mx.Integradora8C.Entities.Servicios.Servicios;
import utez.edu.mx.Integradora8C.Entities.ServiciosPaquete.ServiciosPaquete;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiciosPaqueteDto {
    private String idServicioPaquete;
    @NotBlank(message = "El paquete no puede ser nulo")
    private Paquetes paquete;
    @NotBlank(message = "El servicio no puede ser nulo")
    private Servicios servicio;
    private Timestamp ultimaModificacion;
    private boolean active;

    public ServiciosPaquete toEntity(){
        Timestamp ultimaModificacion = this.ultimaModificacion == null ? new Timestamp(System.currentTimeMillis()) : this.ultimaModificacion;
        return new ServiciosPaquete(idServicioPaquete, paquete, servicio, ultimaModificacion, active);
    }
}