package edu.arelance.nube.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.arelance.nube.repository.entity.Restaurante;
import edu.arelance.nube.service.RestauranteService;


// @Controller // devuelve una vista
@RestController //devuelve un json -> http://localhost:8081/restaurante
@RequestMapping("/restaurante")
public class RestauranteController {
	
	@Autowired
	RestauranteService restauranteService;
	
	@GetMapping("/test") // http://localhost:8081/restaurante/test
	public Restaurante obtenerRestauranteTest () {
		Restaurante restaurante = new Restaurante();
		
		System.err.println("Llamando a obtener restauranteTest");
		restaurante = new Restaurante(1l, "Martinete", "Carlos Haya 33", "Carranque",
				"www.martinete.org", "http://google.xe", 33.65f, -2.3f, 10, "gazpachuelo",
				"Paella", "Sopa de Marizcos", LocalDateTime.now());
		return restaurante;
	}
	
	// GET -> Consultar todos http://localhost:8081/restaurante
	@GetMapping
	public ResponseEntity<?> listarTodos(){
		ResponseEntity<?> responseEntity = null;
		Iterable<Restaurante> lista_restaurantes = null;
		
		lista_restaurantes = this.restauranteService.consultarTodos();
		responseEntity = ResponseEntity.ok(lista_restaurantes);
		
		return responseEntity; 
	}
	

	
	 // GET -> Consultar uno (por ID) http://localhost:8081/restaurante/id
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id){
		ResponseEntity<?> responseEntity = null;
		
		
		
		return responseEntity; 
	}
	 // POST -> Insertar restaurante nuevo http://localhost:8081/restaurante (Body, Restaurante)
	 // PUT -> Modificar un restaurante que ya existe http://localhost:8081/restaurante (Body, Restaurante)
	 // GET -> Búsqueda -> Por barrio, por especialidad, precioMedio, etc.
	 

	// DELETE -> Eliminar un restaurante (por ID) http://localhost:8081/restaurante/id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarPorId(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		
		
		
		return responseEntity; 
	}
	
}
