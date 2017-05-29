package geometria;

public class PruebaPunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Punto punto1 = new Punto(15, 15);
		Punto punto2 = new Punto();
		Punto punto3 = new Punto(punto1);
		Punto punto4 = punto2;

		obtenerInfo(punto1);

		punto2.desplazar(2, 12);
		System.out.println(punto2);

		punto2.desplazar(Direccion.ABAJO);
		System.out.println(punto2);
		System.out.println(punto1);

		System.out.println(Punto.distancia(punto1, punto2));

		Punto alejado = Punto.mayorDistancia(punto1, punto2, punto3, punto4);
		
		System.out.println(alejado);
	}

	public static void obtenerInfo(Punto punto) {
		String posicionObjeto = "Posición x: " + punto.getX() + " . Posición y: " + punto.getY();
		System.out.println(posicionObjeto);
	}

}
