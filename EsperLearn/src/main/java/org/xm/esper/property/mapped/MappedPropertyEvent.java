package org.xm.esper.property.mapped;

import java.util.HashMap;
import java.util.Map;

public class MappedPropertyEvent {

	private static final Map<String, String> mappedKv = new HashMap<String, String>();

	public String getValue(String key) {
		return mappedKv.get(key);
	}

	public Map<String, String> getKv() {
		return mappedKv;
	}

	static {

		mappedKv.put("name", "XM");
		mappedKv.put("age", "25");
		mappedKv.put("sex", "M");

	}

}
