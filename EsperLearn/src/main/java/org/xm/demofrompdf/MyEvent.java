package org.xm.demofrompdf;

import java.util.Map;

public class MyEvent {

	String myMapKey;
	int myIndexValue;
	int myInnerIndexValue;
	Map<String, InnerType> innerTypesMap; // mapped property
	InnerType[] innerTypesArray;

	public String getMyMapKey() {
		return myMapKey;
	}

	public int getMyIndexValue() {
		return myIndexValue;
	}

	public int getMyInnerIndexValue() {
		return myInnerIndexValue;
	}

	public Map<String, InnerType> getInnerTypesMap() {
		return innerTypesMap;
	}

	public InnerType[] getInnerTypesArray() {
		return innerTypesArray;
	}

	public static class InnerType {
		String name;
		int[] ids;

	}

}
