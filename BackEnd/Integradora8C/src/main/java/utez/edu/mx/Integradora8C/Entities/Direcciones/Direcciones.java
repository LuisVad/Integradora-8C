package utez.edu.mx.Integradora8C.Entities.Direcciones;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;

@Entity
@Table(name = "direcciones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Direcciones {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_direccion")
    private String idDireccion;

    @Column(name = "calle", columnDefinition = "VARCHAR(100) NOT NULL", nullable = false)
    private String calle;

    @Column(name = "colonia", columnDefinition = "VARCHAR(100) NOT NULL", nullable = false)
    private String colonia;

    @Column(name = "numero", columnDefinition = "VARCHAR(10) NOT NULL", nullable = false)
    private String numero;

    @Column(name = "codigo_postal", columnDefinition = "VARCHAR(5) NOT NULL", nullable = false)
    private String codigoPostal;

    @Column(name = "municipio", columnDefinition = "VARCHAR(100) NOT NULL", nullable = false)
    private String municipio;

    @Column(name = "estado", columnDefinition = "VARCHAR(100) NOT NULL", nullable = false)
    private String estado;

    @Column(name = "referencias", columnDefinition = "VARCHAR(255) NOT NULL", nullable = true)
    private String referencias;

    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaModificacion;

    @Column( columnDefinition = "BOOLEAN DEFAULT TRUE")
    @JsonIgnore
    private Boolean active;
}