package subastas;

public class SubastaTemporal extends SubastaLimitada {

	private long horaInicial;
	private long horaFinal;

	// CONSTRUCTOR

	public SubastaTemporal(String nombreProducto, Usuario propietario, int horas) {
		super(nombreProducto, propietario, (horas * 2));

		this.horaInicial = System.currentTimeMillis();
		this.horaFinal = this.horaInicial + this.hoursToMilli(horas);
	}

	// PRIVATE METHODS

	private long hoursToMilli(int horas) {
		return horas * 60 * 60 * 1000;
	}

	private int milliToHours(long milli) {
		return (int) (milli / (1000 * 60 * 60));
	}

	// PUBLIC METHODS

	public boolean ejecutar() {
		System.out.println("Las subastas temporales no pueden ser ejecutadas manualmente.");
		return false;
	}

	// GET Y SET

	public long getHoraInicial() {
		return this.horaInicial;
	}

	public long getHoraFinal() {
		return this.horaFinal;
	}

	public int getHorasRestantes() {
		return this.milliToHours(this.horaFinal - this.horaInicial);
	}

}
