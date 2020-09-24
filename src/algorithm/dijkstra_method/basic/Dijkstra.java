package algorithm.dijkstra_method.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * ダイクストラ法による経路探索。
 * @author NKOJIMA
 *
 */
class Dijkstra {

	/**
	 * Wikipediaの「ダイクストラ法」のページの図から起こしたネットワークデータ。
	 * 内側の配列は{発ノード番号,着ノード番号,発着ノード間の距離}を表している。
	 *
	 * https://ja.wikipedia.org/wiki/%E3%83%80%E3%82%A4%E3%82%AF%E3%82%B9%E3%83%88%E3%83%A9%E6%B3%95
	 */
	private static final int[][] GRAPH = {
		{1,2,7},{1,3,9},{1,6,14},			// 1番のノードから出ているリンク
		{2,1,7},{2,3,10},{2,4,15},			// 2番のノードから出ているリンク
		{3,1,9},{3,2,10},{3,4,11},{3,6,2},	// 3番のノードから出ているリンク
		{4,2,15},{4,3,11},{4,5,6},			// 4番のノードから出ているリンク
		{5,4,6},{5,6,9},					// 5番のノードから出ているリンク
		{6,1,14},{6,3,2},{6,5,9}			// 6番のノードから出ているリンク
	};

	/**
	 * 地点の番号リスト
	 */
	private static final int[] POINTS = {1,2,3,4,5,6};


	/**
	 * メイン処理
	 * @param args
	 */
	public static void main(String[] args) {

		// 発着地を決める
		int from = 6;
		int to = 4;

		List<Link> links = graphToLink();
		HashMap<Integer, Node> nodeMap = pointToNode();

		// 発地点までの距離を0とする。
		nodeMap.get(from).setShortestPath(null, 0);

		// 発地点を現在地点とする。
		int current = from;

		while(true) {
			// 現在のノードに隣接するノードまでのリンクを取得する。
			List<Link> neighbors = getNeighbors(links, current);

			// 現在のノードを取得する。
			Node currentNode = nodeMap.get(current);
			System.out.println("現在の通過中のノード：" + currentNode.getCode());

			// 近隣ノードまでのコストを確定させる。
			for (Link neighbor : neighbors) {
				int cost = currentNode.getCost() + neighbor.getCost();

				Node toNode = nodeMap.get(neighbor.getTo());
				toNode.setShortestPath(neighbor, cost);
			}

			// 現在のノードを通過済みとする。
			currentNode.fixed();

			// 通過していない（確定していない）ノードの中から、最近隣のノードを返す。
			// ここで取り出したノードが、次のループでの「現在のノード」となる。
			// また、最近隣のノードが見つからなければ処理を終了する。
			Node nearestNode = getNearestNode(nodeMap);
			if (nearestNode!=null) {
				current = nearestNode.getCode();
			} else {
				break;
			}
		}

		// 最短経路を取り出す。
		Node arrivalNode = nodeMap.get(to);
		System.out.println("目的地までのコスト：" + arrivalNode.getCost());

		List<Link> shortestPaths = new ArrayList<Link>();
		while(true) {
			Link shortestPath = arrivalNode.getShortestPath();
			if (shortestPath!=null) {
				shortestPaths.add(shortestPath);
				arrivalNode = nodeMap.get(shortestPath.getFrom());
			} else {
				// ［最短経路がこれ以上辿れない＝出発地まで到達］と見なして、最短経路の取り出しを終える。
				break;
			}
		}

		// 最短経路を表示する。
		Collections.reverse(shortestPaths);	// 出力用に逆順にする。

		int lastLinkIdx = shortestPaths.size() - 1;

		for (int i=0; i<shortestPaths.size(); i++) {
			System.out.print(shortestPaths.get(i).getFrom());
			System.out.print("→");

			if (i==lastLinkIdx) {
				System.out.print(shortestPaths.get(i).getTo());
			}
		}
	}


	/**
	 * ネットワークデータからリンクのリストを作る。
	 * @return リンクのリスト。
	 */
	static List<Link> graphToLink() {

		List<Link> links = new ArrayList<Link>(GRAPH.length);

		for (int[] g : GRAPH) {
			Link link = new Link(g[0],g[1],g[2]);
			links.add(link);
		}

		return links;
	}

	/**
	 * 地点データからノードのマップを作る。
	 * @return ノードのマップ。
	 */
	static HashMap<Integer, Node> pointToNode() {

		HashMap<Integer, Node> nodeMap = new HashMap<Integer, Node>(POINTS.length);

		for (int p : POINTS) {
			Node node = new Node(p);
			nodeMap.put(p, node);
		}

		return nodeMap;
	}

	/**
	 * 現在のノードに隣接しているノードへのリンクを取得する。
	 *
	 * @param links リンクのリスト
	 * @param current 現在のノードの番号
	 * @return 現在のノードに隣接しているノードへのリンクのリスト。
	 */
	static List<Link> getNeighbors(List<Link> links, int current) {

		List<Link> neighbors = new ArrayList<Link>();

		for (Link link : links) {
			if (link.isNeighbor(current)) {
				neighbors.add(link);
			}
		}

		return neighbors;
	}

	/**
	 * 通過していない（確定していない）駅の中から、最近隣の駅を返す。
	 * @param nodeMap 全駅のMap。
	 * @return 最近隣の駅。
	 */
	static Node getNearestNode(HashMap<Integer, Node> nodeMap) {
		int minCost = Integer.MAX_VALUE;
		Node nearestNode = null;

		for (Node node : nodeMap.values()) {
			if (!node.isFixed() && node.getCost() < minCost) {
				nearestNode = node;
				minCost = node.getCost();
			}
		}

		return nearestNode;
	}
}
