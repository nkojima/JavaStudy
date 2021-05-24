package algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * ヒープソートを行うクラス。
 * @author NKOJIMA
 *
 */
public class HeapSort extends Sort {

	/**
	 * ■ヒープの実装方法（インデックスが0から始まる場合）
	 * ノードnに対して...
	 * 親：(n-1) / 2
	 * 左の子：2 * n + 1
	 * 右の子：2 * n + 2
	 */

	public static void main(String[] args) {
		System.out.println("昇順に並べ替える");

		List<Integer> list = createIntList();
		System.out.println("初期状態：" + list.toString());

		List<Integer> sortedList = sortByAsc(list);

		System.out.println("処理後の状態：" + sortedList.toString());
	}

	/**
	 * 昇順にソートする。
	 * @param list ソートするリスト。
	 * @return ソートされたリスト。
	 * @see http://www.th.cs.meiji.ac.jp/assets/researches/2005/omoto/heapsort.html
	 * @see https://qiita.com/r-ngtm/items/f4fa55c77459f63a5228
	 */
	public static List<Integer> sortByAsc(List<Integer> list) {
		List<Integer> sortedList = new ArrayList<Integer>();

		// 枝先の子ノードから探索して、子ノードが親ノードよりも小さい時は入れ替える。
		while (list.size() > 0) {
			for (int i=list.size()-1; i>0; i--) {
				int parentIdx = (i-1) / 2;

				int childValue = list.get(i);
				int parentValue = list.get(parentIdx);

				if (parentValue > childValue) {
					int buff = childValue;
					list.set(i, parentValue);
					list.set(parentIdx, buff);
				}
			}

			// 根元のノード（リストの先頭）が一番小さな値になっているので、それをソート済みリストに挿入して、元のリストから除去する。
			sortedList.add(list.get(0));
			list.remove(0);
		}
		return sortedList;
	}
}
