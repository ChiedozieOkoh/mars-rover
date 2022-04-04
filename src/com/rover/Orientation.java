package com.rover;



public abstract class Orientation {
	public enum OrientationType{
		N("NORTH"),
		E("EAST"),
		S("SOUTH"),
		W("WEST");
		String oriName; 
		OrientationType(String str) {
			this.oriName = str; 
		}

		@Override
		public String toString() {
			return oriName; 
		}
	
	}
	
	private OrientationType type; 
	
	public Orientation(OrientationType orientationType){
		type = orientationType;
	}

	
	public Orientation orientLeft() {
		OrientationType newType =  OrientationType.values()[Math.floorMod(type.ordinal() -1 , OrientationType.values().length)];
		Orientation newOrientation = OrientationGenerator.createOrientation(newType);
		return newOrientation;
	}
	
	public Orientation orientRight(){
		OrientationType newType = OrientationType.values()[(type.ordinal() + 1) % OrientationType.values().length];
		Orientation newOrientation = OrientationGenerator.createOrientation(newType);
		return newOrientation;
	}
	
	public OrientationType getCurrentOrientation(){
		return type; 
	}

}
