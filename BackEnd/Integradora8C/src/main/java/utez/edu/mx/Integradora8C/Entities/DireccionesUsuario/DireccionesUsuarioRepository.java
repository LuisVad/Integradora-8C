package utez.edu.mx.Integradora8C.Entities.DireccionesUsuario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;

import java.util.List;

@Repository
public interface DireccionesUsuarioRepository extends JpaRepository<DireccionesUsuario, String> {
    List<DireccionesUsuario> findAllByUsuarios(Usuarios usuarios);
}
