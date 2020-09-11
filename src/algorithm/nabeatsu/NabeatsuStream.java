package algorithm.nabeatsu;

import java.util.stream.IntStream;

/**
 * 1から100までの整数を使って、「世界のナベアツ」のネタを実行する。
 * @author NKOJIMA
 *
 */
public class NabeatsuStream {

	public static void main(String[] args) {
		doNabeatsu(100);
	}

	static void doNabeatsu(int end) {
		IntStream.rangeClosed(1, end)
			.mapToObj(i -> (i%3==0) ? "アホ" : i)
			.forEach(num -> System.out.println(num));
	}
}
