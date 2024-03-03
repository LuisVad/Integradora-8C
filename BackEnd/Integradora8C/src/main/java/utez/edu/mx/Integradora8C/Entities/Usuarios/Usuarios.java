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
    @Column(name = "id_usuario")
    private String idUsuario;

    @Column(name = "nombres", columnDefinition = "VARCHAR(50) NOT NULL")
    private String nombres;

    @Column(name = "primer_apellido", columnDefinition = "VARCHAR(50) NOT NULL")
    private String primerApellido;

    @Column(name = "segundo_apellido", columnDefinition = "VARCHAR(50) NOT NULL")
    private String segundoApellido;

    @Column(name = "telefono", columnDefinition = "CHAR(10) NOT NULL")
    private String telefono;

    @Column(name = "correo", columnDefinition = "VARCHAR(255) NOT NULL")
    private String correo;

    @Column(name = "contrasena", columnDefinition = "VARCHAR(255) NOT NULL")
    private String contrasena;

    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaModificacion;

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private char active;

    //Aquí ira relación roles_id_rol
}
