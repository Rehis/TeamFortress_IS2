package com.tienda.api.ApiRest.service;

import com.tienda.api.ApiRest.model.Usuario;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository ar) {
        this.usuarioRepository = ar;
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
