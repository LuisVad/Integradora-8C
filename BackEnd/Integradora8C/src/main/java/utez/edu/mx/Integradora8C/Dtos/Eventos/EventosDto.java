package utez.edu.mx.Integradora8C.Dtos.Eventos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.Integradora8C.Entities.Eventos.Eventos;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventosDto {

    private String idEvento;

    private Timestamp fechaHoraInicio;

    private Timestamp fechaHoraFin;

    private Long numeroPersonas;

    private Double costoTotal;

    private Boolean personalizado;

    private Timestamp ultimaModificacion;

    private Boolean active;

    public Eventos toEntity(){
        Timestamp ultimaModificacion = this.ultimaModificacion == null ? new Timestamp(System.currentTimeMillis()) : this.ultimaModificacion;
        return new Eventos(idEvento, fechaHoraInicio, fechaHoraFin, numeroPersonas, costoTotal, personalizado, ultimaModificacion, active);
    }
}
