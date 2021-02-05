package algorithm.cipher;

/**
 * 「シーザー暗号風」の暗号化、復号化を行うクラス。
 * @author NKOJIMA
 *
 */
public class CaesarCipher {

	/**
	 * コードポイントをずらすシフト数。
	 */
	private static final int NUMBER_OF_SHIFTS = 3;

	public static void main(String[] args) {
		String message = "123ABCあいう";

		String encrypted = encrypt(message);
		System.out.println("暗号化した文字列：" + encrypted);

		String decrypted = decrypt(encrypted);
		System.out.println("復号化した文字列：" + decrypted);
	}

	/**
	 * Unicodeコードポイントをずらして暗号化する。
	 * @param text 暗号化するテキスト。
	 * @return 暗号化された文字列。
	 */
	private static String encrypt(String text) {
		int length = text.length();
		String encryptedText = "";

		for (int i=0; i<length; i++) {
			int codePoint = text.codePointAt(i) + NUMBER_OF_SHIFTS;
			encryptedText += new String(Character.toChars(codePoint));
		}

		return encryptedText;
	}

	/**
	 * Unicodeコードポイントをずらして復号化する。
	 * @param encryptedText 暗号化されたテキスト。
	 * @return 復号化された文字列。
	 */
	private static String decrypt(String encryptedText) {
		int length = encryptedText.length();
		String decryptedText = "";

		for (int i=0; i<length; i++) {
			int codePoint = encryptedText.codePointAt(i) - NUMBER_OF_SHIFTS;
			decryptedText += new String(Character.toChars(codePoint));
		}

		return decryptedText;
	}
}
