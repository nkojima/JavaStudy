package java8.localdate;

import java.time.LocalDate;

/**
 * 日付の加減算を行うサンプルコード。
 * @author NKOJIMA
 *
 */
public class DateCalculation {

	public static void main(String[] args) {
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
}
