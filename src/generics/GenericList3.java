package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericList3 {

	public static void main(String[] args) {
		System.out.println(getList(0).get(0).getClass());	// Integer型のListが返される。
		System.out.println(getList(1).get(0).getClass());	// Number型のListが返される。
	}

	/**
	 * 引数がtrueであればIntegerのList、falseであればNumberのListを返す。
	 * ※実行されるまで戻り値のListの要素の型が不明なので、ワイルドカードを使用している。
	 * ※「? super T」は「TもしくはTの先祖クラス」を使うことができ、下限付き境界ワイルドカードと呼ばれる。
	 * @param flag
	 * @return
	 */
	private static List<? super B> getList(int value) {
		if (value == 0) {
			List<A> list = new ArrayList<A>();
			list.add(new A());
			return list;
		} else if (value == 1) {
			List<B> list = new ArrayList<B>();
			list.add(new B());
			return list;
		} else {
			// クラスBの先祖クラスではないクラスCは使えない。
//			List<C> list = new ArrayList<C>();
//			list.add(new C());
//			return list;
			return Arrays.asList(new A());
		}
	}
}
