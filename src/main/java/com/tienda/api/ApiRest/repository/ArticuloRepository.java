package com.tienda.api.ApiRest.repository;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tienda.api.ApiRest.model.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{
	

    @Query("from Articulo a order by a.nombre")
    List<Articulo> buscarTodos();
    
    @Query("from Articulo a where a.nombre like %?1%")
    List<Articulo> buscar(String nombre);

    @Query("from Articulo a where a.id like ?1")
    List<Articulo> buscar(int id);
    
    @Query("from Articulo a where a.categoria in ?1")
    List<Articulo> filtrar(String[] categorias);
	
    @Query("from Articulo a where a.categoria like %?1%")
    List<Articulo> buscarCat(String categorias);
	
    
    /*Esta funcion hace lo mismo que buscar pero es generada por JPA automaticamente
    Esto es debido a que por el nombre findBy deduce que es busqueda con Nombre busca el parametro
    nombre y luego con Containing se encargara de aquello que contengan el nombre*/
    //List<Videojuego> findByNombreContaining(String consulta); 
    
}
