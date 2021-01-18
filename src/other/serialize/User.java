package other.serialize;

import java.io.Serializable;

/**
 * シリアライズ可能なクラス。
 * 書き込みはObjectOutputStream、読み込みはObjectInputStreamを使う。
 * @author NKOJIMA
 *
 */
public class User implements Serializable {

	/**
	 * シリアライズした時に、そのクラスのソースコードの同一性を保証するハッシュ値のような役割を果たす値。
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID。
	 */
	private int id;

	/**
	 * 名前。
	 */
	private String name;

	/**
	 * 備考。
	 * transient修飾子が付いているため、シリアライズの対象外となる。
	 */
	private transient String memo;

	/**
	 * コンストラクタ。
	 * @param id ID。
	 * @param name 名前。
	 * @param memo 備考。
	 */
	public User(int id, String name, String memo) {
		this.id = id;
		this.name = name;
		this.memo = memo;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMemo() {
		return memo;
	}


}
