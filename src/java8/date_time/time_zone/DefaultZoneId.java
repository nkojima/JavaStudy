package java8.date_time.time_zone;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * デフォルトのZoneIdを用いるクラス。
 * @author NKOJIMA
 *
 */
public class DefaultZoneId {
	public static void main(String[] args) {
		printZoneId();
		printZoneName();
		printZonedDateTime();
		printFormattedZonedDateTime();
	}

	private static void printZoneId() {
		System.out.println("デフォルトのTimeZoneId: " + ZoneId.systemDefault());
	}

	private static void printZoneName() {
		ZoneId id = ZoneId.systemDefault();
		System.out.println("デフォルトのTimeZone名(FULL): " + id.getDisplayName(TextStyle.FULL, Locale.JAPAN));
		System.out.println("デフォルトのTimeZone名(NARROW): " + id.getDisplayName(TextStyle.NARROW, Locale.JAPAN));
	}

	private static void printZonedDateTime() {
		ZoneId id = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = ZonedDateTime.now(id);
		System.out.println("デフォルトのTimeZoneの日時: " + zonedDateTime);
	}

	private static void printFormattedZonedDateTime() {
		ZoneId id = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = ZonedDateTime.now(id);
		System.out.println("デフォルトのTimeZoneの日時（フォーマット済）: " + zonedDateTime.format(DateTimeFormatter.ofPattern("YYYY年MM月dd日 HH時mm分ss秒 (VV) (zz) (O)")));
	}
}
