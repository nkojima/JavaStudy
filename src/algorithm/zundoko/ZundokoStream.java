package algorithm.zundoko;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZundokoStream {

	/**
	 * 「きよしのズンドコ節」の歌詞の一節を表示する。
	 * @param args
	 */
	public static void main(String[] args) {
        Random rnd = new Random();
        String[] zunDoko = { "ズン", "ドコ" };
        String songLyrics = "";

        do {
            List<String> phrases =
                    Stream.generate(() -> zunDoko[rnd.nextInt(2)])
                    .limit(5)
                    .collect(Collectors.toList());

            songLyrics = String.join(" ", phrases);
        } while (!songLyrics.equals("ズン ズン ズン ズン ドコ"));

        System.out.print(songLyrics);
        System.out.println(" キヨシ！！");
	}

}
