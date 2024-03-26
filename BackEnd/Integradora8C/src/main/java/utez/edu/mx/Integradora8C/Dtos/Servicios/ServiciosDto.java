package utez.edu.mx.Integradora8C.Dtos.Servicios;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.Integradora8C.Entities.CategoriasServicios.CategoriasServicios;
import utez.edu.mx.Integradora8C.Entities.Servicios.Servicios;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiciosDto {
    private String idServicio;
    @NotBlank(message = "El nombre no puede ser nulo")
    private String nombre;
    @NotBlank(message = "La descripción no puede ser nula")
    private String descripcion;
    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser positivo")
    private Double precio;
    @PositiveOrZero(message = "El precio de descuento debe ser positivo o cero")
    private Double precio_descuento;
    @NotBlank(message = "La imagen no puede ser nula")
    private String imagen;
    @PositiveOrZero(message = "Las existencias deben ser positivas o cero")
    private Long existencias;
    @NotNull(message = "La categoría no puede ser nula")
    private CategoriasServicios categoria;
    private Timestamp ultimaModificacion;
    private Boolean active;

    public Servicios toEntity(){
        Timestamp ultimaModificacion = this.ultimaModificacion == null ? new Timestamp(System.currentTimeMillis()) : this.ultimaModificacion;
        return new Servicios(idServicio, nombre, descripcion, precio, precio_descuento, imagen, existencias, categoria, ultimaModificacion, active);
    }
}