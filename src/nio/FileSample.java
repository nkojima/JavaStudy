package nio;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * ファイルやディレクトリ名の保持に関するサンプルコード。
 * ※JDK1.6まではFileクラス、JDK1.7以降はPathインターフェースを使う。
 * @author NKOJIMA
 *
 */
public class FileSample {

	public static void main(String[] args) {
		createFile();
		createPath();
		fileToPath();
		pathToFile();
	}

	/**
	 * Fileオブジェクトの作成
	 */
	static void createFile() {
		System.out.println("Fileオブジェクトの作成");

		File f = new File("C:\\java\\abc.txt");
		System.out.println(f.toString() + "は存在しますか？：" + f.exists());
	}

	/**
	 * Pathオブジェクトの作成
	 */
	static void createPath() {
		System.out.println("Pathオブジェクトの作成");

		FileSystem fs = FileSystems.getDefault();
		Path p = fs.getPath("C:\\java\\abc.txt");
		System.out.println(p.toString() + "は存在しますか？：" + Files.exists(p));
	}

	/**
	 * FileオブジェクトをPathオブジェクトに変換する。
	 */
	static void fileToPath() {
		System.out.println("File->Pathに変換");

		File f = new File("C:\\java\\abc.txt");
		Path p = f.toPath();
		System.out.println(p.toString());
	}

	/**
	 * PathオブジェクトをFileオブジェクトに変換する。
	 */
	static void pathToFile() {
		System.out.println("Path->Fileに変換");

		FileSystem fs = FileSystems.getDefault();
		Path p = fs.getPath("C:\\java\\abc.txt");
		File f = p.toFile();
		System.out.println(f.toString());
	}
}