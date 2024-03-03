package utez.edu.mx.Integradora8C.Entities.BitacoraDatos;

import com.fasterxml.jackson.databind.JsonNode;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "bitacora")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BitacoraDatos {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(columnDefinition = "json")
    @Type(JsonType.class)
    private JsonNode datos;

    @Column(name = "metodo", columnDefinition = "VARCHAR(10) NOT NULL", nullable = false)
    private String metodo;

    @Column(name = "ruta_solicitada", columnDefinition = "VARCHAR(100) NOT NULL", nullable = false)
    private String rutaSolicitada;

    @Column(name = "ip", columnDefinition = "VARCHAR(15) NOT NULL", nullable = false)
    private String ip;

    @Column(name = "agente_usuario", columnDefinition = "VARCHAR(255) NOT NULL", nullable = false)
    private String agenteUsuario;

    @Column(name = "estado_http", columnDefinition = "INT NOT NULL", nullable = false)
    private int estadoHttp;

    @Column(name = "creado_en", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String creadoEn;
}