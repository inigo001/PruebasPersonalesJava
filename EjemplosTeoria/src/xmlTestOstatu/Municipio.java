package xmlTestOstatu;

import java.util.ArrayList;

public class Municipio {

	private String name;
	private int code;
	private Territory territory;

	/* CONSTRUCTOR */

	public Municipio(String name, int code, Territory territory) {
		this.name = name;
		this.code = code;
		this.territory = territory;
	}

	public Municipio(Municipio municipio) {
		this(municipio.name, municipio.code, municipio.territory);
	}

	/* METODOS */

	public ArrayList<Ostatu> getTownOstatus(ArrayList<Ostatu> ostatus) {

		ArrayList<Ostatu> townOstatus = new ArrayList<Ostatu>();

		for (Ostatu ostatu : ostatus) {
			if (ostatu.getMunicipio().equals(this)) {
				townOstatus.add(ostatu);
			}
		}

		return townOstatus;

	}

	/* GET Y SET */

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	public Territory getTerritory() {
		return territory;
	}

	/* PROPIAS */

	public boolean equals(Object municipio) {
		return (((Municipio) municipio).code == this.code);
	}

	public String toString() {
		return "[" + this.name + "," + this.territory.getName() + "]";
	}

}
