package algorithm.dijkstra_method.basic;

/**
 * ノードを表すクラス。
 * 駅・バス停・地点などに相当する。
 * @author NKOJIMA
 *
 */
class Node {

	/**
	 * ノード番号
	 */
	private int code;

	/**
	 * このノードまでのコスト（距離・時間）。
	 */
	private int cost;

	/**
	 * このノードまでの最短経路となるリンク。
	 * 探索終了後に、このリンクを辿って経路を組み立てる。
	 */
	private Link shortestPath;

	/**
	 * 通過済み（確定済み）であるかを表すフラグ。
	 */
	private boolean fixed;


	/**
	 * コンストラクタ。
	 * このノードまでの距離は、初期値として無限大（Integer.MAX_VALUE）を設定しておく。
	 *
	 * @param code ノード番号
	 */
	public Node(int code) {
		this.code = code;
		this.cost = Integer.MAX_VALUE;
	}

	/**
	 * 最短経路をセットする。
	 * このノードまでのコストを使って、このノードに接続しているリンクが最短経路であるかを判別している。
	 * @param link このノードが着地点となっているリンク。
	 * @param cost このノードまでのコスト
	 */
	public void setShortestPath(Link link, int cost) {
		// 始点からこのノードまでのコストが最小である場合に限り、最短経路とコストを再設定する。
		if (this.cost > cost) {
			this.cost = cost;
			this.shortestPath = link;
		}
	}

	/**
	 * ノードのコード番号を返す。
	 * @return ノードのコード番号。
	 */
	public int getCode() {
		return this.code;
	}

	/**
	 * このノードまでのコストを取得する。
	 * @return このノードまでのコスト
	 */
	public int getCost() {
		return this.cost;
	}

	/**
	 * このノードが通過済み（確定済み）であるか？
	 * @return 通過済みであればtrueを返す。
	 */
	public boolean isFixed() {
		return this.fixed;
	}

	/**
	 * このノードを通過済み（確定済み）とする。
	 */
	public void fixed() {
		this.fixed = true;
	}

	/**
	 * このノードまでの最短経路となるリンクを返す。
	 * @return 最短経路となるリンク。
	 */
	public Link getShortestPath() {
		return this.shortestPath;
	}
}
