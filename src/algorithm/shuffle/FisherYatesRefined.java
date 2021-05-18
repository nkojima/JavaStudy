package algorithm.shuffle;

import java.util.Arrays;
import java.util.Random;

/**
 * フィッシャー・イェーツのシャッフルの改良版
 * @author NKOJIMA
 *
 */
public class FisherYatesRefined {

	/**
	 * 要素数がnの配列aryをシャッフルする(添字は0からn-1):
	 * @param args
	 */
	public static void main(String[] args) {

		int[] ary = {0,1,2,3,4,5,6,7,8,9};
		System.out.println("シャッフル前");
		Arrays.stream(ary).forEach((elem) -> System.out.print(elem));
		System.out.print("\n");

		int n = ary.length;
		Random rnd = new Random();

		// iをn-1から1まで減少させながら、以下を実行する
		for (int i=n-1; i>=1; i--) {
			// jに0以上i以下のランダムな整数を代入する
			int j = rnd.nextInt(i);

			// a[j]とa[i]を交換する
			int tmp = ary[i];
			ary[i] = ary[j];
			ary[j] = tmp;
		}

		System.out.println("シャッフル後");
		Arrays.stream(ary).forEach((elem) -> System.out.print(elem));
		System.out.print("\n");
	}

}
