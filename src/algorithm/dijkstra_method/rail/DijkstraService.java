package algorithm.dijkstra_method.rail;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 経路探索に必要なデータを生成するためのクラス。
 * @author NKOJIMA
 *
 */
class DijkstraService {

	/**
	 * 駅一覧
	 * {駅コード,駅名}
	 */
	private static final String[] STATIONS = {
		"22828:東京", "22528:上野", "22513:池袋", "22741:新宿", "22715:渋谷", "22559:大崎", "22709:品川", "22751:新橋",
		"22582:御茶ノ水", "23041:四ツ谷", "22849:中野(東京都)", "22986:三鷹", "22799:立川", "22905:八王子", "22787:高尾",
		"23126:川崎", "23368:横浜", "23096:大船",
		"22487:赤羽", "21987:大宮",
		"21913:高崎", "22029:熊谷",
		"23345:武蔵小杉"
	};

	/**
	 * 路線一覧。
	 * {路線コード,路線名}
	 */
	private static final String[] LINES = {
		"1:山手線", "2:中央線快速", "3:東海道本線", "4:埼京線", "5:高崎線", "6:湘南新宿ライン快速"
	};

	/**
	 * 路線ごとの駅間データ。
	 *
	 */
	private static final String[] RAILS = {
		// 山手線
		"1:22828:22528:8",	// 東京-上野
		"1:22528:22513:17",	// 上野-池袋
		"1:22513:22741:9",	// 池袋-新宿
		"1:22741:22715:7",	// 新宿-渋谷
		"1:22715:22559:9",	// 渋谷-大崎
		"1:22559:22709:3",	// 大崎-品川
		"1:22709:22751:7",	// 品川-新橋
		"1:22751:22828:3",	// 新橋-東京
		// 中央線快速
		"2:22828:22582:5",	// 東京-御茶ノ水
		"2:22582:23041:6",	// 御茶ノ水-四ツ谷
		"2:23041:22741:5",	// 四ツ谷-新宿
		"2:22741:22849:4",	// 新宿-中野(東京都)
		"2:22849:22986:9",	// 中野(東京都)-三鷹
		"2:22986:22799:18",	// 三鷹-立川
		"2:22799:22905:11",	// 立川-八王子
		"2:22905:22787:7",	// 八王子-高尾
		// 東海道本線
		"3:22828:22751:3",	// 東京-新橋
		"3:22751:22709:5",	// 新橋-品川
		"3:22709:23126:9",	// 品川-川崎
		"3:23126:23368:8",	// 川崎-横浜
		"3:23368:23096:8",	// 横浜-大船
		// 埼京線
		"4:21987:22487:18",	// 大宮-赤羽
		"4:22487:22513:8",	// 赤羽-池袋
		"4:22513:22741:6",	// 池袋-新宿
		"4:22741:22715:5",	// 新宿-渋谷
		"4:22715:22559:6",	// 渋谷-大崎
		// 高崎線
		"5:21913:22029:47",	// 高崎-熊谷
		"5:22029:21987:46",	// 熊谷-大宮
		"5:21987:22487:16",	// 大宮-赤羽
		"5:22487:22528:11",	// 赤羽-上野
		"5:22528:22828:8",	// 上野-東京
		// 湘南新宿ライン快速
		"6:21913:22029:42",	// 高崎-熊谷
		"6:22029:21987:32",	// 熊谷-大宮
		"6:21987:22487:16",	// 大宮-赤羽
		"6:22487:22513:11",	// 赤羽-池袋
		"6:22513:22741:6",	// 池袋-新宿
		"6:22741:22715:5",	// 新宿-渋谷
		"6:22715:22559:6",	// 渋谷-大崎
		"6:22559:23345:8",	// 大崎-武蔵小杉
		"6:23345:23368:10",	// 武蔵小杉-横浜
		"6:23368:23096:8"	// 横浜-大船
	};

	/**
	 * キーが駅名、値が駅コードのMapを返す。
	 * 経路探索路に指定した駅名から、駅コードを探すために使われる。
	 * @return キーが駅名、値が駅コードのMap。
	 */
	public static HashMap<String, Integer> getStationsMap() {
		HashMap<String, Integer> stationMap = new HashMap<String, Integer>(STATIONS.length);

		for (String txt : STATIONS) {
			String[] spliter = txt.split(":");
			stationMap.put(spliter[1], Integer.parseInt(spliter[0]));
		}

        return stationMap;
	}

    /**
     * 駅一覧からノードのMapを作る。
     */
    public static HashMap<Integer, Node> stationsToNodes() {

        HashMap<Integer, Node> nodeMap = new HashMap<Integer, Node>(STATIONS.length);

        for (String txt : STATIONS) {
        	String[] spliter = txt.split(":");
        	int code = Integer.parseInt(spliter[0]);
            Node point = new Node(code, spliter[1]);
            nodeMap.put(code, point);
        }

        return nodeMap;
    }

    /**
     * 路線一覧から、路線のMapを返す。
     */
    public static HashMap<Integer, String> getLineMap() {

        HashMap<Integer, String> lineMap = new HashMap<Integer, String>(LINES.length);

        for (String txt : LINES) {
        	String[] spliter = txt.split(":");
        	int code = Integer.parseInt(spliter[0]);
            lineMap.put(code, spliter[1]);
        }

        return lineMap;
    }


	/**
	 * 路線ごとの駅間データからリンクのリストを作る。
	 * @return リンクのリスト。
	 */
	public static ArrayList<Link> railsToLinks() {

		ArrayList<Link> links = new ArrayList<Link>(RAILS.length);

		for (String rail : RAILS) {
			String[] texts = rail.split(":");
			Link link = new Link(Integer.parseInt(texts[0]), Integer.parseInt(texts[1]),
					Integer.parseInt(texts[2]), Integer.parseInt(texts[3]));
			links.add(link);

			// 逆向きのリンクも作る。
			Link reverselink = new Link(Integer.parseInt(texts[0]), Integer.parseInt(texts[2]),
					Integer.parseInt(texts[1]), Integer.parseInt(texts[3]));
			links.add(reverselink);
		}

		return links;
	}
}
