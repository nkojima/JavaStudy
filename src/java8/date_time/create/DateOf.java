package java8.date_time.create;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateOf {

	public static void main(String[] args) {
		printDate();
		printDateTime();
		printZonedDateTime();
		printOffsetDateTime();
	}

	/**
	 * 現在日を表示する。
	 */
	private static void printDate() {
		System.out.println("----- LocalDate -----");
		LocalDate dt = LocalDate.of(2021, 1, 5);
		System.out.println("現在日:" + dt);
	}

	/**
	 * 現在日時を表示する。
	 */
	private static void printDateTime() {
		System.out.println("----- LocalDateTime -----");
		LocalDateTime ldt = LocalDateTime.of(2021, 1, 5, 23, 29, 15);
		System.out.println("現在日時:" + ldt);
	}

	/**
	 * タイムゾーンを指定した現在日時を表示する。
	 */
	private static void printZonedDateTime() {
		System.out.println("----- ZonedDateTime -----");
		ZonedDateTime zdt = ZonedDateTime.of(2021, 1, 5, 23, 29, 15, 0, ZoneId.systemDefault()); // システムのデフォルトのタイムゾーンを利用する。
		System.out.println("現在日時:" + zdt);
	}

	/**
	 * オフセット付きの現在日時を表示する。
	 */
	private static void printOffsetDateTime() {
		System.out.println("----- OffsetDateTime -----");
		OffsetDateTime odt = OffsetDateTime.of(2021, 1, 5, 23, 29, 15, 0, ZoneOffset.ofHours(9));
		System.out.println("現在日時:" + odt);
	}
}
