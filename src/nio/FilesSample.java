package nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Filesクラスを使ったテキストファイルの読み書き。
 * ※JDK1.7ベースの書き方。
 * @author NKOJIMA
 *
 */
public class FilesSample {

	/**
	 * サンプルファイルのパス。
	 */
	public static final String SAMPLE_FILE_PATH = "C:\\Users\\NKOJIMA\\Desktop\\test.txt";

	public static void main(String[] args) {

		FileSystem fs = FileSystems.getDefault();
		Path srcPath = fs.getPath(SAMPLE_FILE_PATH);

		/*
		 * テキストファイルの書き込み。
		 */
		try (BufferedWriter bw = Files.newBufferedWriter(srcPath, Charset.forName("MS932"))) {
			bw.write("ABC");
			bw.newLine();
			bw.write("123");
			bw.newLine();
			bw.write("あいう");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("ファイルの書き込みが終了...");

		/*
		 * テキストファイルの読み込み。
		 */
		try (BufferedReader br = Files.newBufferedReader(srcPath, Charset.forName("MS932"))) {
			String line = null;

			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("ファイルの読み込みが終了...");
	}
}
