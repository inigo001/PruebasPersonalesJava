package subastas;

public class SubastaMinima extends Subasta {

	private double subastaMinima;

	// CONSTRUCTOR

	public SubastaMinima(String nombreProducto, Usuario propietario, double subastaMinima) {
		super(nombreProducto, propietario);

		this.subastaMinima = subastaMinima;
	}

	// PUBLIC METHODS

	public boolean ejecutar() {
		boolean esEjecutable = false;

		if (this.getPujaMayor().getValor() >= this.subastaMinima) {
			esEjecutable = super.ejecutar();
		}

		return esEjecutable;
	}

	public boolean cerrarSubasta() {
		this.isOpen = false;
		return true;
	}

	// GET Y SET

	public double getSubastaMinima() {
		return this.subastaMinima;
	}

	public void setSubastaMinima(double subastaMinima) {
		this.subastaMinima = subastaMinima;
	}

}
