package utez.edu.mx.foodster.dtos.eventos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.foodster.entities.direcciones.Direcciones;
import utez.edu.mx.foodster.entities.eventos.Eventos;
import utez.edu.mx.foodster.entities.usuarios.Usuarios;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventosDto {

    private String idEvento;

    @NotBlank(message = "La fecha y hora de inicio no pueden ser nulas")
    private Timestamp fechaHoraInicio;

    @NotBlank(message = "La fecha y hora de fin no pueden ser nulas")
    private Timestamp fechaHoraFin;

    @NotBlank(message = "El número de personas no puede ser nulo")
    private Long numeroPersonas;

    @NotNull(message = "La dirección no puede ser nula")
    private Direcciones direccion;

    @NotNull(message = "El usuario no puede ser nulo")
    private Usuarios usuario;

    private Double costoTotal;

    private Boolean personalizado;

    private Timestamp ultimaModificacion;

    private Boolean active;

    public Eventos toEntity() {
        this.ultimaModificacion = new Timestamp(System.currentTimeMillis());
        return new Eventos(idEvento, fechaHoraInicio, fechaHoraFin, numeroPersonas, costoTotal, personalizado, usuario, direccion, ultimaModificacion, active);
    }
}