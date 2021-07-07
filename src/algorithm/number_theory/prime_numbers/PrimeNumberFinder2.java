package algorithm.number_theory.prime_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumberFinder2 {

	public static void main(String[] args) {
		printPrimeNumbers2(100);
	}

	/**
	 * 指定した値を上限値として、1～上限値までの間で素数を求める。
	 * @param maxNumber 素数を求める際の上限値。
	 */
	static void printPrimeNumbers2(int maxNumber) {

	    // ステップ1：「2から上限値までの整数」を探索リストに入れる。
	    boolean[] targetNumbers = new boolean[maxNumber + 1];
	    Arrays.fill(targetNumbers, true);
	    targetNumbers[0] = false;
	    targetNumbers[1] = false;

	    // 素数リスト
	    List<Integer> primeNumbers = new ArrayList<Integer>();

	    int sqrt = (int) Math.sqrt(maxNumber);

	    // ステップ3：探索リストの先頭の値が、引数の平方根に達するまでふるい落とし操作を続ける。
	    for(int i=2; i<=sqrt; i++) {
	        // ステップ2：探索リストの先頭の数を素数とし、その倍数を探索リストから篩い落とす。
	        // ※この時、既に篩い落とされた数（false）は除外する。
	        int firstNum = i;
	        if (targetNumbers[i]) {
	            for (int j=i*firstNum; j<targetNumbers.length; j+=firstNum) {
	                targetNumbers[j] = false;
	            }
	        }
	    }

	    // ステップ4：探索リストに残った値を素数リストに移して処理終了。
	    for (int i=2; i<targetNumbers.length; i++) {
	        if (targetNumbers[i]) {
	            primeNumbers.add(i);
	        }
	    }

	    // 素数の表示
	    System.out.println(primeNumbers.stream().map(pNum -> pNum.toString()).collect(Collectors.joining("\t")));
	}
}
