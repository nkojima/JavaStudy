package string.cipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TextEncoder {

	/**
	 * ハッシュアルゴリズムの種類
	 * https://docs.oracle.com/javase/jp/8/docs/technotes/guides/security/StandardNames.html#MessageDigest
	 * @author NKOJIMA
	 */
	private enum HashAlgorithm {
		MD5,
		SHA1,
		SHA256,
		SHA512
	}

	public static void main(String[] args) {
		String text = "qwerty2024";

		System.out.println("MD5: " + toHash(text, HashAlgorithm.MD5));
		System.out.println("SHA-1: " + toHash(text, HashAlgorithm.SHA1));
		System.out.println("SHA-256: " + toHash(text, HashAlgorithm.SHA256));
		System.out.println("SHA-512: " + toHash(text, HashAlgorithm.SHA512));
	}

	/**
	 * 文字列を指定した暗号化アルゴリズムでハッシュ化する。
	 * @param text 暗号化する文字列
	 * @param algorithm 暗号化アルゴリズム
	 * @return ハッシュ化された文字列。
	 */
	private static String toHash(String text, HashAlgorithm algorithm) {
		String hashAlgorithm = "";
		if (algorithm==HashAlgorithm.MD5) {
			hashAlgorithm = "MD5";
		} else if (algorithm==HashAlgorithm.SHA1) {
			hashAlgorithm = "SHA-1";
		} else if (algorithm==HashAlgorithm.SHA256) {
			hashAlgorithm = "SHA-256";
		} else {
			hashAlgorithm = "SHA-512";
		}

		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
			byte[] cipherBytes = md.digest(text.getBytes());

			for (int i=0; i<cipherBytes.length; i++) {
				sb.append(String.format("%02x", cipherBytes[i]&0xff));
			}
		} catch (NoSuchAlgorithmException ex1) {
			System.out.println("ハッシュアルゴリズム名が不正です。");
		} catch (NullPointerException ex2) {
			System.out.println("ハッシュアルゴリズム名が指定されていません。");
		}

		return sb.toString();
	}
}
