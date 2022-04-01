package com.rover;

import com.rover.Orientation.OrientationType;

public class OrientationGenerator {
	public static final Orientation createOrientation(OrientationType type){
		switch(type){
		case N:
			return new North();
		case E:
			return new East();
		case S:
			return new South();
		case W:
			return new West();
		default:
			return null;
		}
		
	}
	public static final Orientation createOrientation(String enumAsString){
		OrientationType type = OrientationType.valueOf(enumAsString);
		return createOrientation(type);
	}
}
