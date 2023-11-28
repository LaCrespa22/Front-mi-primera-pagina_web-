package com.udea.registrosUsuarios.controladores;

import com.udea.registrosUsuarios.entidad.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import com.udea.registrosUsuarios.servicios.usuariosServicios;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class frontControladores {
    @Autowired
    usuariosServicios usuariosservices;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
        }
        return "index";
    }

    @GetMapping("/Usuarios")

public String usuario(Model model){

        List<Usuarios> usuarios = usuariosservices.getUsuarios();
        model.addAttribute("usuario", usuarios  );
    return "usuarios";
}

@GetMapping("/Usuarios/newUsuario")
public String newUsuario(Model model){
        model.addAttribute("usuario" , new Usuarios());
        return "newUsuario";
}

    @GetMapping("/Usuarios/guardarEdicion/{id}")
    public String editarUsuario(@PathVariable Integer id, Model model){
        Usuarios usuarios = usuariosservices.getUsuariosById(id);

        if (usuarios != null){
            model.addAttribute("usuario", usuarios);
            return "editarUsuario";
        } else {
            return "redirect:/Usuarios";
        }
    }

}


