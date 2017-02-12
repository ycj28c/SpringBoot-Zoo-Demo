package com.zoo.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ZooDataBase {

	public static Long nextVal = 7L;
	
	private static Map<Long, Zoo> zoosMap = new LinkedHashMap<Long, Zoo>() {
		private static final long serialVersionUID = 1L;
		{
			put(1L, new Zoo(1L, "Oakland Zoo"));
			put(2L, new Zoo(2L, "San Francisco Zoo"));
			put(3L, new Zoo(3L, "Atascadero Charles Paddock Zoo "));
			put(4L, new Zoo(4L, "Big Bear Alpine Zoo"));
			put(5L, new Zoo(5L, "Orange County Zoo"));
			put(6L, new Zoo(6L, "San Jose Happy Hollow Zoo "));
		}
	};

	private ZooDataBase() { // not allow new class
 	}

	public static Map<Long, Zoo> getZoosMap() {
		return zoosMap;
	}

}
