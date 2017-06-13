package pruebas;

public class Tools {

	private Tools() {
	}

	public static void showArrayContent(int[] array) {

		System.out.println("Start showingArray");

		for (int i = 0; i < array.length; i++) {
			System.out.println(i + " -- " + array[i]);
		}

	}

}
