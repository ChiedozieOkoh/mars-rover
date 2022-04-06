package com.rover;



public class OrientationGenerator {

	public static final Orientation createOrientation(String enumAsString){
		Orientation type = Orientation.valueOf(enumAsString);
		return type;
	}
}
