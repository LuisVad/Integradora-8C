package utez.edu.mx.Integradora8C.Dtos.Personal;

import jakarta.validation.constraints.NotBlank;
import utez.edu.mx.Integradora8C.Entities.CategoriasPersonal.CategoriasPersonal;
import utez.edu.mx.Integradora8C.Entities.Personal.Personal;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;

import java.sql.Timestamp;

public class PersonalDto {

    private String idPersonal;

    @NotBlank(message = "El usuario no puede ser nulo")
    private Usuarios usuarios;

    @NotBlank(message = "La categoria no puede ser nula")
    private CategoriasPersonal categoria;

    private Timestamp ultimaModificacion;

    private Boolean active;

    public Personal toEntity() {
        Timestamp ultimaModificacion = this.ultimaModificacion == null ? new Timestamp(System.currentTimeMillis()) : this.ultimaModificacion;
        return new Personal(idPersonal, usuarios, categoria, ultimaModificacion, true);
    }
}