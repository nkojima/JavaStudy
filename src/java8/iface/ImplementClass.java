package java8.iface;

/**
 * インターフェース「InterfaceWithStaticMethod」を実装したクラス。
 * @author NKOJIMA
 *
 */
public class ImplementClass implements InterfaceWithStaticMethod {

	/**
	 * 言語名を返す。
	 * @return
	 */
	public String getLanguage() {
		return "Java";
	}
}
