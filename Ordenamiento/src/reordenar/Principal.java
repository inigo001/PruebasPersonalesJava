package reordenar;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numArray = createArray(56, 1000);
		
		showArrayContent(numArray);

		int[] sortedArray = Sort.insertion(numArray);
		
		showArrayContent(sortedArray);
		
	}

	private static int[] createArray(int amount, int maximum) {

		int[] numArray = new int[amount];

		for (int i = 0; i < numArray.length; i++) {
			int newNumber = (int) (Math.random() * maximum);
			numArray[i] = newNumber;
		}

		return numArray;
	}

	private static void showArrayContent(int[] numArray) {

		System.out.println("-----\nArray Length: " + numArray.length);
		System.out.println("Array Content:");

		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i] + ", ");
		}

	}

}
