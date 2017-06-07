package xmlTestOstatu;

public class Lodging {

	private static int idSumatorio = 1;

	private String name;
	private int id;

	/* CONSTRUCTORES */

	public Lodging(String name) {
		this.name = name;
	}

	/* METODOS */

	public void anadirId() {
		this.id = Lodging.idSumatorio;
		Lodging.idSumatorio++;
	}

	/* GET Y SET */

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	/* PROPIAS */

	public boolean equals(Object lodging) {
		return (((Lodging) lodging).name.equals(this.name));
	}

}
