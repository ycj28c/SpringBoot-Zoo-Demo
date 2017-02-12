package com.zoo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ZooDataBase {

	public static Long nextVal = 7L;

	private static List<Animal> AnimalsList = Arrays.asList(
			new Animal(1, "Grasshoppers"), 
			new Animal(2, "Tiger"), 
			new Animal(3, "Beetles"),
			new Animal(4, "Butterflies"), 
			new Animal(5, "Millipedes"),
			new Animal(6, "Scorpions"));

	private static Map<Long, Zoo> zoosMap = new LinkedHashMap<Long, Zoo>() {
		private static final long serialVersionUID = 1L;
		{
			put(1L, new Zoo("Atascadero Charles Paddock Zoo",
					"9305 Pismo Avenue, Atascadero, CA 93422",
					"charlespaddockzoo.org", new ArrayList<Animal>(AnimalsList))); // don't need deep clone in this case
			put(2L, new Zoo("Big Bear Alpine Zoo",
					"43285 Goldmine Drive, Big Bear Lake, California",
					"bigbearzoo.org", new ArrayList<Animal>(AnimalsList)));
			put(3L, new Zoo("Sequoia Park Zoo",
					"531 K Street, Eureka, CA 95501-1146",
					"sequoiaParkZoo.net", new ArrayList<Animal>(AnimalsList)));
			put(4L, new Zoo("Chaffee Zoo",
					"894 W Belmont Avenue, Fresno, CA 93728-2891",
					"chaffeezoo.org", new ArrayList<Animal>(AnimalsList)));
			put(5L, new Zoo("Los Angeles Zoo",
					"5333 Zoo Drive, Los Angeles, CA 90027-1498", "lazoo.org",
					new ArrayList<Animal>(AnimalsList)));
			put(6L, new Zoo("Palo Alto  Museum and Junior Zoo",
					"1451 Middlefield Road, Palo Alto, CA 94301",
					"cityofpaloalto.org", new ArrayList<Animal>(AnimalsList)));
		}
	};

	private ZooDataBase() { // not allow new class
	}

	public static Map<Long, Zoo> getZoosMap() {
		return zoosMap;
	}

}
