package utez.edu.mx.Integradora8C.Entities.ServiciosEvento;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import utez.edu.mx.Integradora8C.Entities.Eventos.Eventos;
import utez.edu.mx.Integradora8C.Entities.Paquetes.Paquetes;
import utez.edu.mx.Integradora8C.Entities.Servicios.Servicios;

import java.sql.Timestamp;

@Entity
@Table(name = "servicios_evento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiciosEvento {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_servicio_evento")
    private String idServicioEvento;
    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Eventos evento;
    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicios servicio;
    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaModificacion;
    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean active;


}

