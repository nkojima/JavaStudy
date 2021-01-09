package java8.date_time;

import java.time.LocalDate;
import java.time.Period;

/**
 * Periodクラスを使った日付の差の計算。
 * @author NKOJIMA
 *
 */
public class DateDiff {

	public static void main(String[] args) {

		LocalDate ld1 = LocalDate.of(2019, 2, 3);
		LocalDate ld2 = LocalDate.of(2020, 4, 15);

		System.out.println("日付1：" + ld1);
		System.out.println("日付2：" + ld2);

		Period p = Period.between(ld1, ld2);

		System.out.println("Periodオブジェクトの中身：" + p); // P1Y2M12D -> 日付の差が「1年、2月、12日」という意味。
		System.out.println("「年」の差：" + p.getYears());
		System.out.println("「月」の差：" + p.getMonths());
		System.out.println("「日」の差：" + p.getDays());
	}

}
