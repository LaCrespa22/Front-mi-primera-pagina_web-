package com.udea.registrosUsuarios.servicios;

import com.udea.registrosUsuarios.entidad.Usuarios;
import com.udea.registrosUsuarios.repositorio.usuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuariosServicios {
    //CRUD: ver,añadir,modificar,eliminar

    @Autowired
    private usuariosRepositorio usuariosRepository;

    public List<Usuarios> getUsuarios(){
        return usuariosRepository.findAll();
    }
    //uno
    public Usuarios saveUsuario (Usuarios usuario){

        return usuariosRepository.save(usuario);
    }

    public Usuarios getUsuariosById(Integer id){

        return usuariosRepository.findById(id).orElse(null);
    }

    //varios
    public List<Usuarios> saveUsuarios (List<Usuarios> usuarios){

        return usuariosRepository.saveAll(usuarios);
    }

    public void updateusuarios(Usuarios usuarios){

        Usuarios existeUsuario = usuariosRepository.findById(usuarios.getId()).orElse(null );
        assert existeUsuario != null;
        existeUsuario.setNombreUsuario(usuarios.getNombreUsuario());
        existeUsuario.setEdad(usuarios.getEdad());
        existeUsuario.setNumeroTelefono(usuarios.getNumeroTelefono());
        existeUsuario.setCorreoElectronico(usuarios.getCorreoElectronico());
        existeUsuario.setRolEmpresa(usuarios.getRolEmpresa());
        existeUsuario.setUsuarioDisponible(usuarios.isUsuarioDisponible());

        usuariosRepository.save(existeUsuario);

    }

    public String eliminarUsuario(Integer id){
        usuariosRepository.deleteById(id);
        return "El usuario"  + id + ", registrado anteriormente, ha sido eliminado exitoxamente";

    }

    public boolean markUsuarioDisponible(Integer id){
        Usuarios usuarios = usuariosRepository.findById(id).orElse(null);
        if (usuarios != null){
            usuarios.setUsuarioDisponible(true);
            usuariosRepository.save(usuarios);
            return true;
        }else{
            return false;
        }


    }


}
