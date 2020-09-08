package string.concat;

/**
 * 文字列結合の速度を比較するためのクラス。
 * @author NKOJIMA
 *
 */
public class Concatenation {

	public static void main(String[] args) {
        plus();
        concat();
        builder();
        buffer();
	}

    public static void plus() {

        long start = System.currentTimeMillis();
        String txt = "abc";

        for (int i=0; i<100000; i++) {
            txt += "abc";
        }

        long end = System.currentTimeMillis();
        System.out.println("+:" + (end - start) + "ms");
    }

    public static void concat() {

        long start = System.currentTimeMillis();
        String txt = "abc";

        for (int i=0; i<100000; i++) {
            txt = txt.concat("abc");
        }

        long end = System.currentTimeMillis();
        System.out.println("concat:" + (end - start) + "ms");
    }

    public static void builder() {

        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("abc");

        for (int i=0; i<100000; i++) {
            sb.append("abc");
        }

        String txt = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder:" + (end - start) + "ms");
    }

    public static void buffer() {

        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("abc");

        for (int i=0; i<100000; i++) {
            sb.append("abc");
        }

        String txt = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer:" + (end - start) + "ms");
    }
}
