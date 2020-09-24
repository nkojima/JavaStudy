package algorithm.dijkstra_method.basic;

/**
 * リンクを表すクラス。
 * @author NKOJIMA
 *
 */
class Link {

	/**
	 * 発ノードのコード
	 */
	private int from;

	/**
	 * 着ノードのコード
	 */
	private int to;

	/**
	 * 発着ノード間のコスト（距離・時間）
	 */
	private int cost;

	/**
	 * コンストラクタ
	 * @param from 発ノードのコード
	 * @param to 着ノードのコード
	 * @param distance 発着ノード間の距離
	 */
	public Link(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	/**
	 * 隣接しているノードへ伸びるリンクであるかを判定する。
	 * （このノードから伸びているリンクであるかを判定している。）
	 * @param code 現在のノードのコード番号
	 * @return 隣接しているノードへ伸びるリンクであればtrueを返す。
	 */
	public boolean isNeighbor(int code) {
		return (from==code);
	}

	/**
	 * 発着ノード間のコストを取得する。
	 * @return 発着ノード間のコスト。
	 */
	public int getCost() {
		return this.cost;
	}

	/**
	 * 発ノードのコード番号を返す。
	 * @return 発ノードのコード番号。
	 */
	public int getFrom() {
		return this.from;
	}

	/**
	 * 着ノードのコード番号を返す。
	 * @return 着ノードのコード番号。
	 */
	public int getTo() {
		return this.to;
	}
}