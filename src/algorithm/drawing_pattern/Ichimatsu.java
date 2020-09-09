package algorithm.drawing_pattern;

/**
 * 市松模様を描くクラス。
 * @author NKOJIMA
 *
 */
public class Ichimatsu {

	public static void main(String[] args) {
		printIchimatsu(16);
	}

	/**
	 * 市松模様を描画する。
	 * @param outputSize 描画サイズ（桁数）。
	 */
	public static void printIchimatsu(int outputSize) {

	    // 行方向への移動
	    for (int i=0; i<outputSize; i++) {

	        // 列方向への移動
	        for (int j=0; j<outputSize; j++) {

	            int rowIndex = i%4;
	            int colIndex = j%4;

	            if (rowIndex<2 && colIndex<2) {
	                System.out.print("*");
	            } else if (rowIndex>=2 && colIndex>=2) {
	                System.out.print("*");
	            } else {
	                System.out.print(".");
	            }

	        }

	        // 改行を入れる
	        System.out.print(System.lineSeparator());

	    }

	}
}
