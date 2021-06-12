package com.tienda.api.ApiRest.controller;

import com.tienda.api.ApiRest.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.api.ApiRest.model.*;
import com.tienda.api.ApiRest.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuario) {
        this.usuarioService = usuario;
    }

    @RequestMapping("/usuarios/registrar")
    public String mostrarFormAlta(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "formUsuario";
    }

    @PostMapping("/usuarios/guardar")
    public String guardar(Usuario u) {
        usuarioService.guardar(u);
        return "redirect:/";
    }

    @RequestMapping("/usuarios/login")
    public String iniciarSesion(Model modelo, @RequestParam("m")String mail, @RequestParam("p")String password) {
        List<Usuario> usuarios = usuarioService.buscar(mail);
        for (Usuario u : usuarios) {
            if (u.getPassword().equals(password)) {
                modelo.addAttribute("usuario", u);
                break;
            }
        }
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String cerrarSesion(Model modelo) {
        modelo.addAttribute("usuario", null);
        return "redirect:/";
    }
}
