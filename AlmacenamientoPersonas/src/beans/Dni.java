package beans;

public class Dni implements Comparable<Dni> {

	private String numero;
	private char letra;

	private enum LetrasDni {
		T, R, W, A, G, M, Y, F, P, D, X, B, N, J, Z, S, Q, V, H, L, C, K, E
	}

	/* CONSTRUCTORES */

	public Dni(String numero, char letra) {
		this.numero = numero;
		this.letra = letra;
	}

	public Dni(int numeroDni) {
		this.numero = String.valueOf(numeroDni);
		this.letra = Dni.calcularLetra(numeroDni);
	}

	/* METODOS */

	public boolean isValid() {

		int numeroDni = Integer.parseInt(this.numero);
		char letraDni = Dni.calcularLetra(numeroDni);

		return (letraDni == this.letra);
	}

	public static char calcularLetra(int numeroDni) {
		int mod = numeroDni % 23;
		LetrasDni valor = LetrasDni.values()[mod];
		return valor.toString().charAt(0);
	}

	/* GET Y SET */

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public char getLetra() {
		return this.letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	/* OVERRIDES */

	@Override
	public String toString() {
		return this.numero + "-" + this.letra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.letra;
		result = prime * result + ((this.numero == null) ? 0 : this.numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dni other = (Dni) obj;
		if (this.letra != other.letra)
			return false;
		if (this.numero == null) {
			if (other.numero != null)
				return false;
		} else if (!this.numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public int compareTo(Dni other) {

		if (this.equals(other)) {
			return 0;
		}

		int thisNum = Integer.parseInt(this.numero);
		int otherNum = Integer.parseInt(other.numero);

		return thisNum - otherNum;
	}
}
