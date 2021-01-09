package java8.date_time.time_zone;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ManualZoneId {

	public static void main(String[] args) {
		printAllZoneId();
		setNewYork();
	}


	private static void printAllZoneId() {
		Set<String> zoneIdSet = ZoneId.getAvailableZoneIds();
		for (String zoneId : zoneIdSet) {
			System.out.println(zoneId);
		}
	}

	private static void setNewYork() {
		ZoneId id = ZoneId.of("America/New_York");
		ZonedDateTime zonedDateTime = ZonedDateTime.now(id);
		System.out.println("ニューヨークのTimeZoneの日時: " + zonedDateTime); // 日本標準時の方がニューヨークよりも14時間進んでいるはず。
	}
}
