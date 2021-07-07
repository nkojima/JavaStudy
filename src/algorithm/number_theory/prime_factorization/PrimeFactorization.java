package algorithm.number_theory.prime_factorization;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 素因数分解を行うクラス
 * @author NKOJIMA
 *
 */
public class PrimeFactorization {

	public static void main(String[] args) throws Exception {
		int number = 60;
		Map<Integer, Integer> primeFactors = calc(number);

		System.out.println(number + "の素因数分解の結果");

		String primeFactorsText = primeFactors.entrySet().stream()
			.map(entry -> entry.getKey() + "^" + entry.getValue())
			.collect(Collectors.joining(" * "));

		System.out.println(primeFactorsText);

	}

	/**
	 * 素因数分解を行う。
	 * @throws Exception
	 */
	private static Map<Integer, Integer> calc(int number) throws Exception {

		// キーが素因数、値が素因数の出現数（べき乗）のMap
		Map<Integer, Integer> primeFactors = new TreeMap<Integer, Integer>();

		// 1以下の整数は素因数分解できない。
		if (number<=1) {
			throw new Exception(number + "は素因数分解できません。");
		}

		// 2からnumberまで、順に割り切れる数を探していく。
		for (int i=2; i<=number; i++) {
			// iで割り切れない時は次の数に移る。
			if (number % i != 0) continue;

			// iで割り切れなくなるまで割り続ける。
			int count = 0;
			while (number % i == 0) {
				count++;
				number = number / i;
			}
			primeFactors.put(i, count);
		}

		return primeFactors;
	}
}
