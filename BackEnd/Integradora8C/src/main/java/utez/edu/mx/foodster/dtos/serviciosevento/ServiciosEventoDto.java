package utez.edu.mx.foodster.dtos.serviciosevento;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.foodster.entities.eventos.Eventos;
import utez.edu.mx.foodster.entities.servicios.Servicios;
import utez.edu.mx.foodster.entities.serviciosevento.ServiciosEvento;

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

    public ServiciosEvento toEntity() {
        this.ultimaModificacion = new Timestamp(System.currentTimeMillis());
        return new ServiciosEvento(idServicioEvento, evento, servicio, ultimaModificacion, active);
    }
}