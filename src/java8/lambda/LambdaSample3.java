package java8.lambda;

import java.util.function.Function;

/**
 * Functionインターフェースのapplyメソッドの活用。
 * @author NKOJIMA
 *
 */
public class LambdaSample3 {

	public static void main(String[] args) {

		// 匿名クラスを利用した場合。
		String str1 = new Function<String, String>() {
			public String apply(String str) {
				return "Hello " + str;
			}
		}.apply("nkojima");

		System.out.println("匿名クラス：" + str1);


		// ラムダ式（省略なし）を利用した場合。
		Function <String, String> f2 = (String str) -> {
			return "Hello " + str;
		};
		String str2 = f2.apply("nkojima");

		System.out.println("ラムダ式（省略なし）：" + str2);

		// ラムダ式（省略あり）を利用した場合。
		Function<String, String> f3 = str -> "Hello " + str;
		String str3 = f3.apply("nkojima");

		System.out.println("ラムダ式（省略あり）：" + str3);
	}
}
