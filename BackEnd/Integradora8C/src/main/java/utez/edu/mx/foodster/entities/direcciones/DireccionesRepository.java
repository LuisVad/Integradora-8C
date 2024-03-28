package utez.edu.mx.foodster.entities.direcciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionesRepository extends JpaRepository<Direcciones, String> {
    List<Direcciones> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}
