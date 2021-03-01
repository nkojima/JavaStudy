package java8.method_reference;

import java.util.Comparator;

/**
 * staticメソッド参照のサンプルコード(2)。
 * @author NKOJIMA
 *
 */
public class StaticMethodReference2 {

	public static void main(String[] args) {
		// ラムダ式を使用した場合。
		Comparator<Integer> comp1 = (x, y) -> Integer.compare(x, y);
		System.out.println(comp1.compare(2, 3));
		System.out.println(comp1.compare(3, 2));

		// staticメソッド参照を使用した場合。
		Comparator<Integer> comp2 = Integer::compare;
		System.out.println(comp2.compare(2, 3));
		System.out.println(comp2.compare(3, 2));
	}
}