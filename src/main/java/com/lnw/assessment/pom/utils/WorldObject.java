package com.lnw.assessment.pom.utils;

import java.util.HashMap;
import java.util.Map;

public class WorldObject {
	
	/*
	 * This class is created for saving or getting saved data, since this is declared static , if we save the value 
	 * in the map by calling put method with with unique key same we can retrieve passing the same key whatever we save it  
	 * 
	 */

	public static Map<String, String> world = new HashMap<>();
	
}
