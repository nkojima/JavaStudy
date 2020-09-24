package algorithm.dijkstra_method.rail;

/**
 * ノードを表すクラス。
 * 駅・バス停・地点などに相当する。
 * @author NKOJIMA
 *
 */
class Node {

	/**
	 * 駅コード。
	 */
	private int code;

	/**
	 * 駅名。
	 */
	private String name;

	/**
	 * この駅までのコスト（距離・時間）。
	 */
	private int cost;

	/**
	 * この駅までの最短経路となるリンク。
	 * 探索終了後に、このリンクを辿って経路を組み立てる。
	 */
	private Link shortestPath;

	/**
	 * 通過済み（確定済み）であるかを表すフラグ。
	 */
	private boolean fixed;


	/**
	 * コンストラクタ。
	 * この駅までの距離は、初期値として無限大（Integer.MAX_VALUE）を設定しておく。
	 *
	 * @param code 駅コード。
	 * @param name 駅名。
	 */
	public Node(int code, String name) {
		this.code = code;
		this.name = name;
		this.cost = Integer.MAX_VALUE;
	}

	/**
	 * 最短経路をセットする。
	 * この駅までのコストを使って、この駅に接続しているリンクが最短経路であるかを判別している。
	 * @param link この駅が着地点となっているリンク。
	 * @param cost この駅までのコスト
	 */
	public void setShortestPath(Link link, int cost) {
		if (this.cost > cost) {
			this.cost = cost;
			this.shortestPath = link;
		}
	}

	/**
	 * 駅コードを返す。
	 * @return 駅コード。
	 */
	public int getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * この駅までのコストを取得する。
	 * @return この駅までのコスト
	 */
	public int getCost() {
		return this.cost;
	}

	/**
	 * この駅が通過済み（確定済み）であるか？
	 * @return 通過済みであればtrueを返す。
	 */
	public boolean isFixed() {
		return this.fixed;
	}

	/**
	 * この駅を通過済み（確定済み）とする。
	 */
	public void fixed() {
		this.fixed = true;
	}

	/**
	 * この駅までの最短経路となるリンクを返す。
	 * @return 最短経路となるリンク。
	 */
	public Link getShortestPath() {
		return this.shortestPath;
	}
}