package utez.edu.mx.Integradora8C.Entities.BitacoraDatos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;

@Entity
@Table(name = "bitacora_datos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BitacoraDatos {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_movimiento", columnDefinition = "char")
    private String idMovimiento;

    @Column(name = "tipo_peticion", columnDefinition = "clob")
    private String tipoPeticion;

    @Column(name = "carga_json", columnDefinition = "clob")
    private String cargaJson;

    @Column(name = "ip", columnDefinition = "clob")
    private String ip;

    @Column(name = "creado_el")
    private Timestamp creadoEl;

    @Column(name = "active", columnDefinition = "char(1)")
    private char active;

    //Aquí ira relación usuarios_id_usuario
}
