package subastas;

import java.util.LinkedList;

public class Subasta {

	private String nombreProducto;
	private Usuario propietario;
	private boolean isOpen;
	private LinkedList<Puja> pujas;

	/* CONSTRUCTOR */

	public Subasta(String nombreProducto, Usuario propietario) {
		this.nombreProducto = nombreProducto;
		this.propietario = propietario;
		this.isOpen = true;
		this.pujas = new LinkedList<Puja>();

		this.propietario.addSubastaPropia(this);
	}

	/* PRIVATE METHODS */

	// TODO avisar de cómo se puede arreglar esta mierda.
	public boolean isValidPuja(Usuario pujador, double valorPuja) {
		return (isOpen == true) 
				&& (pujador.getCredito() >= valorPuja) 
				&& (this.getPujaMayor() == null || this.getPujaMayor().getValor() <= valorPuja) 
				&& (pujador != this.propietario);

	}

	/* PUBLIC METHODS */

	public boolean pujar(Usuario pujador, double valorPuja) {

		boolean pujaValida = isValidPuja(pujador, valorPuja);

		if (pujaValida) {
			Puja nuevaPuja = new Puja(pujador, valorPuja);
			pujas.add(nuevaPuja);
		}
		
		return pujaValida;
	}

	public boolean pujar(Usuario pujador) {

		final double SUMA_PUJA = 1;
		double valorPuja;

		if (this.getPujaMayor() != null) {
			valorPuja = this.getPujaMayor().getValor() + SUMA_PUJA;
		} else {
			valorPuja = SUMA_PUJA;
		}

		boolean pujaValida = isValidPuja(pujador, valorPuja);
		
		if (pujaValida) {
			Puja nuevaPuja = new Puja(pujador, valorPuja);
			this.pujas.add(nuevaPuja);
		}

		return pujaValida;
	}

	public boolean ejecutar() {
		boolean pujaRealizable = (this.isOpen) && (this.pujas.size() != 0);

		if (pujaRealizable) {
			Usuario pujadorVencedor = this.getPujaMayor().getPujador();

			pujadorVencedor.decrementarCredito(this.getPujaMayor().getValor());
			this.propietario.incrementarCredito(this.getPujaMayor().getValor());

			this.isOpen = false;
		}

		return pujaRealizable;
	}

	/* GET Y SET */

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public Usuario getPropietario() {
		return this.propietario;
	}

	public boolean isOpen() {
		return this.isOpen;
	}

	public LinkedList<Puja> getPujas() {
		return this.pujas;
	}

	public Puja getPujaMayor() {

		if (this.pujas.size() != 0) {
			return this.pujas.getLast();
		} else {
			return null;
		}
	}

	public String toString() {
		return "Nombre de producto: " + this.nombreProducto + ". Propietario: " + this.propietario + ". Está abierta: "
				+ this.isOpen + ". Puja Mayor: " + this.getPujaMayor();
	}

}
