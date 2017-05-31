package reordenar;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numArray = createArray(56, 1000);
		
		showArrayContent(numArray);

		Sort.merge(numArray);
		
		showArrayContent(numArray);
				
		System.out.println(Numbers.euclid(78958, 15514564));
		
		System.out.println(Numbers.fibonacci(12));
		
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

		System.out.println("Array Length: " + numArray.length);
		System.out.println("Array Content:");

		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i] + ", ");
		}
		
		System.out.println("\n");

	}

}
