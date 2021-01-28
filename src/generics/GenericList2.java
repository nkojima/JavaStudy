package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericList2 {

	public static void main(String[] args) {
		System.out.println(getList(true).get(0).getClass());	// Integer型のListが返される。
		System.out.println(getList(false).get(0).getClass());	// Double型のListが返される。
	}

	/**
	 * 引数がtrueであればIntegerのList、falseであればDoubleのListを返す。
	 * ※実行されるまで戻り値のListの要素の型が不明なので、ワイルドカードを使用している。
	 * ※「? extends T」は「TもしくはTの子孫クラス」を使うことができ、上限付き境界ワイルドカードと呼ばれる。
	 * @param flag
	 * @return
	 */
	private static List<? extends A> getList(boolean flag) {
		if (flag) {
			List<A> list = new ArrayList<>();
			list.add(new A());
			return list;
		} else {
			List<B> list = new ArrayList<>();
			list.add(new B());
			return list;
		}
	}
}