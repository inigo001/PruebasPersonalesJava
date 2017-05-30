package subastas;

import java.util.LinkedList;

public class Usuario {

	private String nombre;
	private double credito;
	private LinkedList<Subasta> subastasPropias;

	/* CONSTRUCTORES */

	public Usuario(String nombre, double credito) {
		this.nombre = nombre;
		this.credito = credito;
		this.subastasPropias = new LinkedList<Subasta>();
	}

	public Usuario(String nombre) {
		this.nombre = nombre;
		this.credito = 0;
		this.subastasPropias = new LinkedList<Subasta>();
	}

	public Usuario(Usuario usuario) {
		this.nombre = usuario.nombre;
		this.credito = usuario.credito;
		this.subastasPropias = new LinkedList<Subasta>();
	}

	/* METODOS PUBLICOS */

	public void incrementarCredito(double incremento) {
		this.credito = this.credito + incremento;
	}

	public void decrementarCredito(double decremento) {
		this.credito = this.credito - decremento;
	}

	public void addSubastaPropia(Subasta subasta) {
		this.subastasPropias.add(subasta);
	}

	/* GET Y SET */

	public double getCredito() {
		return this.credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public String getNombre() {
		return this.nombre;
	}

	public LinkedList<Subasta> getSubastasPropias() {
		return new LinkedList<Subasta>(this.subastasPropias);
	}

	public String toString() {
		return "(" + this.nombre + "," + this.credito + "€)";
	}

}
