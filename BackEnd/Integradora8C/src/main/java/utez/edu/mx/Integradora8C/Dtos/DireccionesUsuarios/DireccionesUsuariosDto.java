package utez.edu.mx.Integradora8C.Dtos.DireccionesUsuarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.Integradora8C.Entities.Direcciones.Direcciones;
import utez.edu.mx.Integradora8C.Entities.DireccionesUsuario.DireccionesUsuario;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DireccionesUsuariosDto {

    private String idDireccionUsuario;

    private Direcciones direcciones;

    private Usuarios usuarios;

    private Timestamp ultimaModificacion;

    private Boolean active;

    public DireccionesUsuario toEntity() {
        Timestamp ultimaModificacion = this.ultimaModificacion == null ? new Timestamp(System.currentTimeMillis()) : this.ultimaModificacion;
        return new DireccionesUsuario(idDireccionUsuario, direcciones, usuarios, ultimaModificacion, active);
    }
}
