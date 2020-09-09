package algorithm.zundoko;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZundokoStream {

	/**
	 * Stream APIを使って、「きよしのズンドコ節」の歌詞の一節を表示する。
	 * @param args
	 */
	public static void main(String[] args) {
        Random rnd = new Random();
        String[] zunDoko = { "ズン", "ドコ" };
        String songLyrics = "";

        do {
        	/*
        	 * 「ズン」もしくは「ドコ」のいずれかを格納した長さ5のListを作ります。
        	 * Stream.generate()を使う場合、Streamが無限に続かないようにlimitを付けるのがポイントです。
        	 *
        	 * Listを半角スペースでJoinした結果が「ズン ズン ズン ズン ドコ」になるまで、do～whileのループを繰り返します。
        	 * 必ず1回はループに入るので、最初に終了条件を判定するwhileではなく、最後に終了条件を判定するdo～whileを使いました。
        	 */
            List<String> phrases =
                    Stream.generate(() -> zunDoko[rnd.nextInt(2)])
                    .limit(5)
                    .collect(Collectors.toList());

            songLyrics = String.join(" ", phrases);
        } while (!songLyrics.equals("ズン ズン ズン ズン ドコ"));

        // 最後に「キヨシ！！」を付け足して標準出力します。
        System.out.print(songLyrics);
        System.out.println(" キヨシ！！");
	}

}
