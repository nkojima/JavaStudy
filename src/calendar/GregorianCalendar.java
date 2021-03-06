package calendar;

import java.time.DateTimeException;
import java.time.LocalDate;

public class GregorianCalendar {
	public static void main(String[] args) {
		for (int year=1990; year<=2020; year++) {
			System.out.println(year + "年：" + isLeapYear(year));
			System.out.println(year + "年：" + isLeapYear2(year));
		}

	}

	/**
	 * 引数の西暦年が「うるう年」であるかを判定する。
	 * @param year
	 * @return うるう年であればtrue、それ以外の年はfalseを返す。
	 */
	static boolean isLeapYear(int year) {
		if (year%4==0 && year%100!=0) {
			return true;
		} else if (year%400==0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * LocalDateクラスの例外を利用して、引数の西暦年が「うるう年」であるかを判定する。
	 * @param year
	 * @return うるう年であればtrue、それ以外の年はfalseを返す。
	 */
	static boolean isLeapYear2(int year) {

		try {
			LocalDate.of(year, 2, 29);	// うるう年でなければ例外が発生する。
			return true;
		} catch (DateTimeException dte) {
			return false;
		}
	}
}
