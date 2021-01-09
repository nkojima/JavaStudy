package java8.date_time;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Durationクラスを使った時刻の差の計算。
 * @author NKOJIMA
 *
 */
public class TimeDiff {

	public static void main(String[] args) {

		LocalDateTime ldt1 = LocalDateTime.of(2021, 1, 9, 12, 29, 50);
		LocalDateTime ldt2 = LocalDateTime.of(2021, 1, 10, 7, 5, 23);

		System.out.println("日付1：" + ldt1);
		System.out.println("日付2：" + ldt2);

		Duration d = Duration.between(ldt1, ldt2);

		System.out.println("Durationオブジェクトの中身：" + d); // PT18H35M33S -> 時刻の差が「0日、18時間、35分、33秒」という意味。
		System.out.println("「日」の差：" + d.toDays());
		System.out.println("「時」の差：" + d.toHours());
		System.out.println("「分」の差：" + d.toMinutes());
		System.out.println("「秒」の差：" + d.getSeconds());
	}

}
