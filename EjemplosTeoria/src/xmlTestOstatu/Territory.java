package xmlTestOstatu;

public enum Territory {

	BIZKAIA(48, "Bizkaia"), GIPUZKOA(20, "Gipuzkoa"), ALAVA(1, "Araba");

	private int id;
	private String name;

	private Territory(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
