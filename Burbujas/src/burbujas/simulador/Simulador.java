package burbujas.simulador;

import burbujas.elementos.Burbuja;

public class Simulador {

	final private int alto;
	final private int ancho;
	private Pantalla pantalla;

	public Simulador(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.pantalla = new Pantalla(ancho, alto);
	}
	
	public void simular(Burbuja burbuja)
	{
		pantalla.setBarraEstado("Pulse una tecla para empezar...");
	}

}
