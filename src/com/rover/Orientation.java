package com.rover;

public enum Orientation {
	
	N("NORTH",	new Vector(0,1)),
	E("EAST", 	new Vector(1,0)),
	S("SOUTH",	new Vector(0,-1)),
	W("WEST", 	new Vector(-1,0));
	private final String name; 
	private final Vector forwardVector;  
	
	Orientation(String str,Vector v) {
		this.name = str; 
		forwardVector = new Vector(v.deltaX,v.deltaY);
	}

	@Override
	public String toString() {
		return name; 
	}
	
	public Orientation orient(Move move){
		return  Orientation.values()[Math.floorMod(this.ordinal() + move.getRotation(), Orientation.values().length)];
	}
	
	public Vector forwardVector(){
		return forwardVector;
	}
}
