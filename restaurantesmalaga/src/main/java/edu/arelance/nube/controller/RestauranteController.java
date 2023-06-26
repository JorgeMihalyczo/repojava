package edu.arelance.nube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.arelance.nube.repository.entity.Restaurante;

/*
 * API WEB
 * HTTP -> Deriva en la ejecucion de un metodo
 * 
 * GET -> Consultar todos
 * GET -> Consultar uno (por ID)
 * POST -> Insertar restaurante nuevo
 * PUT -> Modificar un restaurante que ya existe 
 * DELETE -> Eliminar un restaurante (por ID)
 * GET -> Búsqueda -> Por barrio, por especialidad, precioMedio, etc.
 * */


// @Controller // devuelve una vista
@RestController //devuelve un json -> http://localhost:8081/restaurante
@RequestMapping("/restaurante")
public class RestauranteController {
	
	@GetMapping("/test") // http://localhost:8081/restaurante/test
	public Restaurante obtenerRestauranteTest () {
		Restaurante restaurante = new Restaurante();
		
		System.err.println("Llamando a obtener restauranteTest");
		
		return restaurante;
	}

}
