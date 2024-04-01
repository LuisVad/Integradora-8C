package utez.edu.mx.foodster.dtos.eventos;

import lombok.*;
import utez.edu.mx.foodster.dtos.servicios.ServiciosDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class EventosConServicios {
    private EventosDto evento;
    private List<ServiciosDto> servicios;
}
