package utez.edu.mx.Integradora8C.Dtos.PersonalEvento;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.Integradora8C.Entities.Eventos.Eventos;
import utez.edu.mx.Integradora8C.Entities.Personal.Personal;
import utez.edu.mx.Integradora8C.Entities.PersonalEvento.PersonalEvento;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonalEventoDto {
    private String idPersonalEvento;
    @NotBlank(message = "El personal no puede ser nulo")
    private Personal personal;
    @NotBlank(message = "El evento no puede ser nulo")
    private Eventos eventos;
    private Timestamp ultimaModificacion;
    private Boolean active;

    public PersonalEvento toEntity(){
        PersonalEvento personalEvento = new PersonalEvento();
        personalEvento.setIdPersonalEvento(this.idPersonalEvento);
        personalEvento.setPersonal(this.personal);
        personalEvento.setEventos(this.eventos);
        personalEvento.setUltimaModificacion(this.ultimaModificacion);
        personalEvento.setActive(active);
        return personalEvento;
    }
}
