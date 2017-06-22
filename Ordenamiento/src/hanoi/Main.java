package hanoi;

public class Main {

	public static void main(String[] args) {

		int[][] tower = buildTower(4);

		readTower(tower);

	}

	private static int[][] buildTower(int height) {

		int[][] tower = new int[3][height];

		for (int i = height - 1; i >= 0; i--) {
			tower[0][i] = i + 1;
		}

		return tower;
	}

	private static void readTower(int[][] tower) {

		String[] lineas = new String[tower[0].length];
		
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < tower[i].length; j++) {
				lineas[j] += "[" + tower[i][j] + "]";
			}
		}

		for (int i = 0; i < lineas.length; i++) {
			System.out.println(lineas[i]);
		}

	}

}
