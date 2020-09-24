package algorithm.dijkstra_method.rail;

/**
 * リンクデータを表すクラス。
 * @author NKOJIMA
 *
 */
class Link {

	/**
	 * 路線コード
	 */
	private int lineCode;

	/**
	 * 発駅のコード
	 */
	private int from;

	/**
	 * 着駅のコード
	 */
	private int to;

	/**
	 * 発着駅間のコスト（距離・時間）
	 */
	private int cost;

	/**
	 * コンストラクタ
	 * @param lineCode 路線コード
	 * @param from 発駅コード
	 * @param to 着駅コード
	 * @param distance 発着駅間の距離
	 */
	public Link(int lineCode, int from, int to, int cost) {
		this.lineCode = lineCode;
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	/**
	 * 隣接している駅へ伸びるリンクであるかを判定する。
	 * （この駅から伸びているリンクであるかを判定している。）
	 * @param code 現在の駅コード
	 * @return 隣接している駅へ伸びるリンクであればtrueを返す。
	 */
	public boolean isNeighbor(int code) {
		return (from==code);
	}

	public int getLineCode() {
		return this.lineCode;
	}

	/**
	 * 発着駅間のコストを取得する。
	 * @return 発着駅間のコスト。
	 */
	public int getCost() {
		return this.cost;
	}

	/**
	 * 発駅コードを返す。
	 * @return 発駅コード。
	 */
	public int getFrom() {
		return this.from;
	}

	/**
	 * 着駅コードを返す。
	 * @return 着駅コード。
	 */
	public int getTo() {
		return this.to;
	}
}
