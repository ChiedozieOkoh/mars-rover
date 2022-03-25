package com.rover;

public enum ORIENTATION{
	N("NORTH"),
	E("EAST"),
	S("SOUTH"),
	W("WEST");
	
	ORIENTATION(String str) {
	}

	public ORIENTATION orient(CMD move) {// change facing direction dependent on move command
		switch(move){
			case L: 
				return ORIENTATION.values()[Math.floorMod(this.ordinal() -1 , ORIENTATION.values().length)];
			case R: 
				return ORIENTATION.values()[(this.ordinal() + 1) % ORIENTATION.values().length];
			case M: 
				return this;
		}
		return this;
	}
}