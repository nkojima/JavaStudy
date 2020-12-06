package java8.localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 日付、日時の加減算を行うサンプルコード。
 * @author NKOJIMA
 *
 */
public class DateCalculation {

	public static void main(String[] args) {
		calcDate();
		calcDateTime();
	}

	private static void calcDate() {
		System.out.println("----- LocalDate -----");
		LocalDate dt = LocalDate.of(2020, 11, 07);

		// 日付の加算
		System.out.println(dt + "の1日後：" + dt.plusDays(1));
		System.out.println(dt + "の1ヶ月後：" + dt.plusMonths(1));
		System.out.println(dt + "の1年後：" + dt.plusYears(1));

		// 日付の減算
		System.out.println(dt + "の1日前：" + dt.minusDays(1));
		System.out.println(dt + "の1ヶ月前" + dt.minusMonths(1));
		System.out.println(dt + "の1年前：" + dt.minusYears(1));
	}

	private static void calcDateTime() {
		System.out.println("----- LocalDateTime -----");
		LocalDateTime ldt = LocalDateTime.of(2020, 11, 28, 22, 54, 5);

		// 日時の加算
		System.out.println(ldt + "の1秒後：" + ldt.plusSeconds(1));
		System.out.println(ldt + "の1分後：" + ldt.plusMinutes(1));
		System.out.println(ldt + "の1時間後：" + ldt.plusHours(1));
		System.out.println(ldt + "の1日後：" + ldt.plusDays(1));
		System.out.println(ldt + "の1ヶ月後：" + ldt.plusMonths(1));
		System.out.println(ldt + "の1年後：" + ldt.plusYears(1));

		// 日時の減算
		System.out.println(ldt + "の1秒前：" + ldt.minusSeconds(1));
		System.out.println(ldt + "の1分前：" + ldt.minusMinutes(1));
		System.out.println(ldt + "の1時間前：" + ldt.minusHours(1));
		System.out.println(ldt + "の1日前：" + ldt.minusDays(1));
		System.out.println(ldt + "の1ヶ月前" + ldt.minusMonths(1));
		System.out.println(ldt + "の1年前：" + ldt.minusYears(1));
	}
}
