package com.tienda.api.ApiRest.service;

import java.util.List;

import com.tienda.api.ApiRest.model.Usuario;
import com.tienda.api.ApiRest.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository ur) {
        this.usuarioRepository = ur;
    }

    public Usuario guardar(Usuario a) {
        return usuarioRepository.save(a);
    }

    public List<Usuario> buscar(String nombre) {
        return usuarioRepository.buscar(nombre);
    }

    public List<Usuario> buscar(int id) {
        return usuarioRepository.buscar(id);
    }

}
