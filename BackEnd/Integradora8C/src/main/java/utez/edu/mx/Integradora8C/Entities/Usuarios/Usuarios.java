package utez.edu.mx.Integradora8C.Entities.Usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuarios {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_usuario", columnDefinition = "char")
    private String idUsuario;

    @Column(name = "nombres", columnDefinition = "clob")
    private String nombres;

    @Column(name = "primer_apellido", columnDefinition = "clob")
    private String primerApellido;

    @Column(name = "segundo_apellido", columnDefinition = "clob")
    private String segundoApellido;

    @Column(name = "telefono", columnDefinition = "clob")
    private String telefono;

    @Column(name = "correo", columnDefinition = "clob")
    private String correo;

    @Column(name = "ultima_modificacion")
    private Timestamp ultimaModificacion;

    @Column(name = "active", columnDefinition = "char(1)")
    private char active;

    //Aquí ira relación roles_id_rol
}
