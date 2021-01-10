package java8.date_time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class Converter {

	public static void main(String[] args) {
		toZonedDateTime();
		toOffsetDateTime();
		toInstant();

		toDate();
		toDateTime();
	}

	/**
	 * LocalDateTimeからZonedDateTimeに変換する。
	 */
	public static void toZonedDateTime() {
		System.out.println("----- LocalDateTime -> ZonedDateTime -----");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);

		ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
		System.out.println(zdt);
	}

	/**
	 * LocalDateTimeからOffsetDateTimeに変換する。
	 */
	public static void toOffsetDateTime() {
		System.out.println("----- LocalDateTime -> OffsetDateTime -----");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);

		OffsetDateTime odt = ldt.atOffset(ZoneOffset.ofHours(9));
		System.out.println(odt);
	}

	/**
	 * LocalDateTimeからInstantに変換する。
	 */
	public static void toInstant() {
		System.out.println("----- LocalDateTime -> Instant -----");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);

		Instant instant = ldt.toInstant(ZoneOffset.ofHours(9));
		System.out.println(instant);
	}

	/**
	 * LocalDateTime、ZonedDateTime、OffsetDateTimeからDate型に変換する。
	 */
	public static void toDate() {
		System.out.println("----- LocalDateTime -> Date -----");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		Date date1 = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		// Date date1 = Date.from(ldt.toInstant(ZoneOffset.ofHours(9))); // こちらでも同じ。
		System.out.println(date1);

		System.out.println("----- ZonedDateTime -> Date -----");
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		Date date2 = Date.from(zdt.toInstant());
		System.out.println(date2);

		System.out.println("----- OffsetDateTime -> Date -----");
		OffsetDateTime odt = OffsetDateTime.now();
		System.out.println(odt);
		Date date3 = Date.from(odt.toInstant());
		System.out.println(date3);
	}

	/**
	 * Date型からLocalDateTime、ZonedDateTime、OffsetDateTimeに変換する。
	 */
	public static void toDateTime() {
		Date date =  new Date();

		System.out.println("----- Date -> LocalDateTime -----");
		LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		System.out.println(ldt);

		System.out.println("----- Date -> ZonedDateTime -----");
		ZonedDateTime zdt = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		System.out.println(zdt);

		System.out.println("----- Date -> OffsetDateTime -----");
		OffsetDateTime odt = OffsetDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		System.out.println(odt);
	}
}
