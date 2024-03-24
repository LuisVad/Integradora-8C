package utez.edu.mx.Integradora8C.Services.DireccionesUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.DireccionesUsuario.DireccionesUsuario;
import utez.edu.mx.Integradora8C.Entities.DireccionesUsuario.DireccionesUsuarioRepository;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;
import utez.edu.mx.Integradora8C.Entities.Usuarios.UsuariosRepository;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
public class DireccionesUsuarioServices {
    @Autowired
    private DireccionesUsuarioRepository repository;
    @Autowired
    private UsuariosRepository usuariosRepository;
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
