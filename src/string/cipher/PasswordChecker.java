package string.cipher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {

	// パスワードの最低文字数
	private static final int MIN_LENGTH = 8;

	public static void main(String[] args) {
		String[] passwords = {"ABCdef123", "ABCdef1", "ＡBCdef123", "abcdef123", "ABCDEF123", "ABCdefGHI"};

		for (String pw : passwords) {
			if (!checkLength(pw)) {
				System.out.println("「"+ pw + "」はパスワードの長さの要件を満たしていません。");
			}
			if (!checkOnlyAlNum(pw)) {
				System.out.println("「"+ pw + "」は半角英数字以外の文字が含まれています。");
			}
			if (!containsUpperCase(pw)) {
				System.out.println("「"+ pw + "」は大文字の英字が含まれていません。");
			}
			if (!containsLowerCase(pw)) {
				System.out.println("「"+ pw + "」は小文字の英字が含まれていません。");
			}
			if (!containsNum(pw)) {
				System.out.println("「"+ pw + "」は数字が含まれていません。");
			}
		}
	}

	/**
	 * パスワードの文字数が「最低文字数以上」であるか？
	 * @param text
	 * @return
	 */
	private static boolean checkLength(String text) {
		return (text.length() >= MIN_LENGTH);
	}

	/**
	 * パスワードが半角英数字のみで構成されているか？
	 * @param text
	 * @return
	 */
	private static boolean checkOnlyAlNum(String text) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher m = pattern.matcher(text);
        return m.find();
	}

	/**
	 * パスワードに大文字の英字が1文字以上含まれているか？
	 * @param text
	 * @return
	 */
	private static boolean containsUpperCase(String text) {
		Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher m = pattern.matcher(text);
        return m.find();
	}

	/**
	 * パスワードに小文字の英字が1文字以上含まれているか？
	 * @param text
	 * @return
	 */
	private static boolean containsLowerCase(String text) {
		Pattern pattern = Pattern.compile("[a-z]+");
        Matcher m = pattern.matcher(text);
        return m.find();
	}

	/**
	 * パスワードに半角数字が1文字以上含まれているか？
	 * @param text
	 * @return
	 */
	private static boolean containsNum(String text) {
		Pattern pattern = Pattern.compile("[0-9]+");
        Matcher m = pattern.matcher(text);
        return m.find();
	}
}
