package utez.edu.mx.foodster.services.direccionesusuario;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.entities.direccionesusuario.DireccionesUsuario;
import utez.edu.mx.foodster.entities.direccionesusuario.DireccionesUsuarioRepository;
import utez.edu.mx.foodster.entities.usuarios.Usuarios;
import utez.edu.mx.foodster.entities.usuarios.UsuariosRepository;
import utez.edu.mx.foodster.utils.Response;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
public class DireccionesUsuarioServices {
    private final DireccionesUsuarioRepository repository;
    private final UsuariosRepository usuariosRepository;

    public DireccionesUsuarioServices(DireccionesUsuarioRepository repository, UsuariosRepository usuariosRepository) {
        this.repository = repository;
        this.usuariosRepository = usuariosRepository;
    }

    @Transactional(readOnly = true)
    public Response<List<DireccionesUsuario>> getALl(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(readOnly = true)
    public Response<List<DireccionesUsuario>> getAllByUsuarios(String id_usuario){
        Optional<Usuarios> usuario = this.usuariosRepository.findById(id_usuario);
        if(usuario.isPresent()){
            return new Response<>(
                    this.repository.findAllByUsuarios(usuario.get()),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "No encontrado"
        );
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<DireccionesUsuario> insert(DireccionesUsuario direccionesUsuario){
        return new Response<>(
                this.repository.save(direccionesUsuario),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<DireccionesUsuario> update(DireccionesUsuario direccionesUsuario){
        Optional<DireccionesUsuario> entity = this.repository.findById(direccionesUsuario.getIdDireccionUsuario());
        if(entity.isPresent()){
            return new Response<>(
                    this.repository.saveAndFlush(direccionesUsuario),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "No encontrado"
        );
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<Boolean> delete(String id){
        Optional<DireccionesUsuario> entity = this.repository.findById(id);
        if(entity.isPresent()){
            this.repository.delete(entity.get());
            return new Response<>(
                    true,
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "No encontrado"
        );
    }
}
