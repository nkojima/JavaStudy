package java8.stream;

import java.util.stream.IntStream;

/**
 * IntStreamクラスのサンプルコード。
 * @author NKOJIMA
 *
 */
public class IntStreamRange {

	public static void main(String[] args) {
		int start = 1;	// 開始値
		int end = 100;	// 終了値

	    int rangeMax = IntStream.range(start, end).max().getAsInt();
	    System.out.println("rangeの最大値:" + rangeMax);

	    int rangeClosedMax = IntStream.rangeClosed(start, end).max().getAsInt();
	    System.out.println("rangeClosedの最大値:" + rangeClosedMax);
	}
}
