package utez.edu.mx.Integradora8C.Entities.Servicios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import utez.edu.mx.Integradora8C.Entities.CategoriasServicios.CategoriasServicios;

import java.sql.Timestamp;

@Entity
@Table(name = "servicios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Servicios {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_servicio")
    private String idServicio;
    @Column(name = "nombre", columnDefinition = "TEXT NOT NULL", nullable = false)
    public String nombre;
    @Column(name = "descripcion", columnDefinition = "TEXT NOT NULL", nullable = false)
    public String descripcion;
    @Column(name = "precio", columnDefinition = "DOUBLE NOT NULL", nullable = false)
    public Double precio;
    @Column(name = "precio_descuento", columnDefinition = "DOUBLE")
    public Double precio_descuento;
    @Column(name = "imagen", columnDefinition = "MEDIUMTEXT NOT NULL", nullable = false)
    public String imagen;
    @Column(name = "existencias", columnDefinition = "BIGINT")
    public Long existencias;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    public CategoriasServicios categoria;
    @Column(name = "ultima_modificacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Timestamp ultimaModificacion;
    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    public Boolean active;
}
