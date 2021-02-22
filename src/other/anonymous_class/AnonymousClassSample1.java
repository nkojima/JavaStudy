package other.anonymous_class;

/**
 * 匿名クラスのサンプルコード。
 * @author NKOJIMA
 *
 */
public class AnonymousClassSample1 {

	public static void main(String[] args) {

		// 通常の匿名クラスの使い方。
		new User() {
		}.getName();

		// オーバーライドを使った匿名クラスの使い方。
		new User() {
			@Override
			public void getName() {
				System.out.println("mkojima");
			}
		}.getName();

		// 匿名クラスにメソッドを追加する場合の使い方。
		new User() {
			public void getId() {
				System.out.println(123);
			}
		}.getId();
	}
}

class User {
	public void getName() {
		System.out.println("nkojima");
	}
}
