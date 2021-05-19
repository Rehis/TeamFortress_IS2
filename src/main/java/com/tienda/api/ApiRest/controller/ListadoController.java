package com.tienda.api.ApiRest.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.tienda.api.ApiRest.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tienda.api.ApiRest.model.Articulo;
import com.tienda.api.ApiRest.service.ArticuloService;
import com.tienda.api.ApiRest.service.RecommenderService;

@Controller
public class ListadoController {

	private final ArticuloService articuloService;
	private final RecommenderService recommenderService;
	
	public ListadoController(ArticuloService articulo, RecommenderService recommenderService) {
		this.articuloService = articulo;
		this.recommenderService = recommenderService;
	}
	
	@RequestMapping("/")
	public String listarArticulos(Model modelo){
		List<Pair<Articulo, Boolean>> lista = new ArrayList<>();
	    List<Articulo> buscados = articuloService.buscarTodos();
	    lista = rec(buscados, false);
	    modelo.addAttribute("listado", lista);
	    return "listado";
	}
	
	 @RequestMapping("/buscar")
	 public String buscar(Model modelo, @RequestParam("q")String consulta) {
	    List<Pair<Articulo, Boolean>> lista = new ArrayList<>();
	    List<Articulo> buscados = articuloService.buscar(consulta);
	    List<Articulo> recomendados = recommenderService.recomendados(consulta, buscados);
	    lista.addAll(rec(buscados, false));
	    lista.addAll(rec(recomendados, true));
	    modelo.addAttribute("listado", lista);
	    return "listado";
	}

	private List<Pair<Articulo, Boolean>> rec(List<Articulo> items, boolean recommended) {
		List<Pair<Articulo, Boolean>> ret = new ArrayList<>();
		for (Articulo item : items) {
			ret.add(new Pair<>(item, recommended));
		}
		return ret;
	}

	@RequestMapping("/filtrar/{q}")
	 public String filtrar(Model modelo, @PathVariable("q")String[] categoria) {
		List<Pair<Articulo, Boolean>> lista = new ArrayList<>();
	    List<Articulo> filtrados = articuloService.filtrar(categoria);
	    lista.addAll(rec(filtrados, false));
	    modelo.addAttribute("listado", lista);
	    return "listado";
	 }
	 
	 @RequestMapping("/detalles/{q}")
	 public String detalles(Model modelo, @PathVariable("q")int consulta) {
	    List<Articulo> lista = articuloService.buscar(consulta);
	    modelo.addAttribute("detallesArticulo", lista);
	    return "detallesArticulo";
	 }
	 
	 //Esto para los filtros
	 public String opcionesFiltro() { 
		return null; 
	 }
	
}
