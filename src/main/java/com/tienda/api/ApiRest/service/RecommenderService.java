package com.tienda.api.ApiRest.service;

import com.tienda.api.ApiRest.model.Articulo;
import com.tienda.api.ApiRest.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommenderService {

    private ArticuloRepository articuloRepository;

    public RecommenderService(ArticuloRepository ar) {
        this.articuloRepository = ar;
    }

    public List<Articulo> recomendados(String consulta, List<Articulo> lista) {
        ArrayList<Articulo> lista2 = new ArrayList<>();
        for (Articulo a : lista) {        	
        	for (Articulo b: articuloRepository.buscarTodos()) {
        		double similarity = 0.0;
        		//No hace falta comparar el nombre, porque si hay alguna coincidencia [%?1%] aparece en la búsqueda.
	      	    /*if (a.getNombre().equals(b.getNombre())) {
	      	    	similarity += 0.50;
	      	    }*/
				//descripción
				if (b.getDescripcion().contains(consulta)) {
					similarity += 0.50;
				}
				//precio
	      	    similarity += priceSimilarity(a.getPrecio(), b.getPrecio());
	      	    //categoría
	      	    if (a.getCategoria().equals(b.getCategoria())) {
	      	    	similarity += 0.35;
	      	    }

	      	    if(similarity > 0.50 && !lista.contains(b) && !lista2.contains(b))
	            	lista2.add(b);
	    	}
        }
        return lista2;
    }

	private double priceSimilarity(double precio, double precio1) {
    	/* Calcula la similitud en función del precio máximo de los dos y la diferencia entre ambos, mediante la función
    	* 	max * sqrt( 1 - 10x^2 / ma^2), donde:
    	* 	'max' es valor máximo que aportará a la función de similitud (cuando 'x' sea 0);
    	* 	'x' es la diferencia de precio;
    	* 	'm' > 0 es un valor que decide el tamaño de la diferencia que permitimos;
    	* 	'a' es el mayor precio de los dos.*/
		double max = 0.2;
    	double x = precio - precio1;
		double m = 0.3;
		double a = Math.max(precio, precio1);
		double sim = max * Math.sqrt(1 - ((10 * Math.pow(x, 2)) / (m * Math.pow(a, 2))));
    	return sim > 0 ? sim : 0;
	}
}
