package com.udea.registrosUsuarios.controladores;

import com.udea.registrosUsuarios.entidad.Usuarios;
import com.udea.registrosUsuarios.servicios.usuariosServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class usuariosControladores {

    @Autowired
    private usuariosServicios usuariosservicios;

    //añadir usuario
    @PostMapping ("/addUsuarios")
    public RedirectView saveUsuarios(@ModelAttribute Usuarios usuarios, Model model){
        model.addAttribute(usuarios);
        usuariosservicios.saveUsuario(usuarios);
        return new RedirectView("/Usuarios");
    }
    //redirect view



    //mostrar usuarios
    /*
    @GetMapping ("/Usuarios")
    public List<Usuarios> findAllUsuarios(){
        return usuariosservicios.getUsuarios();
    }
     */


//mostrar usuario especifico
@GetMapping("/Usuarios/{id}")
    public Usuarios findByID(@PathVariable Integer id){

        return usuariosservicios.getUsuariosById(id);
    }
//varios usuarios a la vez
    @PostMapping ("/saveUsuarios")

    public List<Usuarios>saveUsuarios(@RequestBody List<Usuarios> usuarios){
        return usuariosservicios.saveUsuarios(usuarios);
    }
    /*
    @PutMapping("/updateUsuarios")
    public Usuarios updateUsuarios(@RequestBody Usuarios usuarios){
       return usuariosservicios.updateusuarios(usuarios);
    }
    */

//eleminar
    @DeleteMapping ("/usuario/{id}")
    public RedirectView deleteUsuarios(@PathVariable Integer id){
        usuariosservicios.eliminarUsuario(id);
        return new RedirectView("/Usuarios");

    }
    @PatchMapping("/usuario/{id}")
    public RedirectView updateUsuario(@PathVariable ("id") Integer id ){
        usuariosservicios.markUsuarioDisponible(id);
        return new RedirectView("/Usuarios");
    }
    @PostMapping("/Usuario/update")
    public RedirectView updateUsuario(@ModelAttribute Usuarios usuarios ){
        usuariosservicios.updateusuarios(usuarios);
        return  new RedirectView("/Usuarios");
    }
}
