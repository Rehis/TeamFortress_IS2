package com.tienda.api.ApiRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.api.ApiRest.model.Articulo;

@Service
public class ArticuloService {
	
	@Autowired
	private ArticuloRepository articuloRepository;
	
	public void guardar(Articulo a) {
		articuloRepository.save(a);
	}
	
	public List<Articulo> obtenerTodos(){
		return articuloRepository.findAll();
	}
	
	public Articulo obtenerArticulo(Integer id) {
		return articuloRepository.getOne(id);
	}
	
	public void actualizar(Articulo a) {
		articuloRepository.save(a);
	}
	
	public void eliminar(Integer id) {
		articuloRepository.deleteById(id);
	}
	
}
