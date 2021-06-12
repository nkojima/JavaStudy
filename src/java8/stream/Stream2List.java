package java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream2List {

	public static void main(String[] args) {
		List<Integer> list = IntStream.rangeClosed(1, 10)	// 1～10のIntStreamを作る。
				.mapToObj(i -> Integer.valueOf(i))			// IntStreamをStream<Integer>に変換する。
				.collect(Collectors.toList());				// Stream<Integer>をList<Integer>に変換する。

		System.out.println(list);
	}

}
