package utez.edu.mx.foodster.entities.bitacoradatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BitacoraDatosRepository extends JpaRepository<BitacoraDatos, String> {

    List<BitacoraDatos> findAllByOrderByCreadoEnDesc();



}
