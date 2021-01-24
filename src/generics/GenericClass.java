package generics;

/**
 * ジェネリッククラスのサンプル。
 * @author NKOJIMA
 *
 * @param <T>
 */
public class GenericClass<T> {

	/**
	 * 総称型のメンバ変数
	 */
	private T foo;

	/**
	 * 総称型を引数に持つコンストラクタ。
	 * @param t
	 */
	public GenericClass(T t) {
		this.foo = t;
	}

	public void print() {
		System.out.println(foo);
	}

	public static void main(String[] args) {
		// 引数をString型にした場合。
		GenericClass<String> g1 = new GenericClass<String>("abc");
		g1.print();

		// 引数をInteger型にした場合。
		// GenericClassをnewする際に型を指定しないと、コンパイル時に警告が出る。
		GenericClass<Integer> g2 = new GenericClass(123);
		g2.print();
	}
}
