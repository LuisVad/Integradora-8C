package utez.edu.mx.Integradora8C.Entities.Eventos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, String> {
    List<Eventos> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}
