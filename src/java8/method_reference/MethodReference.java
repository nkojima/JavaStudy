package java8.method_reference;

import java.util.function.Function;

/**
 * メソッド参照のサンプルコード。
 * @author NKOJIMA
 *
 */
public class MethodReference {

	public static void main(String[] args) {

		// Functionインターフェースのapplyメソッドを活用した例。
		Function<String, String> f1 = str -> "Hello " + str;
		String str1 = f1.apply("nkojima");
		System.out.println(str1);

		// 上記のコードの戻り値をIntegerに変えた例。
		Function<String, Integer> f2 = str -> Integer.parseInt(str);
		int i = f2.apply("123");
		System.out.println(i);

		// メソッド参照を用いた例。
		// ※ラムダ式内で呼び出されるメソッドが1つの場合に使える方法。
		Function<String, Integer> f3 = Integer::parseInt;
		int j = f3.apply("345");
		System.out.println(j);
	}
}
