package com.tienda.api.ApiRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tienda.api.ApiRest.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{
	
	
	@Query("from Articulo a order by u.nombre")
    List<Usuario> buscarTodos();
    
    @Query("from Articulo a where u.mail like %?1%")
    List<Usuario> buscar(String mail);

    @Query("from Articulo a where u.id like ?1")
    List<Usuario> buscar(int id);
    
}
