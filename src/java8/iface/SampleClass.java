package java8.iface;

public class SampleClass {

	public static void main(String[] args) {

		// staticメソッドはインターフェースから直接呼び出す。
		System.out.println("staticメソッドの実行結果：" + InterfaceWithStaticMethod.getValue());

		ImplementClass iClass = new ImplementClass();

		// デフォルトメソッドの実行
		System.out.println("デフォルトメソッドの実行結果：" + iClass.getName());

		// インターフェースを実装したクラス内のメソッドの実行
		System.out.println("通常のメソッドの実行結果：" + iClass.getLanguage());
	}

}
