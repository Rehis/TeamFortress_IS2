package com.tienda.api.ApiRest.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tienda.api.ApiRest.model.Articulo;
import com.tienda.api.ApiRest.repository.ArticuloRepository;

@Service
public class ArticuloService {
	
	
	private ArticuloRepository articuloRepository;
	
	public ArticuloService(ArticuloRepository ar) {
		this.articuloRepository = ar;
	}
	
	public Articulo guardar(Articulo a) {
		return articuloRepository.save(a);
	}
	
	public List<Articulo> buscar(String nombre) {
		return articuloRepository.buscar(nombre);
	}
	
	public List<Articulo> buscarTodos(){
		return articuloRepository.buscarTodos();
	}
	
	/*public Articulo obtenerArticulo(Integer id) {
		return articuloRepository.getOne(id);
	}*/
	
	/*public void actualizar(Articulo a) {
		articuloRepository.save(a);
	}*/
	/*
	public void eliminar(Integer id) {
		articuloRepository.deleteById(id);
	}*/
	
}
