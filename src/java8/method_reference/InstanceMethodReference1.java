package java8.method_reference;

import java.util.Arrays;
import java.util.List;

/**
 * インスタンスメソッド参照のサンプルコード(1)。
 * @author NKOJIMA
 *
 */
public class InstanceMethodReference1 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(3, 4, 1, 5, 2);

		// forEachを使用しない（拡張for文を使う）場合。
		System.out.println("拡張for文を使う場合");
		for (int a : list) {
			System.out.println(a);
		}

		// forEachを使用した場合。
		System.out.println("forEachを使う場合");
		list.forEach(a -> System.out.println(a));

		// インスタンスメソッド参照を使用した場合。
		System.out.println("インスタンスメソッド参照");
		list.forEach(System.out::println);
	}
}