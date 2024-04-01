package utez.edu.mx.foodster.entities.calificaciones;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import utez.edu.mx.foodster.entities.paquetes.Paquetes;
import utez.edu.mx.foodster.entities.servicios.Servicios;

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
    @UuidGenerator
    @Column(name = "id_calificacion")
    private String idCalificacion;
    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = true)
    private Servicios servicios;
    @ManyToOne
    @JoinColumn(name = "id_paquete", nullable = true)
    private Paquetes paquetes;
    @Column(name = "calificacion", columnDefinition = "INT NOT NULL", nullable = false)
    private int calificacion;
    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;
    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaModificacion;
    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean active;
}
