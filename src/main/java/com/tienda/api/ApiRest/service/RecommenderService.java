package com.tienda.api.ApiRest.service;

import com.tienda.api.ApiRest.model.Articulo;
import com.tienda.api.ApiRest.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommenderService {

    private ArticuloRepository articuloRepository;

    public RecommenderService(ArticuloRepository ar) {
        this.articuloRepository = ar;
    }

    public List<Articulo> recomendados(String consulta, List<Articulo> lista) {
        List<Articulo> lista2 = articuloRepository.buscar(consulta);
        for (Articulo a : lista)
            lista2.addAll(articuloRepository.buscarCat(a.getCategoria()));
        return lista2;
    }

}
