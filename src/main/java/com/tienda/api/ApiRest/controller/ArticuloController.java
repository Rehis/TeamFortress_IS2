package com.tienda.api.ApiRest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.api.ApiRest.model.*;
import com.tienda.api.ApiRest.service.ArticuloService;

@Controller
public class ArticuloController {
	
	private final ArticuloService articuloService;
	
	public ArticuloController(ArticuloService articulo) {
		this.articuloService = articulo;
	}
	
	@RequestMapping("/articulos/crear")
    public String mostrarFormAlta(Model modelo)
    {
        modelo.addAttribute("articulo", new Articulo());
        return "formArticulo";
    }
	
	@PostMapping("/articulos/guardar")
	public String guardar(Articulo a) {
		//System.out.println(a);
		articuloService.guardar(a);
		return "redirect:/";
	}
	
}