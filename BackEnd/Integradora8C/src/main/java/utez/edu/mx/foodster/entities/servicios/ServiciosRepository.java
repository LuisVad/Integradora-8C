package utez.edu.mx.foodster.entities.servicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, String> {
    List<Servicios> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}
