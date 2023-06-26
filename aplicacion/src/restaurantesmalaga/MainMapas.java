package restaurantesmalaga;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import restaurantesmalaga.ComparadorRestaurantes;
import aplicacion.Restaurante;

public class MainMapas {
	
	
	private static final String RUTA_FICHERO = "restaurantesconprecio.txt";
	
	public static void main(String[] args) throws IOException {
		

		//TODO Cargar la lista de restaurantes del fichero
		File file = new File(RUTA_FICHERO);
		if (file.exists())
		{
			System.out.println("FICHERO EXISTE!, a parsearlo :)");
			Path path = file.toPath();//convierto a PATH para usar el nuevo API y así ir más rápido
			List<String> lineas = Files.readAllLines(path);//leo todo el fichero en una línea
			List<Restaurante> listRest =  MainRestaurante.cargarRestaurantes(lineas);
			
			Map<String, Restaurante> mapaRestaurantes = new TreeMap<>();
			
			for (Restaurante r : listRest)
			{
				mapaRestaurantes.put(r.getNombre(), r);
			}
			//TODO partiendo de la lista de restaurantes cargada
			//haced un mapa, donde la clave sea el barrio
			//y el valor, la lista de restaurantes de ese barrio
			
			
			
			//System.out.println(mapaRestaurantes);
			
			Restaurante rp = mapaRestaurantes.get("La Parrilla");
			System.out.println(rp.toString());
			
			Map<String, List<Restaurante>> mapaRestaurantesPorBarrios = null;
			mapaRestaurantesPorBarrios = crearMapRestaurantesPorBarrios(listRest);
			Set<String> clavesMapa = mapaRestaurantesPorBarrios.keySet();
			for (String barrio : clavesMapa) 	{
				List<Restaurante> lrb = mapaRestaurantesPorBarrios.get(barrio);
				System.out.println("BARRIO =  " + barrio);
				for (Restaurante rb : lrb)	{
					// System.out.println(rb.toString());
				}
			}
			
			// System.out.println(obtenerRestaurantesMasCaros(mapaRestaurantesPorBarrios).toString()); 
			System.out.println("Precio medio del siguiente barrio:  " + devuelvePrecioMedioDeBarrio(mapaRestaurantesPorBarrios, "Centro") );
		}
		else {
			System.out.println("FICHERO NO EXISTE!");
		}
	}
	
	
	public static Map<String, List<Restaurante>> crearMapRestaurantesPorBarrios (List<Restaurante> lr)
	{
		Map<String, List<Restaurante>> mapa = new HashMap<>();
		
		//recorro la lista
			//si el barrio ya está en el mapa
				//añado restaurante a esa lista
			//si no, creo lista nueva y add ese restaurante
		
			for (Restaurante r : lr) 	{
				List<Restaurante> lrb = mapa.get(r.getBarrio());
				if ( lrb != null)	{
					System.out.println("ya existen restaurantes con ese barrio");
					lrb.add(r);
				} else {
					List<Restaurante> lnueva = new ArrayList<>();
					lnueva.add(r);
					mapa.put(r.getBarrio(), lnueva);
				}
			}
			
		return mapa;
		
	}
	
	public static List<Restaurante> obtenerRestaurantesMasCaros (Map<String, List<Restaurante>> mapaRestaurantes) {
		
		List<Restaurante> listaCaros = new ArrayList<>();
		
		for ( String  barrio : mapaRestaurantes.keySet()) {
			
			List<Restaurante> listaRestaurantesPorBarrio = mapaRestaurantes.get(barrio);
			
			Restaurante restauranteMasCaro = obtenerMasCaro(listaRestaurantesPorBarrio);
			
			listaCaros.add(restauranteMasCaro);
			
		}
		
		return listaCaros;
	}
	
	private static Restaurante obtenerMasCaro (List<Restaurante> listaRestaurantes) {
		Restaurante restauranteMasCaro = null;
		float precioMayor = 0;
		
		for (Restaurante restaurante : listaRestaurantes) {
			if (restaurante.getPrecio() > precioMayor) {
				restauranteMasCaro = restaurante;
				precioMayor = restaurante.getPrecio();
			}
		}
		
		Collections.sort(listaRestaurantes);
		
		return restauranteMasCaro;
	}
	
	
	/*  1) Hacer un método que reciba el mapa de restaurantes, un barrio y me diga el precio medio de un barrio */
	
	private static float devuelvePrecioMedioDeBarrio ( Map<String, List<Restaurante>> mapaRestaurantes, String barrio) {
		float precioMedioPorBarrio = 0;
		float sumaPrecioRestaurantes = 0;
		int cantidadRestaurantes = 0;
		
		List<Restaurante> listaRestaurantesPorBarrio = mapaRestaurantes.get(barrio);
			
		for ( Restaurante restaurante : listaRestaurantesPorBarrio) {
				sumaPrecioRestaurantes += restaurante.getPrecio();
		}
		
		cantidadRestaurantes = listaRestaurantesPorBarrio.size() ;
		precioMedioPorBarrio = calculaMedia(cantidadRestaurantes, sumaPrecioRestaurantes);
		
		return precioMedioPorBarrio;
	}

	private static float calculaMedia(int cantidadRestaurantes, float sumaPrecioRestaurantes) {
		float resultado= 0;
		
		resultado = sumaPrecioRestaurantes / cantidadRestaurantes ;
		
		return resultado;
	}
	
	
	// Hacer un metodo que reciba un mapa de restaurantes y devuelva el restaurante mas barato de todos los barrios
	public static List<Restaurante> obtenerRestaurantesMasBaratos ( Map<String, List<Restaurante>> mapaRestaurantes) {
		List<Restaurante> listaBaratos = new ArrayList<>();		
		float precioMenor = 0;
		
		for ( String barrio : mapaRestaurantes.keySet() ) {
			
			List<Restaurante> listaRestaurantesPorBarrio = mapaRestaurantes.get(barrio);
			
			Restaurante restauranteMasBarato = obtenerMasBarato(listaRestaurantesPorBarrio);
			
			listaBaratos.add(restauranteMasBarato);
			
			
		}
		return listaBaratos;
	}
	
	private static Restaurante obtenerMasBarato (List<Restaurante> listaRestaurantes) {
		Restaurante restauranteMasBarato = new Restaurante();
		float precioMenor = 500000;
		
		for (Restaurante restaurante : listaRestaurantes) {
			if (restaurante.getPrecio() < precioMenor) {
				restauranteMasBarato = restaurante;
				precioMenor = restaurante.getPrecio();
			}
		}
		
		Collections.sort(listaRestaurantes);
		
		return restauranteMasBarato;
	}
	
	
	

}
