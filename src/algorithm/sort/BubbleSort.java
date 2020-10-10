package algorithm.sort;

import java.util.List;

/**
 * バブルソートを行うクラス。
 * @author NKOJIMA
 *
 */
public class BubbleSort extends Sort {

	public static void main(String[] args) {
		sortAscending();
		sortDescending();
	}

	/**
	 * 昇順に並べ替える。
	 */
	private static void sortAscending() {
		System.out.println("昇順に並べ替える");

		List<Integer> list = createIntList();
		System.out.println("初期状態：" + list.toString());

		int length = list.size();
		int tmp;

		for (int i=0; i<length-1; i++) {
			for (int j=length-1; i<j; j--) {
				if (list.get(j)<list.get(j-1)) {
					tmp = list.get(j);
					list.set(j, list.get(j-1));
					list.set(j-1, tmp);
				}
			}
		}

		System.out.println("処理後の状態：" + list.toString());
	}

	/**
	 * 降順に並べ替える。
	 */
	private static void sortDescending() {
		System.out.println("降順に並べ替える");

		List<Integer> list = createIntList();
		System.out.println("初期状態：" + list.toString());

		int length = list.size();
		int tmp;

		for (int i=0; i<length-1; i++) {
			for (int j=length-1; i<j; j--) {
				if (list.get(j)>list.get(j-1)) {
					tmp = list.get(j);
					list.set(j, list.get(j-1));
					list.set(j-1, tmp);
				}
			}
		}

		System.out.println("処理後の状態：" + list.toString());
	}
}
