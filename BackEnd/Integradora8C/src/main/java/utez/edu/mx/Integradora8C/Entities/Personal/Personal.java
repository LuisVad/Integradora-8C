package utez.edu.mx.Integradora8C.Entities.Personal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import utez.edu.mx.Integradora8C.Entities.CategoriasPersonal.CategoriasPersonal;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;

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
    @Column(name = "id_personal")
    private String idPersonal;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuarios;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriasPersonal categoria;
    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaModificacion;
    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean active;
}
