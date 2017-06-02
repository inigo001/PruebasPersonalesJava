package bingo;

import java.util.ArrayList;
import java.util.Collections;

public class Carton {

	/* VARIABLES */

	final private ArrayList<Integer> numerosDeCarton;
	final private int tamanoCarton;

	/* CONSTRUCTORES */

	public Carton(ArrayList<Integer> numerosDeCarton, int tamanoCarton) {
		this.numerosDeCarton = this.ordenarNumeros(numerosDeCarton);
		this.tamanoCarton = numerosDeCarton.size();
	}

	private ArrayList<Integer> ordenarNumeros(ArrayList<Integer> numerosDeCarton) {
		Collections.sort(numerosDeCarton);
		return numerosDeCarton;
	}

	/* METODOS */

	public boolean isBingo(ArrayList<Integer> bolasExtraidas) {
		int numerosIguales = 0;

		for (int i = 0; i < bolasExtraidas.size(); i++) {
			int bolaExtraida = bolasExtraidas.get(i);
			if (this.numerosDeCarton.contains(bolaExtraida)) {
				numerosIguales++;
			}
		}
		return (numerosIguales >= this.tamanoCarton);
	}

	/* SET Y GET */

	public int getTamanoCarton() {
		return this.tamanoCarton;
	}

	public ArrayList<Integer> getNumerosDeCarton() {
		return new ArrayList<Integer>(this.numerosDeCarton);
	}

	/* PROPIOS */

	public boolean equals(Carton carton) {

		boolean isEqual = true;

		isEqual = (this.tamanoCarton == carton.tamanoCarton);

		for (int i = 0; (i < this.numerosDeCarton.size()) && isEqual; i++) {
			isEqual = (this.numerosDeCarton.get(i) == carton.numerosDeCarton.get(i));
		}

		return isEqual;
	}

	public String toString() {
		return "Cartón: (" + this.tamanoCarton + ") <-> " + this.numerosDeCarton;
	}

}
