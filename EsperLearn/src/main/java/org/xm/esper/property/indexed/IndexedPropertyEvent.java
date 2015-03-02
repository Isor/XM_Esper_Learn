package org.xm.esper.property.indexed;

/**
 *  基于索引的 Esper Event 对象, 这里没有去实现 Itearable 接口,有兴趣的朋友可以尝试下.
 *
 * @author XM - 2015年2月26日
 *
 */

public class IndexedPropertyEvent {

	private static String[] names = { "XM", "TK", "FW", "LQ" };

	// a method for indexed
	public String getName(int index) {
		if (index == -1 || index > names.length) {
			return null;
		}
		return names[index];
	}

	// object-array
	public String[] getNames() {

		return names;
	}

}
