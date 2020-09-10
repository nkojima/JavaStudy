package calendar;

public class GregorianCalendar {
	public static void main(String[] args) {
		for (int i=1990; i<=2020; i++) {
			System.out.println(i + "年：" + isLeapYear(i));
		}

	}

	/**
	 * 引数の西暦年が「うるう年」であるかを判定する。
	 * @param year
	 * @return
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
}
