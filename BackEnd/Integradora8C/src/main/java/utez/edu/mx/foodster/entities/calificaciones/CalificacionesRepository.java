package utez.edu.mx.foodster.entities.calificaciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CalificacionesRepository extends JpaRepository<Calificaciones, String> {
    List<Calificaciones> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}
