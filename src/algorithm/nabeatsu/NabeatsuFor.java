package algorithm.nabeatsu;

/**
 * 1から100までの整数を使って、「世界のナベアツ」のネタを実行する。
 * @author NKOJIMA
 *
 */
public class NabeatsuFor {

	public static void main(String[] args) {
		doNabeatsu(100);
	}

	static void doNabeatsu(int end) {
        for (int i=1; i<=end; i++) {
            if (i%3==0) {
                System.out.println("アホ");
            } else {
                System.out.println(i);
            }
        }
	}
}
