package java8.zoned_date;

import java.time.ZoneId;

/**
 * デフォルトのZoneIdを用いるクラス。
 * @author NKOJIMA
 *
 */
public class DefaultZoneId {
	public static void main(String[] args) {
		System.out.println("デフォルトのZoneId: " + ZoneId.systemDefault());
	}
}
