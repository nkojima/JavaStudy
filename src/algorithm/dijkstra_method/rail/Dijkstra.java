package algorithm.dijkstra_method.rail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Dijkstra {

	public static void main(String[] args) {

		// ネットワークデータを生成する。
		HashMap<Integer, Node> nodeMap = DijkstraService.stationsToNodes();
		HashMap<Integer, String> lineMap = DijkstraService.getLineMap();
		ArrayList<Link> links = DijkstraService.railsToLinks();

		// 発着駅コードを調べるためのMapを生成する。
		HashMap<String, Integer> stationMap = DijkstraService.getStationsMap();

		// 発着地を決める
		String fromName = "横浜";
		String toName = "高崎";
		int from = stationMap.get(fromName);
		int to = stationMap.get(toName);

		// 発地点までの距離を0とする。
		nodeMap.get(from).setShortestPath(null, 0);

		// 発地点を現在地点とする。
		int current = from;

		while(true) {
			// 現在のノードに隣接するノードまでのリンクを取得する。
			ArrayList<Link> neighbors = getNeighbors(links, current);

			// 現在のノードを取得する。
			Node currentNode = nodeMap.get(current);
			System.out.println("現在の通過中の駅：" + currentNode.getName());

			// 近隣ノードまでのコストを確定させる。
			for (Link neighbor : neighbors) {
				int cost = currentNode.getCost() + neighbor.getCost();

				// 現在の駅が発駅で無ければ、乗り換えが発生しているかを調べる。
				// 路線の乗り換えが発生する時は、乗換時間として5分を加算する。
				if (current!=from) {
					int previousLine = currentNode.getShortestPath().getLineCode();
					int lineCode = neighbor.getLineCode();
					if (previousLine!=lineCode) {
						cost +=5;
					}
				}

				Node toNode = nodeMap.get(neighbor.getTo());
				toNode.setShortestPath(neighbor, cost);
			}

			// 現在のノードを通過済みとする。
			currentNode.fixed();

			// 通過していない（確定していない）駅の中から、最近隣の駅を返す。
			// ここで取り出した駅が、次のループでの「現在のノード」となる。
			// また、最近隣の駅が見つからなければ処理を終了する。
			Node nearestNode = getNearestNode(nodeMap);
			if (nearestNode!=null) {
				current = nearestNode.getCode();
			} else {
				break;
			}
		}

		// 最短経路を取り出す。
		Node arrivalNode = nodeMap.get(to);
		System.out.println("目的地までの時間：" + arrivalNode.getCost() + "分");

		ArrayList<Link> shortestPaths = new ArrayList<Link>();
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
		int previousLineCode = -1;

		for (int i=0; i<shortestPaths.size(); i++) {
			Link path = shortestPaths.get(i);
			int lineCode = path.getLineCode();

//			System.out.print(nodeMap.get(path.getFrom()).getName());
//			System.out.print("-<" + lineMap.get(lineCode) + ">-");

			// 路線が変わらなければ、路線名と通過駅の表示をスキップする。
			if (previousLineCode!=lineCode) {
				System.out.print(nodeMap.get(path.getFrom()).getName());
				System.out.print("-<" + lineMap.get(lineCode) + ">-");
				previousLineCode = lineCode;
			}

			if (i==lastLinkIdx) {
				System.out.print(nodeMap.get(path.getTo()).getName());
			}
		}
	}


	/**
	 * 現在のノードに隣接しているノードへのリンクを取得する。
	 *
	 * @param links リンクのリスト
	 * @param current 現在のノードの番号
	 * @return 現在のノードに隣接しているノードへのリンクのリスト。
	 */
	static ArrayList<Link> getNeighbors(ArrayList<Link> links, int current) {

		ArrayList<Link> neighbors = new ArrayList<Link>();

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
