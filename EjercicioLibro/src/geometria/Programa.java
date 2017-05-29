package geometria;

public class Programa {

	public static void main(String[] args) {

		Punto punto1 = new Punto(2, 3);
		punto1.desplazar(Direccion.ARRIBA);
		System.out.println(punto1);
/*
		Punto punto2 = new Punto(4, 2);

		System.out.println(Punto.distancia(punto1, punto2));
		System.out.println(Punto.mayorDistancia(punto1, punto2));

		Circulo circulo1 = new Circulo(punto1, 3);
		Circulo circulo2 = new Circulo(punto1, 5);

		circulo1.desplazar(3, 2);
		System.out.println(circulo1);
		System.out.println(circulo2);
		
		Punto centro = circulo2.getCentro();
		centro.desplazar(Direccion.ABAJO);
		
		System.out.println(centro);
		System.out.println(circulo2);
		
		circulo2.escalar(150);
		System.out.println(circulo2);
		*/
		
		Rectangulo rect1 = new Rectangulo (punto1,5,7);
		System.out.println(rect1);
		rect1.desplazar(7,12);
		System.out.println(rect1);
	}

}
