package com.tienda.api.ApiRest.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tienda.api.ApiRest.model.Articulo;
import com.tienda.api.ApiRest.service.ArticuloService;

@Controller
public class ListadoController {

	private final ArticuloService articuloService;
	
	public ListadoController(ArticuloService articulo) {
		this.articuloService = articulo;
	}
	
	@RequestMapping("/")
	public String listarVideojuegos(Model modelo){
	    List<Articulo> lista = articuloService.buscarTodos();
	    modelo.addAttribute("destacados", lista);
	    return "listado";
	}
	
	 @RequestMapping("/buscar")
	 public String buscar(Model modelo, @RequestParam("q")String consulta) {
	    List<Articulo> lista = articuloService.buscar(consulta);
	    modelo.addAttribute("listado", lista);
	    return "listado";
	 }
	
}
