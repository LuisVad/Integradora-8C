package utez.edu.mx.foodster.entities.calificaciones;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import utez.edu.mx.foodster.entities.categoriasservicios.CategoriasServicios;
import utez.edu.mx.foodster.entities.paquetes.Paquetes;

import java.sql.Timestamp;

@Entity
@Table(name = "calificaciones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Calificaciones {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid")
    @Column(name = "id_calificacion")
    private String idCalificacion;
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = true)
    private CategoriasServicios categoriasServicios;
    @ManyToOne
    @JoinColumn(name = "id_paquete", nullable = true)
    private Paquetes paquetes;
    @Column(name = "calificacion", columnDefinition = "INT NOT NULL", nullable = false)
    private int calificacion;
    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaModificacion;
    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean active;
}
