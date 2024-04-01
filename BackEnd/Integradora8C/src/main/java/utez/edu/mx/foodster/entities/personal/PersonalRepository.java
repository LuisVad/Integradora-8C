package utez.edu.mx.foodster.entities.personal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, String> {

    List<Personal> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);


    Personal findByIdPersonalAndActive(String idPersonal, Boolean active);


}
