package java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * ラムダ式の省略
 * @author NKOJIMA
 *
 */
public class LambdaSample2 {

	public static void main(String[] args) {
		List<String> languages = Arrays.asList("Java", "python", "PHP");

		// 型推論による型の省略のサンプルコード
		languages.replaceAll((str) -> {
			return str.toUpperCase();
		});

		// 丸カッコを省略した場合のサンプルコード。
		// 引数が1つの場合は丸カッコを省略できるが、引数が0個や複数個の場合は省略できない。
		languages.replaceAll(str -> {
			return str.toUpperCase();
		});

		// 結果の出力。
		languages.forEach((String lang) -> {
			System.out.println(lang);
		});
	}
}