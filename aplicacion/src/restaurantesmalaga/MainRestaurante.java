package restaurantesmalaga;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import aplicacion.Restaurante;

public class MainRestaurante {

	private static final String RUTA_FICHERO = "restaurantes.txt";

	public static List<Restaurante> cargarRestaurantes(List<String> lineas) {
		List<Restaurante> lRestaurantes = null;
		int numlinea = 0;
		Restaurante restauranteAux = null; // el restaurante en curso
		lRestaurantes = new ArrayList<>();

		restauranteAux = new Restaurante();// creo el restaurante vacío
		for (String linea : lineas) {
			numlinea = numlinea + 1;
			switch (numlinea) {
			case 1:
				restauranteAux.setNombre(linea);
				break;
			case 2:
				restauranteAux.setDireccion(linea);
				break;
			case 3:
				restauranteAux.setWeb(linea);
				break;
			case 4:
				restauranteAux.setFichaGoogle(linea);
				break;
			case 5:
				restauranteAux.setLatitud(Float.parseFloat(linea));
				break;
			case 6:
				restauranteAux.setLongitud(Float.parseFloat(linea));
				break;
			case 7:
				restauranteAux.setBarrio(linea);
				break;
			case 8:
				String[] especialidades = linea.split(",");// troceo esp1, esp2, esp3
				List<String> lespecialidades = Arrays.asList(especialidades);// paso de Array a Lista
				restauranteAux.setEspecialidades(lespecialidades);
				lRestaurantes.add(restauranteAux);

				numlinea = 0;
				restauranteAux = new Restaurante();
				break;
			}

		}

		return lRestaurantes;

	}

	public static void main(String[] args) throws IOException {
		// TODO Cargar la lista de restaurantes del fichero
		File file = new File(RUTA_FICHERO);
		if (file.exists()) {
			System.out.println("FICHERO EXISTE!, a parsearlo");
			Path path = file.toPath();// convierto a PATH para usar el nuevo API y así ir más rápido
			List<String> lineas = Files.readAllLines(path);// leo todo el fichero en una línea
			List<Restaurante> listRest = cargarRestaurantes(lineas);
			System.out.println("La lista tiene " + listRest.size() + " restaurantes");
			// mostrarRestaurantes(listRest);

			// añadimos un nuevo restaurante
			Restaurante restauranteABuscar = new Restaurante();
			restauranteABuscar.setNombre("McDonadls");
			restauranteABuscar.setDireccion("MC Donadls Plza de la Marina 2");
			restauranteABuscar.setWeb("www.mcdonalds.com");
			restauranteABuscar.setFichaGoogle("https://goo.gl/maps/DUmVjnSZeX6Y9n448");
			restauranteABuscar.setLatitud(36.7184846f);
			restauranteABuscar.setLongitud(-4.4909181f);
			restauranteABuscar.setBarrio("centro");
			restauranteABuscar.setEspecialidades(List.of("hamburguesas", "patas fritas", "helados"));
			
			
			// System.out.println("Existe el restaurante buscado?: " +
			// buscarRestaurantes(listRest, restauranteABuscar));
			// System.out.println("Existe el restaurante buscado?: " +
			// buscarRestaurantesPorNombre(listRest, restauranteABuscar));
			System.out.println("Existe el restaurante buscado?: " + buscarRestaurantesPorEspecialidad(listRest, "hamburguesas"));
		} else {
			System.out.println("NO EXISTE el fichero en esa ruta :(");
		}

	}

	public static void mostrarRestaurantes(List<Restaurante> listRest) {
		System.out.println("Mostrando restaurantes..");
		for (Restaurante res : listRest) {
			System.out.println(res.toString());
		}
	}

	public static boolean buscarRestaurantes(List<Restaurante> listRest, Restaurante restauranteBuscado) { // metodo
																											// buscame
																											// esto en
																											// esta
																											// lista
		boolean estaRestaurante = false; // mejor practica poner los booleanos a false y los int a 0 y los objetos a
											// null.
		int pos_actual = 0;
		int longitud = listRest.size();

		Restaurante restauranteAux = null;

		while (pos_actual < longitud && !estaRestaurante) {
			restauranteAux = listRest.get(pos_actual);
			estaRestaurante = restauranteAux.equals(restauranteBuscado);
			pos_actual = pos_actual + 1;
		}

		return estaRestaurante;

	}

	public static boolean buscarRestaurantesPorNombre(List<Restaurante> listRest, Restaurante restauranteBuscado) { // metodo
																													// buscame
																													// esto
																													// en
																													// esta
																													// lista
		boolean estaRestaurante = false; // mejor practica poner los booleanos a false y los int a 0 y los objetos a
											// null.
		int pos_actual = 0;
		int longitud = listRest.size();

		Restaurante restauranteAux = null;

		while (pos_actual < longitud && !estaRestaurante) {
			restauranteAux = listRest.get(pos_actual);
			estaRestaurante = restauranteAux.getNombre().equals(restauranteBuscado.getNombre());
			pos_actual = pos_actual + 1;
		}

		return estaRestaurante;

	}

	public static boolean buscarRestaurantesPorBarrio(List<Restaurante> listRest, Restaurante restauranteBuscado) { // metodo
																													// buscame
																													// esto
																													// en
																													// esta
																													// lista
		boolean estaRestaurante = false; // mejor practica poner los booleanos a false y los int a 0 y los objetos a
											// null.
		int pos_actual = 0;
		int longitud = listRest.size();

		Restaurante restauranteAux = null;

		while (pos_actual < longitud && !estaRestaurante) {
			restauranteAux = listRest.get(pos_actual);
			estaRestaurante = restauranteAux.getBarrio().equals(restauranteBuscado.getBarrio());
			pos_actual = pos_actual + 1;
		}

		return estaRestaurante;

	}

	public static List<Restaurante> buscarRestaurantesPorEspecialidad(List<Restaurante> listRest, String especialidad) {
		// TODO: Terminar 
		boolean estaRes = false;
		List<Restaurante> restaurantesEncontrados = null;
		int longitud = listRest.size();

		Restaurante restauranteAux = null;

		for (int i = 0; i < longitud; i++) {
			
			
		}

		return restaurantesEncontrados;

	}
}