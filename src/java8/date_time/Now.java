package java8.date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 現在日、現在日時を表示するサンプルコード。
 * https://blog.y-yuki.net/entry/2016/09/15/003000
 * @author NKOJIMA
 *
 */
public class Now {

	public static void main(String[] args) {
		printDate();
		printDateTime();
	}

	/**
	 * 現在日を表示する。
	 */
	private static void printDate() {
		System.out.println("----- LocalDate -----");

		LocalDate dt = LocalDate.now();

		// 現在日を単純に表示する。
		System.out.println("現在日:" + dt);

		// 現在日の年月日と曜日をそれぞれ表示する。
		System.out.println("年:" + dt.getYear());
		System.out.println("月:" + dt.getMonthValue());		// getMonth()だと月の英語名が返される。
		System.out.println("日:" + dt.getDayOfMonth());
		System.out.println("曜日:" + dt.getDayOfWeek());
	}

	/**
	 * 現在日時を表示する。
	 */
	private static void printDateTime() {
		System.out.println("----- LocalDateTime -----");

		LocalDateTime ldt = LocalDateTime.now();

		// 現在日時を単純に表示する。
		System.out.println("現在日時:" + ldt);

		// 現在日の年月日と曜日、時刻をそれぞれ表示する。
		System.out.println("年:" + ldt.getYear());
		System.out.println("月:" + ldt.getMonthValue());		// getMonth()だと月の英語名が返される。
		System.out.println("日:" + ldt.getDayOfMonth());
		System.out.println("曜日:" + ldt.getDayOfWeek());

		System.out.println("時:" + ldt.getHour());
		System.out.println("分:" + ldt.getMinute());
		System.out.println("秒:" + ldt.getSecond());
	}
}
