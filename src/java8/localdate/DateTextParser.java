package java8.localdate;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 日付文字列をLocalDate型に変換するサンプルコード。
 * @author NKOJIMA
 *
 */
public class DateTextParser {

	private static final String DATE_STRING = "2020-11-07";

	private static final String INVALID_DATE_STRING = "2019-02-29";

	private static final String INVALID_FORMAT_DATE_STRING = "2019/02/28";

	public static void main(String[] args) {
		LocalDate dt = LocalDate.parse(DATE_STRING, DateTimeFormatter.ISO_DATE);
		System.out.println("日付は" + dt + "です。");

		// 存在しない不正な日付をパースしようとすると、DateTimeExceptionが送出される。
		try {
			LocalDate.parse(INVALID_DATE_STRING, DateTimeFormatter.ISO_DATE);
		} catch (DateTimeException dte) {
			dte.printStackTrace();
		}

		// フォーマットに適合しない不正な日付をパースしようとすると、DateTimeExceptionが送出される。
		try {
			LocalDate.parse(INVALID_FORMAT_DATE_STRING, DateTimeFormatter.ISO_DATE);
		} catch (DateTimeException dte) {
			dte.printStackTrace();
		}
	}

}