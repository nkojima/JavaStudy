package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ソート処理に関するクラスのスーパークラス。
 * @author NKOJIMA
 *
 */
public class Sort {

	/**
	 * 1～10までの値がランダムに並んだリストを返す。
	 * @return
	 */
	protected static List<Integer> createIntList() {
		// 1～10のリストを作り、並び順をシャッフルする。
		List<Integer> list =
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		Collections.shuffle(list);

		return list;
	}
}
