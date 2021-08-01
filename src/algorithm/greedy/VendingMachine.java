package algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 自動販売機クラス
 * @author NKOJIMA
 *
 */
public class VendingMachine {

	/**
	 * 日本の硬貨のリスト。
	 */
	private static final int[] JP_COINS = {500, 100, 50, 10, 5, 1};


	public static void main(String[] args) {
		int change = 786; // 釣り銭額
		List<Coin> changeList = giveChange(change);

		System.out.println("釣り銭：" + change + "円");

		for (Coin ch : changeList) {
			System.out.println(ch.value + "円：" + ch.number + "枚");
		}
	}

	/**
	 * 釣り銭として必要な硬貨の枚数を求める。
	 * @param change
	 */
	private static List<Coin> giveChange(int change) {
		List<Coin> chargeList = new ArrayList<Coin>();

		for (int coin : JP_COINS) {
			int numberOfCoins = change / coin;	// i番目の硬貨の必要枚数を求める。
			chargeList.add(new Coin(coin, numberOfCoins));
			change = change % coin;
		}

		return chargeList;
	}
}

/**
 * 硬貨クラス
 * @author NKOJIMA
 *
 */
class Coin {
	/**
	 * 硬貨の額面
	 */
	int value;

	/**
	 * 硬貨の枚数
	 */
	int number;

	/**
	 * コンストラクタ
	 * @param value 硬貨の額面。
	 * @param number 硬貨の枚数。
	 */
	public Coin(int value, int number) {
		this.value = value;
		this.number = number;
	}
}
