package algorithm.fizz_buzz;

public class FizzBuzzFor2 {

	public static void main(String[] args) {
		useForLoopWithTertiaryOperator(20);
	}

    /**
     * 三項演算子を活用した方法。
     * @param end FizzBuzzを終える数。
     */
    public static void useForLoopWithTertiaryOperator(int end) {
        for (int i=1; i<=end; i++) {
            System.out.println(
                    (i%3==0 && i%5==0) ? "Fizz Buzz" : (i%3==0) ? "Fizz" : (i%5==0) ? "Buzz" : i
                    );
        }
    }

}
