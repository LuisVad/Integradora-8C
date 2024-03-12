package utez.edu.mx.Integradora8C.Dtos.Paquetes;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import utez.edu.mx.Integradora8C.Entities.Paquetes.Paquetes;

import java.sql.Timestamp;


public class PaquetesDto {

    private String idPaquete;

    @NotBlank(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción no puede ser nula")
    @Size(min = 5, max = 70, message = "La descripción debe tener entre 5 y 70 caracteres")
    private String descripcion;

    @NotBlank(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String recomendadoPara;

    @NotBlank(message = "La imagen no puede ser nula")
    private String imagen;

    private long numeroPedidos;

    private Timestamp ultimaModificacion;

    private boolean active;

    public Paquetes toEntity(){
        Timestamp ultimaModificacion = this.ultimaModificacion == null ? new Timestamp(System.currentTimeMillis()) : this.ultimaModificacion;
        return new Paquetes(idPaquete, nombre, descripcion, recomendadoPara, imagen, numeroPedidos, ultimaModificacion, active);
    }
}
