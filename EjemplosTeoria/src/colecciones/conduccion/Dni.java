package colecciones.conduccion;

public class Dni implements Comparable<Dni> {

	private String numero;
	private char letra;

	public Dni(String numero, char letra) {
		this.numero = numero;
		this.letra = letra;
	}

	public void obtenerInfo() {
		System.out.println("numero: " + numero);
		System.out.println("letra: " + letra);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	@Override
	public String toString() {
		return numero + "-" + letra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + letra;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		if (letra != other.letra)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
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
