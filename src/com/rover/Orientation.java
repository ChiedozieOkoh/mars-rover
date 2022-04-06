package com.rover;



public enum Orientation {
	
	N("NORTH"),
	E("EAST"),
	S("SOUTH"),
	W("WEST");
	String name; 
	Orientation(String str) {
		this.name = str; 
	}

	@Override
	public String toString() {
		return name; 
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
}
