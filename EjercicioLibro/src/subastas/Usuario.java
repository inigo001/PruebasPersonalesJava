package subastas;

public class Usuario {

	private String nombre;
	private double credito;

	/* CONSTRUCTORES */

	public Usuario(String nombre, double credito) {
		this.nombre = nombre;
		this.credito = credito;
	}

	public Usuario(String nombre) {
		this.nombre = nombre;
		this.credito = 0;
	}

	public Usuario(Usuario usuario) {
		this.nombre = usuario.nombre;
		this.credito = usuario.credito;
	}

	/* METODOS PUBLICOS */

	public void incrementarCredito(double incremento) {
		this.credito = this.credito + incremento;
	}

	public void decrementarCredito(double decremento) {
		this.credito = this.credito - decremento;
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

}
