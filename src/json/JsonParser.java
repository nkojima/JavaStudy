package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jacksonを使ったJSONの解析用クラス。
 * JARは以下のURLからダウンロード。
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
 * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations
 * @author NKOJIMA
 */
public class JsonParser {

	private static final String json =
			"{" +
				"\"stations\": " +
				"[" +
					"{\"name\": \"東京\", \"lat\": 35.681152, \"lon\": 139.767058}," +
					"{\"name\": \"名古屋\", \"lat\": 35.170634, \"lon\": 136.881752}," +
					"{\"name\": \"大阪\", \"lat\": 34.702155, \"lon\": 135.495082}" +
				"]" +
			"}";

	public static void main(String[] args) {

		/*
		 * 参考URL：https://style.potepan.com/articles/27407.html#JavaJSON-2
		 */

		var mapper = new ObjectMapper();

		try {
			JsonNode node = mapper.readTree(json);
			JsonNode stations = node.get("stations");

			System.out.println("----- 全ての駅名を出力 -----");
			stations.forEach(station -> System.out.println(station.get("name").asText()));

			System.out.println("----- 名古屋駅の情報だけを出力 -----");
			stations.forEach(station -> {
				if ((station.get("name")).asText().equals("名古屋")) {
					System.out.println("駅名：" + station.get("name").asText());
					System.out.println("緯度：" + station.get("lat").asDouble());
					System.out.println("経度：" + station.get("lon").asDouble());
				} else {
					return;	// continueの代わりにreturnを使う。
				}
			});

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
