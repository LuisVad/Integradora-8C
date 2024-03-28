package utez.edu.mx.foodster.entities.serviciosevento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiciosEventoRepository extends JpaRepository<ServiciosEvento, String> {
    List<ServiciosEvento> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}
