package java8.localdate;

import java.time.LocalDate;

/**
 * https://blog.y-yuki.net/entry/2016/09/15/003000
 * @author NKOJIMA
 *
 */
public class Now {

	public static void main(String[] args) {
		LocalDate dt = LocalDate.now();

		// 現在日を単純に表示する。
		System.out.println("現在日:" + dt);

		// 現在日の年月日と曜日をそれぞれ表示する。
		System.out.println("年:" + dt.getYear());
		System.out.println("月:" + dt.getMonthValue());		// getMonth()だと月の英語名が返される。
		System.out.println("日:" + dt.getDayOfMonth());
		System.out.println("曜日:" + dt.getDayOfWeek());
	}

}
