package com.tienda.api.ApiRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import com.tienda.api.ApiRest.model.*;

@RestController
public class ArticuloController {
	
	@Autowired
	private ArticuloService articuloService;
	
	@GetMapping("api/articulo")
	public List<Articulo> obtenerArticulos(){
		List<Articulo> listaArticulos = new ArrayList<>();
		Articulo a = new Articulo();
		Articulo a2 = new Articulo();
		
		a.setId(1);
		a.setNombre("nachos");
		a.setPrecio(2.50);
		a.setCategoria("comida");
		a.setDescripcion("unos nachos");
		
		a2.setId(2);
		a2.setNombre("queso en lonchas");
		a2.setPrecio(1.23);
		a2.setCategoria("comida");
		a2.setDescripcion("queso pero ahora en lonchas");
		
		listaArticulos.add(a);
		listaArticulos.add(a2);
		
		return listaArticulos;
	}

	@PostMapping("api/articulos")
	public Articulo guardarArticulo(@RequestBody Articulo a) {
		System.out.println(a);
		articuloService.guardar(a);
		return a;
	}
	
	@GetMapping("api/articulos")
	public List<Articulo> obtener(){
		return articuloService.obtenerTodos();
	}
	
	@GetMapping("api/articulos/{id}")
	public Articulo obtenerArticulo(@PathVariable("id") Integer id) {
		return articuloService.obtenerArticulo(id);
	}
	
	@PutMapping("api/articulos")
	public void actualizarArticulo(@RequestBody Articulo a) {
		articuloService.actualizar(a);
	}
	
	@DeleteMapping("api/articulos/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		articuloService.eliminar(id);
	}
	
}