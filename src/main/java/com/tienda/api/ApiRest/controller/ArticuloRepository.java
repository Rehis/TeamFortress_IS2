package com.tienda.api.ApiRest.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.api.ApiRest.model.Articulo;

@Repository	
public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{

}
