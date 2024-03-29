package utez.edu.mx.foodster.entities.personalevento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import utez.edu.mx.foodster.entities.eventos.Eventos;
import utez.edu.mx.foodster.entities.personal.Personal;

import java.sql.Timestamp;

@Entity
@Table(name = "personal_evento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonalEvento {

    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    @Column(name = "id_personal_evento")
    private String idPersonalEvento;

    //Aquí ira relación personal_id_personal

    @ManyToOne
    @JoinColumn(name = "id_personal")
    private Personal personal;

    //Aquí ira relación eventos_id_evento

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Eventos eventos;

    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaModificacion;

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean active;
}
