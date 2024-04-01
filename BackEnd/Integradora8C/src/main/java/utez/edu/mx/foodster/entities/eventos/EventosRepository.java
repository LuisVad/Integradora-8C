package utez.edu.mx.foodster.entities.eventos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, String> {
    List<Eventos> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);

    @Query(value = "SELECT * FROM eventos WHERE id_usuario = ?1 AND active = ?2", nativeQuery = true)
    List<Eventos> findAllByIdUsuarioAndActive(String idUsuario, Boolean active);


    Eventos findByIdEventoAndActive(String idEvento, Boolean active);
}
