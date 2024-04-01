package utez.edu.mx.foodster.entities.categoriaspersonal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriasPersonalRepository extends JpaRepository<CategoriasPersonal, String> {

    List<CategoriasPersonal> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
    CategoriasPersonal findByNombreAndActive(String nombre, Boolean active);
    CategoriasPersonal findByIdCategoriaAndActive(String idCategoria, Boolean active);
}
