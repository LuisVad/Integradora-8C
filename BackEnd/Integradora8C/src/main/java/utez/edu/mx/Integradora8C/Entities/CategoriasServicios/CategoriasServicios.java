package utez.edu.mx.Integradora8C.Entities.CategoriasServicios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;

@Entity
@Table(name = "categorias_servicios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriasServicios {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_categoria")
    private String idCategoria;

    @Column(name = "nombre", columnDefinition = "TEXT NOT NULL", nullable = false)
    private String nombre;

    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaModificacion;

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean active;

}