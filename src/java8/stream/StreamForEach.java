package java8.stream;

import java.util.stream.Stream;

public class StreamForEach {

	public static void main(String[] args) {
		System.out.println("----- doForEachLoop -----");
		doForEachLoop();

		System.out.println("----- doForEachLoopWithIfStatement -----");
		doForEachLoopWithIfStatement();
	}

	public static void doForEachLoop() {
		Stream<String> stream1 = Stream.of("a","b","c","d","e");

		stream1.forEach((elem) -> {
			String buff = elem.toUpperCase();
			System.out.println(elem + "->" + buff);
		});
	}

	private static void doForEachLoopWithIfStatement() {
		Stream<String> stream1 = Stream.of("a","b","c","d","e");

		stream1.forEach((elem) -> {
			String buff = elem.toUpperCase();
			if (!buff.equals("B")) {
				System.out.println(elem + "->" + buff);
			}
		});
	}
}
