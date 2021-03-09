package java8.string;

import java.util.Arrays;

/**
 * String.joinのサンプルコード。
 * ※Java8からの新機能。
 * @author NKOJIMA
 *
 */
public class JoinSample {

	public static void main(String[] args) {
		// 全て同じ結果が得られる。
		System.out.println(String.join(",", "A", "B", "C"));
		System.out.println(String.join(",", new String[] {"A", "B", "C"}));
		System.out.println(String.join(",", Arrays.asList("A", "B", "C")));
	}

}

