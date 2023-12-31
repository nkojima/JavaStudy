package other.developer;

public class AvailabilityTest {

	public static void main(String[] args) {

		// 稼働率(%)から年間停止時間を求める。
		Availability av1 = new Availability(99d);  // int型で渡すと年間停止時間(秒)として扱われてしまう
		av1.printDowntime();

		// 稼働率(%)から年間停止時間を求める。
		Availability av2 = new Availability(99.5);
		av2.printDowntime();

		// 年間停止時間(秒)から稼働率(%)を求める。
		Availability av3 = new Availability(10000);
		av3.printOccupancyRate();
/*
		Availability av3 = new Availability(99.96829);
		System.out.println(av3.printOccupancyRate());
		System.out.println(av3.printDowntime());
*/
	}
}
