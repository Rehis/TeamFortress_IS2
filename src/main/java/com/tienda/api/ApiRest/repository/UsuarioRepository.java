package com.tienda.api.ApiRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tienda.api.ApiRest.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{
	
	
	@Query("from Usuario u order by u.mail")
    List<Usuario> buscarTodos();
    
    @Query("from Usuario u where u.mail like %?1%")
    List<Usuario> buscar(String mail);

    @Query("from Usuario u where u.id like ?1")
    List<Usuario> buscar(int id);
    
}
