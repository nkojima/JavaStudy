package java8.date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * 日付文字列をLocalDate型に変換するサンプルコード。
 * @author NKOJIMA
 *
 */
public class DateTextParser {

	/** 日付文字列 */
	private static final String DATE_STRING = "2020-11-07";

	/** 存在しない日付の日付文字列 */
	private static final String INVALID_DATE_STRING = "2019-02-29";

	/** フォーマットが不正な日付文字列 */
	private static final String INVALID_FORMAT_DATE_STRING = "2019/02/28";

	private static final String DATETIME_STRING = "2020-11-30T23:31:05";

	private static final String INVALID_DATETIME_STRING = "2020-11-30T24:31:05";

	private static final String INVALID_FORMAT_DATETIME_STRING = "2020/11/30T23:31:05";

	public static void main(String[] args) {
		parseDate();
		parseDateTime();
	}

	private static void parseDate() {
		LocalDate ld = LocalDate.parse(DATE_STRING, DateTimeFormatter.ISO_DATE);
		System.out.println("日付は" + ld + "です。");

		// 存在しない不正な日付をパースしようとすると、DateTimeParseExceptionが送出される。
		try {
			LocalDate.parse(INVALID_DATE_STRING, DateTimeFormatter.ISO_DATE);
		} catch (DateTimeParseException dtpe) {
			dtpe.printStackTrace();
		}

		// フォーマットに適合しない不正な日付をパースしようとすると、DateTimeParseExceptionが送出される。
		try {
			LocalDate.parse(INVALID_FORMAT_DATE_STRING, DateTimeFormatter.ISO_DATE);
		} catch (DateTimeParseException dtpe) {
			dtpe.printStackTrace();
		}
	}

	private static void parseDateTime() {
		LocalDateTime ldt = LocalDateTime.parse(DATETIME_STRING, DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("日付は" + ldt + "です。");

		// 存在しない不正な日時をパースしようとすると、DateTimeParseExceptionが送出される。
		try {
			LocalDateTime.parse(INVALID_DATETIME_STRING, DateTimeFormatter.ISO_DATE);
		} catch (DateTimeParseException dtpe) {
			dtpe.printStackTrace();
		}

		// フォーマットに適合しない不正な日時をパースしようとすると、DateTimeParseExceptionが送出される。
		try {
			LocalDateTime.parse(INVALID_FORMAT_DATETIME_STRING, DateTimeFormatter.ISO_DATE);
		} catch (DateTimeParseException dtpe) {
			dtpe.printStackTrace();
		}
	}
}
