package utez.edu.mx.Integradora8C.Entities.PersonalEvento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
    @Column(name = "id_personal_evento", columnDefinition = "char")
    private String idPersonalEvento;

    //Aquí ira relación personal_id_personal

    //Aquí ira relación eventos_id_evento

    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaModificacion;

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private char active;
}
