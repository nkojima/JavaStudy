package java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {

	public static void main(String[] args) {
		System.out.println("----- doFilter -----");
		doFilter();

		System.out.println("----- doFilterWithForEachLoop -----");
		doFilterWithForEachLoop();

		System.out.println("----- doFilterUnique -----");
		doFilterUnique();
	}

	private static void doFilter() {
		Stream<String> stream1 = Stream.of("A","B","C","D","E");

		List<String> list = stream1
			.filter(elem -> !elem.equals("B"))
			.collect(Collectors.toList());

		for(String elem : list) {
			System.out.println(elem);
		}
	}

	private static void doFilterWithForEachLoop() {
		Stream<String> stream1 = Stream.of("A","B","C","D","E");

		stream1
			.filter(elem -> !elem.equals("B"))
			.forEach(elem -> System.out.println(elem));
	}

	private static void doFilterUnique() {
		Stream<String> stream1 = Stream.of("A","B","B","C","D","E","D");

		stream1
			.distinct()
			.forEach(elem -> System.out.println(elem));
	}
}
