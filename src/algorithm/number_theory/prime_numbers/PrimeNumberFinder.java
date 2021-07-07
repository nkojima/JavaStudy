package algorithm.number_theory.prime_numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberFinder {

	public static void main(String[] args) {
		printPrimeNumbers(100);
	}

	/**
	 * 指定した値を上限値として、1～上限値までの間で素数を求める。
	 * @param maxNumber 素数を求める際の上限値。
	 */
	static void printPrimeNumbers(int maxNumber) {

	    // ステップ1：「2から上限値までの整数」を探索リストに入れる。
	    List<Integer> targetNumbers = IntStream.rangeClosed(2, maxNumber).boxed().collect(Collectors.toList());

	    // 素数リスト
	    List<Integer> primeNumbers = new ArrayList<Integer>();

	    int sqrt = (int) Math.sqrt(maxNumber);

	    // ステップ3：探索リストの先頭の値が、引数の平方根に達するまでふるい落とし操作を続ける。
	    while(targetNumbers.get(0)<=sqrt) {
	        // ステップ2：探索リストの先頭の数を素数リストに入れて、その倍数を探索リストから篩い落とす。
	        int firstNum = targetNumbers.get(0);
	        primeNumbers.add(firstNum);
	        targetNumbers.removeIf(num -> (num % firstNum == 0));
	    }

	    // ステップ4：探索リストに残った値を素数リストに移して処理終了。
	    primeNumbers.addAll(targetNumbers);

	    // 素数の表示
	    System.out.println(primeNumbers.stream().map(pNum -> pNum.toString()).collect(Collectors.joining("\t")));
	}
}
