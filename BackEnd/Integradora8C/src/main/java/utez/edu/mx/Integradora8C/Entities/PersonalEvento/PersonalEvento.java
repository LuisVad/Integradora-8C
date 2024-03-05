package utez.edu.mx.Integradora8C.Entities.PersonalEvento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import utez.edu.mx.Integradora8C.Entities.Eventos.Eventos;
import utez.edu.mx.Integradora8C.Entities.Personal.Personal;

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
    @GenericGenerator(name = "uuid", strategy = "uuid2")
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
    private char active;
}
