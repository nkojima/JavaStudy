package java8.method_reference;

import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntSupplier;

/**
 * 様々なメソッド参照のサンプルコードをまとめたクラス。
 * @author NKOJIMA
 * @see http://www.ne.jp/asahi/hishidama/home/tech/java/methodreference.html
 *
 */
public class VariousMethodReference {

	public static void main(String[] args) {
		args0();
		args1();
		args2();
	}

	/**
	 * 引数が0個のパターン。
	 */
	public static void args0() {
		System.out.println("引数が0個のパターン");
		String txt = "abc";

		/*
		 *  【引数が0個＋メソッド参照】の場合。
		 *  IntSupplierは、引数無しで戻り値がint型のメソッド（getAsInt）を持つ。
		 *  IntSupplierにlengthメソッド（処理）を渡したいので、lengthメソッドの直前を「::」にする。
		 */
		IntSupplier sup1 = txt::length;
		System.out.println(sup1.getAsInt());

		/*
		 * 【引数が0個＋ラムダ式】の場合。
		 */
		IntSupplier sup2 = () -> txt.length();
		System.out.println(sup2.getAsInt());

		/*
		 * 【引数が0個＋匿名クラス】の場合。
		 */
		IntSupplier sup3 = new IntSupplier() {

			@Override
			public int getAsInt() {
				return txt.length();
			}
		};
		System.out.println(sup3.getAsInt());
	}

	/**
	 * 引数が1個のパターン
	 */
	public static void args1() {
		System.out.println("引数が1個のパターン");
		String txt = "abc";

		/*
		 * 【引数が1個＋メソッド参照】の場合。
		 *  Consumerは、引数が1個で戻り値がvoidのメソッド（accept）を持つ。
		 *  Consumerにprintlnメソッド（処理）を渡したいので、printlnメソッドの直前を「::」にする。
		 */
		Consumer<String> con1 = System.out::println;
		con1.accept(txt);

		/*
		 * 【引数が1個＋ラムダ式】の場合。
		 */
		Consumer<String> con2 = (String s) -> System.out.println(s);
		con2.accept(txt);

		/*
		 * 【引数が1個＋匿名クラス】の場合。
		 */
		Consumer<String> con3 = new Consumer<String>() {

			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};
		con3.accept(txt);
	}

	/**
	 * 引数が2個のパターン
	 */
	public static void args2() {
		System.out.println("引数が2個のパターン");

		/*
		 * 【引数が2個＋メソッド参照】の場合。
		 * IntBinaryOperatorは、引数が2個でintを返すメソッド（applyAsInt）を持つ。
		 * IntBinaryOperatorにsumめそっどぉ渡したいので、sumの直前を「::」にする。
		 */
		IntBinaryOperator ibo1 = Integer::sum;
		System.out.println(ibo1.applyAsInt(1, 2));

		/*
		 * 【引数が2個＋ラムダ式】の場合。
		 */
		IntBinaryOperator ibo2 = (int n1, int n2) -> Integer.sum(n1, n2);
		System.out.println(ibo2.applyAsInt(1, 2));

		/*
		 * 【引数が2個＋匿名クラス】の場合。
		 */
		IntBinaryOperator ibo3 = new IntBinaryOperator() {

			@Override
			public int applyAsInt(int n1, int n2) {
				return Integer.sum(n1, n2);
			}
		};
		System.out.println(ibo3.applyAsInt(1, 2));
	}
}