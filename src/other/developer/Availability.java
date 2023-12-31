package other.developer;

/**
 * 可用性クラス
 * @author NKOJIMA
 */
public class Availability {

	/** 1年間の秒数 */
	private static final int SECONDS_PER_YEAR = 365 * 24 * 60 * 60;

	/** 稼働率(%) */
	private double occupancyRate;

	/** 年間停止時間(秒) */
	private double annualDownTimeSec;

	/**
	 * コンストラクタ
	 * @param occupancyRate 稼働率(%)
	 */
	public Availability(double occupancyRate) {
		this.occupancyRate = occupancyRate;
		this.calcDowntimeAsSec();
	}

	/**
	 * コンストラクタ
	 * @param annualDownTimeSec 年間停止時間(秒)
	 */
	public Availability(int annualDownTimeSec) {
		this.annualDownTimeSec = (double)annualDownTimeSec;
		this.calcOccupancyRate();
	}

	/**
	 * 稼働率(%)から年間停止時間(秒)を求める。
	 */
	private void calcDowntimeAsSec() {
		this.annualDownTimeSec = SECONDS_PER_YEAR - (SECONDS_PER_YEAR * this.occupancyRate / 100);
	}

	/**
	 * 年間停止時間(秒)から稼働率(%)を求める。
	 */
	private void calcOccupancyRate() {
		this.occupancyRate = 100 - (this.annualDownTimeSec / SECONDS_PER_YEAR * 100);
	}

	/**
	 * 年間停止時間を標準出力する。
	 * @return
	 */
	public void printDowntime() {
		int numOfDays = 0;
		int hour = (int)annualDownTimeSec / 3600;
		int minute = ((int)annualDownTimeSec % 3600) / 60;
		int second = (int)annualDownTimeSec % 60;

		if (hour > 24) {
			numOfDays = hour / 24;
			hour = hour % 24;
		}
		System.out.println("年間停止時間：" + numOfDays + "日" + hour + "時間" + minute + "分" + second + "秒");
	}

	/**
	 * 稼働率を標準出力する。
	 * @return
	 */
	public void printOccupancyRate() {
		System.out.println("稼働率(%)：" + String.format("%.5f", occupancyRate) + "%");
	}
}
