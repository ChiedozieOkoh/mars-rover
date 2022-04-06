package com.rover;



public enum Orientation {
	
	N("NORTH"),
	E("EAST"),
	S("SOUTH"),
	W("WEST");
	String oriName; 
	Orientation(String str) {
		this.oriName = str; 
	}

	@Override
	public String toString() {
		return oriName; 
	}
	
	public Orientation orientLeft() {
		return  Orientation.values()[Math.floorMod(this.ordinal() -1 , Orientation.values().length)];
		
	}
	
	public Orientation orientRight(){
		return Orientation.values()[(this.ordinal() + 1) % Orientation.values().length];
		
	}

	public Vector forwardVector(){
		switch(this){
			case N: 
				return new Vector(0,1);
			case E:
				return new Vector(1,0);
			case S:
				return new Vector(0,-1);
			case W:
				return new Vector(-1,0);
			default: 
				return null;
		}
	}
	
	public Orientation getCurrentOrientation(){
		return this;
	}

}
