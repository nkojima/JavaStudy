package other.anonymous_class;

/**
 * 匿名クラスのサンプルコード（インターフェース利用）。
 * @author NKOJIMA
 *
 */
public class AnonymousClassSample2 {

	public static void main(String[] args) {
		new User() {
			public void getName() {
				System.out.println("nkojima");
			}
		}.getName();
	}
}

interface Employee {
	void getName();
}