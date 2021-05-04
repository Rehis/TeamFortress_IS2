package com.tienda.api.ApiRest.controller;

import java.util.List;
import com.tienda.api.ApiRest.service.RecommenderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tienda.api.ApiRest.model.Articulo;
import com.tienda.api.ApiRest.service.ArticuloService;

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
	    List<Articulo> lista = articuloService.buscarTodos();
	    modelo.addAttribute("listado", lista);
	    return "listado";
	}
	
	 @RequestMapping("/buscar")
	 public String buscar(Model modelo, @RequestParam("q")String consulta) {
	    List<Articulo> lista = articuloService.buscar(consulta);
	    lista.addAll(recommenderService.recomendados(consulta, lista));
	    modelo.addAttribute("listado", lista);
	    return "listado";
	 }
	 
	 @RequestMapping("/filtrar")
	 public String filtrar(Model modelo, @RequestParam("categoria")String[] categoria) {
	    List<Articulo> lista = articuloService.filtrar(categoria);
	    //recomendador
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
