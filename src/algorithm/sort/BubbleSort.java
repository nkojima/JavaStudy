package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * バブルソートを行うクラス。
 * @author NKOJIMA
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		sortAscending();
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
	 * 1～10までの値がランダムに並んだリストを返す。
	 * @return
	 */
	private static List<Integer> createIntList() {
		// 1～10のリストを作り、並び順をシャッフルする。
		List<Integer> list =
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		Collections.shuffle(list);

		return list;
	}
}
