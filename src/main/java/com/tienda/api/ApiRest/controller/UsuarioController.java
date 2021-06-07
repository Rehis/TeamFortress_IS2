package com.tienda.api.ApiRest.controller;

import com.tienda.api.ApiRest.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.api.ApiRest.model.*;
import com.tienda.api.ApiRest.service.UsuarioService;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuario) {
        this.usuarioService = usuario;
    }

    @RequestMapping("/usuarios/crear")
    public String mostrarFormAlta(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
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
        return "listado";
    }

    @RequestMapping("/logout")
    public String cerrarSesion(Model modelo) {
        return "listado";
    }
}
