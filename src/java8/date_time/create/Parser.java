package java8.date_time.create;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * 日付文字列をLocalDate型に変換するサンプルコード。
 * @author NKOJIMA
 *
 */
public class Parser {

	public static void main(String[] args) {
		parseDate();
		parseDateTime();
	}

	private static void parseDate() {
		LocalDate ld = LocalDate.parse("2020-11-07", DateTimeFormatter.ISO_DATE);
		System.out.println("日付は" + ld + "です。");

		// 存在しない不正な日付、もしくはフォーマットに適合しない不正な日付をパースしようとすると、DateTimeParseExceptionが送出される。
		try {
			LocalDate.parse("2019-02-29", DateTimeFormatter.ISO_DATE);
			//LocalDate.parse("2019/02/28", DateTimeFormatter.ISO_DATE);
		} catch (DateTimeParseException dtpe) {
			dtpe.printStackTrace();
		}
	}

	private static void parseDateTime() {
		LocalDateTime ldt = LocalDateTime.parse("2020-11-30T23:31:05", DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("日付は" + ldt + "です。");

		// 存在しない不正な日付、もしくはフォーマットに適合しない不正な日付をパースしようとすると、DateTimeParseExceptionが送出される。
		try {
			LocalDateTime.parse("2020-11-31T23:31:05", DateTimeFormatter.ISO_DATE);
			//LocalDateTime.parse("2020/11/30T23:31:05", DateTimeFormatter.ISO_DATE);
		} catch (DateTimeParseException dtpe) {
			dtpe.printStackTrace();
		}
	}
}
