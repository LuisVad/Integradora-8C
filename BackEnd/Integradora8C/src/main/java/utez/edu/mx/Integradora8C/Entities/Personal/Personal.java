package utez.edu.mx.Integradora8C.Entities.Personal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;

@Entity
@Table(name = "personal")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Personal {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_personal", columnDefinition = "char")
    private String idPersonal;

    //Aquí ira relación categorias_personal_id_categoria

    //Aquí ira relación usuarios_id_usuario

    @Column(name = "ultima_modificacion")
    private Timestamp ultimaModificacion;

    @Column(name = "active", columnDefinition = "char(1)")
    private char active;

}
