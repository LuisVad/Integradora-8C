package utez.edu.mx.foodster.entities.servicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, String> {
    List<Servicios> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);

    Servicios findByIdServicioAndActive(String idServicio, Boolean active);


    @Query(value = "SELECT * FROM servicios WHERE id_categoria = :idCategoria AND active = :active ORDER BY ultima_modificacion DESC", nativeQuery = true)
    List<Servicios> findAllByCategoriasAndActiveOrderByUltimaModificacionDesc(String idCategoria, Boolean active);
}
