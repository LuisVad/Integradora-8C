package utez.edu.mx.Integradora8C.Dtos.ServiciosEvento;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.Integradora8C.Entities.Eventos.Eventos;
import utez.edu.mx.Integradora8C.Entities.Servicios.Servicios;
import utez.edu.mx.Integradora8C.Entities.ServiciosEvento.ServiciosEvento;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiciosEventoDto {
    private String idServicioEvento;
    @NotBlank(message = "El evento no puede ser nulo")
    private Eventos evento;
    @NotBlank(message = "El servicio no puede ser nulo")
    private Servicios servicio;
    private Timestamp ultimaModificacion;
    private boolean active;

    public ServiciosEvento toEntity(){
        Timestamp ultimaModificacion = this.ultimaModificacion == null ? new Timestamp(System.currentTimeMillis()) : this.ultimaModificacion;
        return new ServiciosEvento(idServicioEvento, evento, servicio, ultimaModificacion, active);
    }
}