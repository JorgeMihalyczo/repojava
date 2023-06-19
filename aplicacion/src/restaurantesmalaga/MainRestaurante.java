package restaurantesmalaga;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainRestaurante {

	private static final String RUTA_FICHERO = "rests.txt";
	
	public static void main(String[] args) throws IOException {
		// TODO cargar la lista de restaurantes del fichero
		
		File file = new File(RUTA_FICHERO);
		if (file.exists()) {
			System.out.println("Fichero existe, a parsearlo ");
			Path path = file.toPath();
			List<String> lineas = Files.readAllLines(path);
			for (String linea : lineas) {
				System.out.println(linea);
			}
		} else {
			System.out.println("No existe el fichero en esa ruta.");
		}
		
	}

}
