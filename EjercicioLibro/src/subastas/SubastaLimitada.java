package subastas;

public class SubastaLimitada extends Subasta {

	protected final int pujasMaximas;
	protected int contadorPujas;

	// CONSTRUCTORS

	public SubastaLimitada(String nombreProducto, Usuario propietario, int pujasMaximas) {
		super(nombreProducto, propietario);

		this.pujasMaximas = pujasMaximas;
		this.contadorPujas = 0;
	}

	// PRIVATE METHODS

	// TODO comprobar si es correcto
	private void aumentarContador() {
		this.contadorPujas++;

		if (this.contadorPujas >= this.pujasMaximas) {
			super.ejecutar();
		}
	}

	// METODOS PUBLICOS

	public boolean pujar(Usuario pujador, double valorPuja) {
		boolean pujaValida = super.pujar(pujador, valorPuja);

		if (pujaValida) {
			this.aumentarContador();
		}
		return pujaValida;
	}

	public boolean pujar(Usuario pujador) {
		boolean pujaValida = super.pujar(pujador);

		if (pujaValida) {
			this.aumentarContador();
		}
		return pujaValida;
	}

	// GET Y SET

	public int getPujasMaximas() {
		return this.pujasMaximas;
	}

	public int getContadorPujas() {
		return this.contadorPujas;
	}

	public int getPujasRestantes() {
		return (this.pujasMaximas - this.contadorPujas);
	}

	public String toString() {
		return "Nombre de producto: " + this.nombreProducto + ". Propietario: " + this.propietario + ". Pujas máximas: "
				+ this.pujasMaximas + ". Está abierta: " + this.isOpen + ". Puja Mayor: " + this.getPujaMayor()
				+ ". Pujas restantes: " + this.getPujasRestantes();
	}

}
