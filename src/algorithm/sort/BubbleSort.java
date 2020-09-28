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
		List<Integer> list = createIntList();
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
