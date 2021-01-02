package java8.stream;

import java.util.stream.Stream;

public class StreamMap {

	public static void main(String[] args) {
		Stream.of(1,2,3,4,5,6,7,8,9,10)
			.map(i -> i + "番目")
			.forEach(i -> System.out.println(i));
	}

}
