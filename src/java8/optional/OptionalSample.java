package java8.optional;

import java.util.Optional;

/**
 * Optionalを使ったサンプルコード。
 * @author NKOJIMA
 *
 */
public class OptionalSample {

	public static void main(String[] args) {
		System.out.println("おみくじを引きます。");

		for (int i=0; i<10; i++) {
			// drawOmikujiの戻り値が存在しない（empty）場合は、orElseの引数を返す。
			System.out.println("おみくじの結果：" + drawOmikuji().orElse("失敗..."));
		}
	}

	/**
	 * おみくじを引く。
	 * @return おみくじの結果。
	 */
	static Optional<String> drawOmikuji() {
		Optional<String> message;
		double rnd = Math.random();

		if (rnd > 0.8) {
			message = Optional.of("very good luck");		// 大吉
		} else if (rnd > 0.6) {
			message = Optional.of("good luck");				// 吉
		} else if (rnd > 0.4) {
			message = Optional.of("bad luck");				// 凶
		} else if (rnd > 0.2) {
			message = Optional.of("extremely bad luck");	// 大凶
		} else {
			message = Optional.empty();						// nullの代わりにOptional.empty()を返す。
		}

		return message;
	}
}
