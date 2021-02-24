package java8.method_reference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * staticメソッド参照のサンプルコード。
 * @author NKOJIMA
 *
 */
public class StaticMethodReference {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 1, 2);

		// 匿名クラスを使用した場合。
		Consumer<List<Integer>> con1 = new Consumer<List<Integer>>() {
			public void accept(List<Integer> list) {
				Collections.sort(list);
			}
		};
		con1.accept(list);

		// ラムダ式を使用した場合。
		Consumer<List<Integer>> con2 = lambdaList -> Collections.sort(list);
		con2.accept(list);

		// メソッド参照を使用した場合。
		Consumer<List<Integer>> con3 = Collections::sort;
		con3.accept(list);

		System.out.println(list);
	}
}
