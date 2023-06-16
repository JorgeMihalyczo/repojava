package basicos;
import java.util.Scanner;


/**   LISTA DE EJERCICIOS DE REPASO A LA PARTE DE INICIACIÓN EN JAVA:

 * 
 * 
 * 
 * 
 *
 *
 * // DEFINO UN MÉTODO // DARLE UN NOMBRE - camelCase // ID la entrada - // ID
 * la salida -
 *
 * //pensar el los pasos en esapñol en psuedocódigo
 */


public class EjercicosBasicos {
	public static void main(String[] args) {
//		encuentraCaracter("hola", 'h');
//		cuentaCaracteresUltimaPosicion("hola como estas", 'z');
//		System.out.println(esPar(7));
//		System.out.println(esMayorDeEdad());
//		System.out.println(clasificarNota(10));
//		System.out.println(invertirCadena("Que onda"));
		secuenciaTresEnTres();
	}
	
	
	///// 1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER
	public static void encuentraCaracter (String cadena, char caracter) {
		
		int perteneceACadena = cadena.indexOf(caracter);
		
		if (perteneceACadena >= 0) {
			System.out.println("El caracter '" + caracter + "' se encuentra en la cadena ingresada: " + cadena);
		} else {
			System.out.println("El caracter '" + caracter + "' NO se encuentra en la cadena ingresada: " + cadena);
		}
	}
	
	
	//////  2) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA CÚANTAS VECES APARECE ESE CARACTER EN LA CADENA
	public static void cuentaCaracteres (String cadena, char caracter) {
		int contador = 0;
		
		for (int i = 0; i < cadena.length(); i++) {
			if ( cadena.charAt(i) == caracter ) {
				contador++;
			}
		}
		System.out.println(contador);
	}
	
	/////// 2.1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA la última posición donde aparece 
	//			ese caracter en esa cadena. Si no está, devuelve -1
	
	public static void cuentaCaracteresUltimaPosicion (String cadena, char caracter) {
		int posicion = 0;

		posicion = cadena.lastIndexOf(caracter);
		System.out.println("La posicion del ultimo caracter es: " + posicion);
	}
	
	///// 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO esPar
	public static boolean esPar (int num) {
		
		return (num % 2 == 0);
	}
	
	////// 4) HACER UN MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE EDAD O NO mayorDeEdad 
	
	public static String esMayorDeEdad () {
		String mensaje = "";
		Scanner escaner = new Scanner(System.in);
		
		System.out.println("Ingresá tu edad: ");
		int edad = escaner.nextInt();
		escaner.close();
		
		mensaje = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
		
		return mensaje;
	}
	
	//// 5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA SI EQUIVALE A UN DESAPROBADO, BIEN, NOTABLE,
	//       O SOBRESALIENTE clasificarNota -
	
	public static String clasificarNota(int nota) {
		String tipoNota = "";

		tipoNota = switch (nota) {
		case 0,1,2,3,4 -> "SUSPENSO";
		case 5 -> "APROBADO";
		case 6 -> "BIEN";
		case 9,10 -> "SOBRESALIENTE";
		default -> "error";
		};
		
		return tipoNota;
	}
	
	//// 6) HACER UN MÉTODO QUE RECIBA UNA CADENA Y LA DEVUELVA ALREVÉS invertirCadena 
	
	public static String invertirCadena(String cadena) {

		
		StringBuilder cadenaInvertida  = new StringBuilder(cadena);
		cadenaInvertida.reverse();
		
		return cadenaInvertida+"";
	}
	
	//// 7) HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99 deTresEnTres
	
	public static void secuenciaTresEnTres() {
		for (int i = 3; i < 100; i += 3) {
			System.out.print(i + "," );
		}
	}
	

}
