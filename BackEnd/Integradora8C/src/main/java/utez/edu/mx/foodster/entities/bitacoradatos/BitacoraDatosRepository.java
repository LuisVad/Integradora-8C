package utez.edu.mx.foodster.entities.bitacoradatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraDatosRepository extends JpaRepository<BitacoraDatos, String> {

}
