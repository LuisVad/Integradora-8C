package utez.edu.mx.Integradora8C.Entities.DireccionesUsuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import utez.edu.mx.Integradora8C.Entities.Direcciones.Direcciones;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;

@Entity
@Table(name = "direcciones_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DireccionesUsuario {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_direccion_usuario")
    private String idDireccionUsuario;
    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Direcciones direcciones;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuarios;
}
