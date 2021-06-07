package com.tienda.api.ApiRest.controller;

import com.tienda.api.ApiRest.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.api.ApiRest.model.*;
import com.tienda.api.ApiRest.service.ArticuloService;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    @RequestMapping("/usuarios/crear")
    public String mostrarFormAlta(Model modelo) {
        modelo.addAttribute("articulo", new Usuario());
        return "formUsuario";
    }

    @PostMapping("/usuarios/guardar")
    public String guardar(Usuario u) {
        //System.out.println(a);
        usuarioService.guardar(u);
        return "redirect:/";
    }

    @RequestMapping("/usuarios/login")
    public String iniciarSesion(Model modelo) {
        
    }
}
