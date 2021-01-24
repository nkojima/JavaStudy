package generics;

public class GenericMethod {

	public static void main(String[] args) {
		System.out.println(isInteger(123));
		System.out.println(isInteger(new Integer(123)));
		System.out.println(isInteger(123L));

		printClass(123, 345L);
		printClass2(123, "345");

		System.out.println(noProcessing("abc").getClass());
	}

	/**
	 * Integer型であるかを判定する。
	 * ※引数が総称型の場合、戻り値の前に総称型を定義する。
	 * @param <T>
	 * @param value
	 * @return Integer型であればtrue、それ以外はfalseを返す。
	 */
	public static <T> boolean isInteger(final T value) {
		System.out.println("----- isInteger -----");
		return (value instanceof Integer);
	}

	/**
	 * 2つの引数の型を出力する。
	 * 二つの引数それぞれに別の総称型を割り当てた場合。
	 * @param <T>
	 * @param <U>
	 * @param value1
	 * @param value2
	 */
	public static <T,U> void printClass(T value1, U value2) {
		System.out.println("----- printClass -----");
		System.out.println(value1.getClass());
		System.out.println(value2.getClass());
	}

	/**
	 * 2つの引数の型を出力する。
	 * 二つの引数に同じ総称型を割り当てた場合。
	 * @param <T>
	 * @param value1
	 * @param value2
	 */
	public static <T> void printClass2(T value1, T value2) {
		System.out.println("----- printClass2 -----");
		System.out.println(value1.getClass());
		System.out.println(value2.getClass());
	}

	/**
	 * 引数をそのまま返すだけの処理。
	 * 引数と戻り値に同じ総称型を割り当てた場合。
	 * @param <T>
	 * @param value
	 * @return
	 */
	public static <T> T noProcessing(T value) {
		System.out.println("----- noProcessing -----");
		return value;
	}
}
