package algorithm.drawing_pattern;

/**
 * バツ印を描くクラス。
 * @author NKOJIMA
 *
 */
public class CrossMark {

	public static void main(String[] args) {
		printCrossMark(16);
	}

	/**
	 * バツ印を描画する。
	 * @param outputSize 描画サイズ（桁数）。
	 */
	public static void printCrossMark(int outputSize) {

	    // 行方向への移動
	    for (int i=0; i<outputSize; i++) {

	        // 列方向への移動
	        for (int j=0; j<outputSize; j++) {

	            if (i==j) {
	                // 左上から右下に伸びる線
	                System.out.print("*");
	            } else if (i+j==outputSize-1) {
	                // 左下から右上に伸びる線
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
