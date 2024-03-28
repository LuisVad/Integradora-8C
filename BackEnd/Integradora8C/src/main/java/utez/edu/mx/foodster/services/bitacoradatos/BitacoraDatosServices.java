package utez.edu.mx.foodster.services.bitacoradatos;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.entities.bitacoradatos.BitacoraDatos;
import utez.edu.mx.foodster.entities.bitacoradatos.BitacoraDatosRepository;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@Service
@Transactional
public class BitacoraDatosServices {
    private final BitacoraDatosRepository repository;

    public BitacoraDatosServices(BitacoraDatosRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Response<List<BitacoraDatos>> getAll() {
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
}
