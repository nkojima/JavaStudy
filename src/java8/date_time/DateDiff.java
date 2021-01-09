package java8.date_time;

import java.time.LocalDate;
import java.time.Period;

public class DateDiff {

	public static void main(String[] args) {

		LocalDate dt1 = LocalDate.of(2019, 2, 3);
		LocalDate dt2 = LocalDate.of(2020, 4, 15);

		System.out.println("日付1：" + dt1);
		System.out.println("日付2：" + dt2);

		Period p = Period.between(dt1, dt2);

		System.out.println("「年」の差：" + p.getYears());
		System.out.println("「月」の差：" + p.getMonths());
		System.out.println("「日」の差：" + p.getDays());
	}

}
