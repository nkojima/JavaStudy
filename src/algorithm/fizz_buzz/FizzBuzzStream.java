package algorithm.fizz_buzz;

import java.util.stream.IntStream;

public class FizzBuzzStream {

	public static void main(String[] args) {
		useStreamAPI(20);
	}

    /**
     * Stream APIを活用した方法。
     * @param end FizzBuzzを終える数。
     */
    public static void useStreamAPI(int end) {
        IntStream.rangeClosed(1, end)
            .mapToObj(i -> (i%3==0 && i%5==0) ? "Fizz Buzz" : (i%3==0) ? "Fizz" : (i%5==0) ? "Buzz" : i)
            .forEach(msg -> System.out.println(msg));
    }
}
