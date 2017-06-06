package xmlTestOstatu;

public class Municipio {

	private String name;
	private int code;
	private Territory territory;

	public Municipio(String name, int code, Territory territory) {
		this.name = name;
		this.code = code;
		this.territory = territory;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	public Territory getTerritory() {
		return territory;
	}

	public boolean equals(Object municipio) {
		return (((Municipio) municipio).code == this.code);
	}

}
