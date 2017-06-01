package burbujas.pruebas;

import java.util.Random;

import burbujas.elementos.Burbuja;
import burbujas.elementos.BurbujaCreciente;
import burbujas.elementos.BurbujaDebil;
import burbujas.elementos.BurbujaLimitada;
import burbujas.elementos.BurbujaSensible;
import burbujas.geometria.Circulo;
import burbujas.geometria.Punto;


/**
 * Clase para comprobar el comportamiento de las burbujas.
 */
public class PruebaBurbujas {

	private static final int LIMITE_ASCENSOS = 4;
	private static final double PROBABILIDAD_EXPLOSION = 0.1; 

	/**
	 * Método que aplica sobre una burbuja las operaciones
	 * definidas en la clase.
	 * @param burbuja burbuja sobre la que se va a probar las operaciones definidas
	 */
	private static void simular(Burbuja burbuja) { 
		Random random = new Random();
	     int i = 0;
	     while (i < LIMITE_ASCENSOS && !burbuja.isExplotada()) { 
	        burbuja.ascender();
	        
	        if (random.nextBoolean() == true) 
	              burbuja.chocar();

	        if (random.nextDouble() < PROBABILIDAD_EXPLOSION)
	              burbuja.explotar();

	        System.out.println(burbuja.getInfo());
	        ++i;
	     }
	}

	/**
	 * Programa principal.
	 * @param args argumentos del programa
	 */
	public static void main(String[] args) {
		Circulo circulo1 = new Circulo(new Punto(50, 50), 50);
		
		Burbuja basica = new Burbuja(circulo1, 100);
		
		Circulo circulo2 = new Circulo(new Punto(200, 50), 50);
		
		BurbujaLimitada limitada = new BurbujaLimitada(circulo2, 50, 400);
		
		Circulo circulo3 = new Circulo(new Punto(350, 50), 50);
		
		BurbujaDebil debil = new BurbujaDebil(circulo3, 50, 3);
		
		Circulo circulo4 = new Circulo(new Punto(500, 50), 10);
		
		BurbujaCreciente creciente = new BurbujaCreciente(circulo4, 20); 
		
		Circulo circulo5 = new Circulo(new Punto(650, 50), 50);
		
		BurbujaSensible sensible = new BurbujaSensible(circulo5, 20); 
		
		//Estructura de datos polimórfica
		
		Burbuja[] burbujas = {basica, limitada, debil, creciente, sensible};
				
		for (Burbuja burbuja: burbujas) {
			simular(burbuja);
		}
		
	}

}
