package algorithm.fizz_buzz;

public class FizzBuzzFor {

	public static void main(String[] args) {
		useForLoop(20);
	}

    /**
     * for文を使った一般的な方法。
     * @param end FizzBuzzを終える数。
     */
    public static void useForLoop(int end) {
        for (int i=1; i<=end; i++) {
            if (i%3==0 && i%5==0) {
                System.out.println("Fizz Buzz");
            } else if (i%3==0) {
                System.out.println("Fizz");
            } else if (i%5==0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

}
