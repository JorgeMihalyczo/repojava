package edu.arelance.nube.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.arelance.nube.repository.entity.Restaurante;
import edu.arelance.nube.service.RestauranteService;
import io.swagger.v3.oas.annotations.Operation;


// @Controller // devuelve una vista
@RestController //devuelve un json -> http://localhost:8081/restaurante
@RequestMapping("/restaurante")
public class RestauranteController {
	
	@Autowired
	RestauranteService restauranteService;
	
	Logger logger = LoggerFactory.getLogger(RestauranteController.class);
	
	@GetMapping("/test") // http://localhost:8081/restaurante/test
	public Restaurante obtenerRestauranteTest () {
		Restaurante restaurante = new Restaurante();
		
		System.err.println("Llamando a obtener restauranteTest");
		logger.debug("EStoy en obtenerRestauranteTest AAAAAAAAAAAAAAAAA");
		
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
	@Operation(description = "Este servicio consulta restaurantes por id.")
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id){
		ResponseEntity<?> responseEntity = null;
		
		Optional<Restaurante> oRestaurante = this.restauranteService.consultarRestaurante(id);
		if (oRestaurante.isPresent()) { 
			Restaurante restauranteLeido = oRestaurante.get();
			responseEntity = ResponseEntity.ok(restauranteLeido);
		} else {
			ResponseEntity.noContent().build();
		}
		
		return responseEntity; 
	}

	 
	 // GET -> Búsqueda -> Por barrio, por especialidad, precioMedio, etc.
	 

	// DELETE -> Eliminar un restaurante (por ID) http://localhost:8081/restaurante/id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarPorId(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		
		this.restauranteService.borrarRestaurante(id);
		responseEntity = ResponseEntity.ok().build();
		
		return responseEntity; 
	}
	 // POST -> Insertar restaurante nuevo http://localhost:8081/restaurante (Body, Restaurante)
	@PostMapping
	public ResponseEntity<?> insertarRestaurante(@RequestBody Restaurante restaurante){
		ResponseEntity<?> responseEntity = null;
		Restaurante restauranteNuevo = null;
		
		restauranteNuevo = this.restauranteService.altaRestaurante(restaurante);
		responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(restauranteNuevo);
		
		
		return responseEntity;
	}
	
	// PUT -> Modificar un restaurante que ya existe http://localhost:8081/restaurante (Body, Restaurante)
	@PutMapping("/{id}")
	public ResponseEntity<?> modificiarRestaurante(@RequestBody Restaurante restaurante, @PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		Optional<Restaurante> opRest = null;
		
		opRest = this.restauranteService.modificarRestaurante(id, restaurante);
		if (opRest.isPresent()) {
			Restaurante restauranteModificado = opRest.get();
			responseEntity = ResponseEntity.ok(restauranteModificado);
		} else {
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		
		return responseEntity; 
	}
	
	// // Obtener restaurantes en un rango de precio
	// @GetMapping("/listarEntreRangos/{preciomin}/{preciomax}")
	// public ResponseEntity<?> buscaRestaurantesEntreRangos(@PathVariable int preciomin, @PathVariable int preciomax ) {
	@GetMapping("/listarEntreRangos")
	public ResponseEntity<?> buscaRestaurantesEntreRangos (
			@RequestParam(name = "preciomin") int preciomin,
			@RequestParam(name = "preciomax") int preciomax)
	{
		ResponseEntity<?> resEntity = null; 
		Iterable<Restaurante> listaRestaurantes = null;
			
			listaRestaurantes = this.restauranteService.buscaRestaurantesEntreRangos(preciomin, preciomax);
			resEntity = ResponseEntity.ok(listaRestaurantes);
		
		return resEntity;
	}
	
	// Obtener restaurantes ingresando una clave que coincida con alguna de las propiedades de la clase restaurante
	// http://localhost:8081/restaurante/listarPorClave?clave=marisco&
	
	@GetMapping("/listarPorClave")
	public ResponseEntity<?> listarPorClave (
			@RequestParam(name = "clave") String clave)
	{
		ResponseEntity<?> resEntity = null; 
		Iterable<Restaurante> listaRestaurantes = null;
			
			listaRestaurantes = this.restauranteService.busquedaPorClave(clave);
			resEntity = ResponseEntity.ok(listaRestaurantes);
		
		return resEntity;
	}
	
	
}
