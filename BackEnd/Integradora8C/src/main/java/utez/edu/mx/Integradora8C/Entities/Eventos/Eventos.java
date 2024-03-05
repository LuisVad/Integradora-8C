package utez.edu.mx.Integradora8C.Entities.Eventos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;

@Entity
@Table(name = "eventos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Eventos {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_evento")
    private String idEvento;
    @Column(name = "fecha_hora_inicio", columnDefinition = "TIMESTAMP NOT NULL")
    private Timestamp fechaHoraInicio;
    @Column(name = "fecha_hora_fin", columnDefinition = "TIMESTAMP NOT NULL")
    private Timestamp fechaHoraFin;
    @Column(name = "numero_personas", columnDefinition = "BIGINT NOT NULL")
    private Long numeroPersonas;
    @Column(name = "costo_total", columnDefinition = "DOUBLE NOT NULL")
    private Double costoTotal;
    @Column(name = "personalizado", columnDefinition = "BOOLEAN NOT NULL")
    private Boolean personalizado;
    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaModificacion;
    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean active;



}
