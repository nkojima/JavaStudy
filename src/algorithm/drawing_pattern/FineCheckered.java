package algorithm.drawing_pattern;

/**
 * 市松模様を描くクラス。
 * @author NKOJIMA
 *
 */
public class FineCheckered {

	public static void main(String[] args) {
		printFineCheckered(16);
	}

	/**
	 * 細かな市松模様（チェック）を描画する。
	 * @param outputSize 描画サイズ（桁数）。
	 */
	public static void printFineCheckered(int outputSize) {

	    // 行方向への移動
	    for (int i=0; i<outputSize; i++) {

	        // 列方向への移動
	        for (int j=0; j<outputSize; j++) {

	            if ((i+j)%2==0) {
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
