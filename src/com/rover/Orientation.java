package com.rover;
public class Orientation{
	
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
	
	public void OrientLeft() {
		type =  OrientationType.values()[Math.floorMod(type.ordinal() -1 , OrientationType.values().length)];
	}
	
	public void OrientRight(){
		type = OrientationType.values()[(type.ordinal() + 1) % OrientationType.values().length];
	}
	
	public OrientationType getCurrentOrientation(){
		return type; 
	}
	
}