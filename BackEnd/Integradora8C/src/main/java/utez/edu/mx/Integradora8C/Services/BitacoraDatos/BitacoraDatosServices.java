package utez.edu.mx.Integradora8C.Services.BitacoraDatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.BitacoraDatos.BitacoraDatos;
import utez.edu.mx.Integradora8C.Entities.BitacoraDatos.BitacoraDatosRepository;
import utez.edu.mx.Integradora8C.utils.Response;

import java.util.List;

@Service
@Transactional
public class BitacoraDatosServices {
    @Autowired
    private BitacoraDatosRepository repository;

    @Transactional(readOnly = true)
    public Response<List<BitacoraDatos>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
}
