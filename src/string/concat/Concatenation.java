package string.concat;

/**
 * 文字列結合の速度を比較するためのクラス。
 * @author NKOJIMA
 *
 */
public class Concatenation {

	public static void main(String[] args) {
		int count = 100000;

        plus(count);
        concat(count);
        builder(count);
        buffer(count);
	}

	/**
	 * "+"演算子による文字列結合。
	 * @param count 文字列を結合させる回数。
	 */
    public static void plus(int count) {

        long start = System.currentTimeMillis();
        String txt = "abc";

        for (int i=0; i<count; i++) {
            txt += "abc";
        }

        long end = System.currentTimeMillis();
        System.out.println("+:" + (end - start) + "ms");
    }

    /**
     * String.concat()による文字列結合。
	 * @param count 文字列を結合させる回数。
     */
    public static void concat(int count) {

        long start = System.currentTimeMillis();
        String txt = "abc";

        for (int i=0; i<count; i++) {
            txt = txt.concat("abc");
        }

        long end = System.currentTimeMillis();
        System.out.println("concat:" + (end - start) + "ms");
    }

    /**
     * StringBuilderによる文字列結合。
	 * @param count 文字列を結合させる回数。
     */
    public static void builder(int count) {

        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("abc");

        for (int i=0; i<count; i++) {
            sb.append("abc");
        }

        String txt = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder:" + (end - start) + "ms");
    }

    /**
     * StringBufferによる文字列結合。
	 * @param count 文字列を結合させる回数。
     */
    public static void buffer(int count) {

        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("abc");

        for (int i=0; i<count; i++) {
            sb.append("abc");
        }

        String txt = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer:" + (end - start) + "ms");
    }
}
