package utez.edu.mx.Integradora8C.Entities.ServiciosPaquete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import utez.edu.mx.Integradora8C.Entities.Paquetes.Paquetes;
import utez.edu.mx.Integradora8C.Entities.Servicios.Servicios;

import java.sql.Timestamp;

@Entity
@Table(name = "servicios_paquete")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiciosPaquete {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_servicio_paquete")
    private String idServicioPaquete;
    @ManyToOne
    @JoinColumn(name = "id_paquete")
    private Paquetes paquete;
    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicios servicio;
    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaModificacion;
    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean active;


}
