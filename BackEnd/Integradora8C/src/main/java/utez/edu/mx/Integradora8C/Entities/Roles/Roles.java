package utez.edu.mx.Integradora8C.Entities.Roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Roles {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_rol", columnDefinition = "char")
    private String idRol;

    @Column(name = "nombre", columnDefinition = "clob")
    private String nombre;

    @Column(name = "ultima_modificacion")
    private Timestamp ultimaModificacion;

    @Column(name = "active", columnDefinition = "char(1)")
    private char active;

    //Relación
}
