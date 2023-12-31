package other;

public class RadixConverter {

	public static void main(String[] args) {
		int decimalValue = 100;
		System.out.println("2進数に変換: " + Integer.toString(decimalValue, 2));
		System.out.println("8進数に変換: " + Integer.toString(decimalValue, 8));
		System.out.println("16進数に変換: " + Integer.toString(decimalValue, 16));
	}

}
