package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class LambdaSample1 {

	public static void main(String[] args) {
		List<String> languages = Arrays.asList("Java", "python", "PHP");

		// 関数型インターフェースを利用した例。
		// UnaryOperatorはインターフェースは、引数と戻り値が同じ型となる。
		languages.replaceAll(new UnaryOperator<String>() {
			@Override
			public String apply(String str) {
				return str.toUpperCase();
			}
		});

		// ラムダ式を利用した例。
		languages.replaceAll((String str) -> {
			return str.toUpperCase();
		});

		// 結果の出力。
		languages.forEach((String lang) -> {
			System.out.println(lang);
		});
	}
}