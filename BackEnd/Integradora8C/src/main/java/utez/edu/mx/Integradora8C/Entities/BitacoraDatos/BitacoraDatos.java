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

import java.sql.Timestamp;


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
    @Column(name = "id")
    private String id;
    @Column(columnDefinition = "json")
    @Type(JsonType.class)
    private JsonNode datos;

    @Column(name = "metodo", columnDefinition = "TEXT NOT NULL", nullable = false)
    private String metodo;

    @Column(name = "ruta_solicitada", columnDefinition = "TEXT NOT NULL", nullable = false)
    private String rutaSolicitada;

    @Column(name = "ip", columnDefinition = "TEXT NOT NULL", nullable = false)
    private String ip;

    @Column(name = "agente_usuario", columnDefinition = "TEXT NOT NULL", nullable = false)
    private String agenteUsuario;

    @Column(name = "estado_http", columnDefinition = "SMALLINT NOT NULL", nullable = false)
    private int estadoHttp;

    @Column(name = "creado_en", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp creadoEn;
}