package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreator {

	public static void main(String[] args) {

		System.out.println("----- create -----");
		Stream<String> stream1 = create();
		printStream(stream1);

		System.out.println("----- createFromArray -----");
		Stream<String> stream2 = createFromArray();
		printStream(stream2);

		System.out.println("----- createFromList -----");
		Stream<String> stream3 = createFromList();
		printStream(stream3);
	}

	private static Stream<String> create() {
		return Stream.of("A","B","C","D","E");
	}

	private static Stream<String> createFromArray() {
		String[] ary = new String[]{"A","B","C","D","E"};
		return Arrays.stream(ary);
	}

	private static Stream<String> createFromList() {
		List<String> list = Arrays.asList("A","B","C","D","E");
		return list.stream();
	}

	private static void printStream(Stream<String> stream) {
		stream.forEach((elem) -> System.out.println(elem));
	}
}