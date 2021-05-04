package com.tienda.api.ApiRest.service;

import com.tienda.api.ApiRest.model.Articulo;
import com.tienda.api.ApiRest.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.SortedSet;

@Service
public class RecommenderService {

    private ArticuloRepository articuloRepository;

    public RecommenderService(ArticuloRepository ar) {
        this.articuloRepository = ar;
    }

    public List<Articulo> recomendados(String consulta, List<Articulo> lista) {
        ArrayList<Articulo> lista2 = new ArrayList();
        for (Articulo a : lista) {        	
        	for (Articulo b: articuloRepository.buscarTodos()) {
        		double similarity = 0.0;
	      	    if (a.getNombre().equals(b.getNombre())) {
	      	    	similarity += 0.50;
	      	    }
	      	    if (a.getPrecio() == (b.getPrecio())) {
	      	    	similarity += 0.15;
	      	    }
	      	    if (a.getCategoria().equals(b.getCategoria())) {
	      	    	similarity += 0.35;
	      	    }
	      	    if(similarity >= 0.50 && a != b && !lista.contains(b))
	            	lista2.add(b);
	    	}
        }
        return lista2;
    }
}
