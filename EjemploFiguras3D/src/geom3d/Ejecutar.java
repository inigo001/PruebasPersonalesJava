package geom3d;

// Importamos todas las clases del paquete.  Si queremos importar una clase
// en particular sustituimos el asterisco por el nombre de la clase.
import geom2d.*;

public class Ejecutar {

	public static void main(String[] args) {

		Cuadrado cuadrado = new Cuadrado();
		cuadrado.setLado(4);
		Prisma prisma = new Prisma(cuadrado, 5);

		System.out.println("Volumen del prisma: " + prisma.volumen());

		Circulo circulo = new Circulo();
		circulo.setRadio(8);
		Cilindro cilindro = new Cilindro(circulo, 5);

		System.out.println("Volumen del cilindro: " + cilindro.volumen() + ". Altura: " + cilindro.getAltura()
				+ ". Base: " + cilindro.areaBase());

		cilindro.setRadio(12.75);

		System.out.println("Volumen del cilindro: " + cilindro.volumen() + ". Altura: " + cilindro.getAltura()
				+ ". Base: " + cilindro.areaBase());

	}

}
