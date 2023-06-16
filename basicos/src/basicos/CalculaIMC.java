package basicos;

/* /**
 * TODO
 * HACED UNA APLICACIÓN QUE PERMITA INTRODUCIR AL USUARIO
 * SU ESTATURA EN METROS Y SU PESO EN KG Y LE INFORME DE SU ÍNDICE DE MASA CORPORAL (IMC) SEGÚN LA SIGUIENTE FÓRMULA
 * 
 * LA FÓRMULA DEL IMC = PESO KG / ESTATURA AL CUADRADO METROS
 *  * SI IMC < 16 ->> su imc es DESNUTRIDO
 * SI IMC >= 16 Y < 18  ->> su imc es DELGADO
 * SI IMC >= 18 Y < 25  ->> su imc es IDEAL
 * SI IMC >= 25 Y < 31  ->> su imc es SOBREPESO
 * SI IMC >= 31 ->> su imc es OBESO
 ADEMÁS, DE DECIRLE SU IMC NUMÉRICO Y NOMINAL,
pista: PARA LEER DE TECLADO USAD LA CLASE SCANNER
  */


public class CalculaIMC {
	
	public static void main(String[] args) {
		System.out.println(calcularIMC(1.69, 50));
	}
	
	
	public static String calcularIMC (double estatura, double peso) {
		String mensaje = "";
		
		double calculoIMC = peso / ((estatura * estatura));
		calculoIMC = (double)Math.round(calculoIMC * 100) / 100;
		
		
		if (calculoIMC < 16)
			mensaje = ("El IMC es de: " + calculoIMC +", usted esta desnutrido");
		else if (calculoIMC >= 16 && calculoIMC < 18)
			mensaje = ("El IMC es de: " + calculoIMC +", usted esta delgado");
		else if (calculoIMC >= 18 && calculoIMC < 25)
			mensaje = ("El IMC es de: " + calculoIMC +", su peso es el ideal");
		else if (calculoIMC >= 16 && calculoIMC < 31)
			mensaje = ("El IMC es de: " + calculoIMC +", usted tiene sobrepeso");
		else if (calculoIMC > 31)
			mensaje = ("El IMC es de: " + calculoIMC +", usted esta obeso");
		return mensaje;
	}
	
}
