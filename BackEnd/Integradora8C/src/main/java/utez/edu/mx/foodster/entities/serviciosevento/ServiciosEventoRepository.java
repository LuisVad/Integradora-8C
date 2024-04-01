package utez.edu.mx.foodster.entities.serviciosevento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiciosEventoRepository extends JpaRepository<ServiciosEvento, String> {
    List<ServiciosEvento> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);

    ServiciosEvento findByIdServicioEventoAndActive(String idServicioEvento, Boolean active);

    @Query(value = "SELECT * FROM servicios_evento se WHERE se.id_evento = ?1 AND se.active = ?2 ORDER BY se.ultima_modificacion DESC", nativeQuery = true)
    List<ServiciosEvento> findAllByEventoAndActiveOrderByUltimaModificacionDesc(String idEvento, Boolean active);
}
