package java8.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamOrder {

	public static void main(String[] args) {
		System.out.println("----- sortNaturalOrder -----");
		sortNaturalOrder();

		System.out.println("----- sortReverseOrder -----");
		sortReverseOrder();
	}

	/**
	 * Streamを直接生成する。
	 * @return
	 */
	private static Stream<Integer> createStream() {
		return Stream.of(3, 2, 5, 1, 4);
	}

	/**
	 * 自然順序に沿ってソートした結果を表示する。
	 */
	public static void sortNaturalOrder() {
		createStream().sorted()
			.forEach(i -> System.out.println(i));
	}

	/**
	 * 自然順序の逆順にソートした結果を表示する。
	 */
	public static void sortReverseOrder() {
		createStream().sorted(Comparator.reverseOrder())
			.forEach(i -> System.out.println(i));
	}
}
