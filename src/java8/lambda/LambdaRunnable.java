package java8.lambda;

/**
 * Runnableインターフェースを利用したスレッド処理。
 * @author NKOJIMA
 *
 */
public class LambdaRunnable {

	public static void main(String[] args) {

		// 匿名クラスを使用したパターン。
		Runnable runner1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("sample1");
			}
		};
		runner1.run();

		// ラムダ式を使用したパターン。
		Runnable runner2 = () -> {
			System.out.println("sample2");
		};
		runner2.run();
	}
}
