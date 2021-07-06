package java8.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringSort {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("Apple","Orange","Grape", "Cherry"));
		sortAsc(list);
		sortDsc(list);
	}

	/**
	 * 昇順にソートする。
	 * @param list
	 */
	public static void sortAsc(List<String> list) {
		System.out.println("----- 昇順にソート -----");
		System.out.println("元のリスト：" + list.toString());
		Collections.sort(list);
		System.out.println("ソート後のリスト：" + list.toString());
	}

	/**
	 * 降順にソートする。
	 * @param list
	 */
	public static void sortDsc(List<String> list) {
		System.out.println("----- 降順にソート -----");
		System.out.println("元のリスト：" + list.toString());
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("ソート後のリスト：" + list.toString());
	}
}