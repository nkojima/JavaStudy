package generics;

import java.util.Arrays;
import java.util.List;

public class GenericList {

	public static void main(String[] args) {
		System.out.println(getList(true).get(0).getClass());	// String型のListが返される。
		System.out.println(getList(false).get(0).getClass());	// Integer型のListが返される。

		/*
		 * 非境界ワイルドカードのListは実行されるまでデータ型が分からないため、
		 * addすることができない。
		 */
		//List<?> list = getList(true);
		//list.add(123);
	}

	/**
	 * 引数がtrueであればStringのList、falseであればIntegerのListを返す。
	 * ※実行されるまで戻り値のListの要素の型が不明なので、ワイルドカードを使用している。
	 * ※「?」は非境界ワイルドカードと呼ばれる。
	 * @param flag
	 * @return
	 */
	private static List<?> getList(boolean flag) {
		return flag ? Arrays.asList("1","2","3") : Arrays.asList(1,2,3);
	}
}
