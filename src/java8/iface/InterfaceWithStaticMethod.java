package java8.iface;

/**
 * staticメソッドとdefaultメソッドを持つインターフェース。
 * ※Java8からの新機能。
 * @author NKOJIMA
 *
 */
public interface InterfaceWithStaticMethod {

	/**
	 * staticメソッド。
	 * これを使うとmainメソッド（public static void main(String[] args)...）もインターフェースに定義できる。
	 * @return
	 */
	public static int getValue() {
		return 123;
	}

	/**
	 * デフォルトメソッド。
	 * このインターフェースを実装したクラスにおいて、メソッドの処理内容を記述する必要がなくなる。
	 * @return
	 */
	default String getName() {
		return "nkojima";
	}
}
