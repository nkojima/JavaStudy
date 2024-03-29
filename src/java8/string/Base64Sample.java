package java8.string;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Sample {

	public static void main(String[] args) {

		String txt = "nkojimaです";
		System.out.println("オリジナルの文字列：" + txt);

		// エンコード
		Base64.Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString(txt.getBytes(StandardCharsets.UTF_8));
		System.out.println("エンコードした文字列：" + encoded);

		// デコード
		Base64.Decoder decoder = Base64.getDecoder();
		String decoded = new String(decoder.decode(encoded.getBytes(StandardCharsets.UTF_8)));
		System.out.println("デコードした文字列：" + decoded);
	}

}