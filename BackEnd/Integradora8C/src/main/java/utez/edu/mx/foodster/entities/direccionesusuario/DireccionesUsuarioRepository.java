package utez.edu.mx.foodster.entities.direccionesusuario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utez.edu.mx.foodster.entities.usuarios.Usuarios;

import java.util.List;

@Repository
public interface DireccionesUsuarioRepository extends JpaRepository<DireccionesUsuario, String> {
    List<DireccionesUsuario> findAllByUsuarios(Usuarios usuarios);

    List<DireccionesUsuario> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}