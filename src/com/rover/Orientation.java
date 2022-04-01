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

	
	private Orientation orientLeft() {
		OrientationType newType =  OrientationType.values()[Math.floorMod(type.ordinal() -1 , OrientationType.values().length)];
		Orientation newOrientation = OrientationGenerator.createOrientation(newType);
		return newOrientation;
	}
	
	private Orientation orientRight(){
		OrientationType newType = OrientationType.values()[(type.ordinal() + 1) % OrientationType.values().length];
		Orientation newOrientation = OrientationGenerator.createOrientation(newType);
		return newOrientation;
	}
	
	public OrientationType getCurrentOrientation(){
		return type; 
	}
	
	private final void left(Rover rover){
		Orientation newOrientation = rover.orientation.orientLeft();
		rover.orientation = newOrientation;
	}
	
	private final void right(Rover rover){
		Orientation newOrientation = rover.orientation.orientRight();
		rover.orientation = newOrientation;
	}
	
	public final Rover executeMove(Plateau plateau,Move move,Rover rover){
		switch(move){
			case L: 
				left(rover);
				break;
			case R:
				right(rover);
				break;
			case M:
				if(canMoveForward(rover,plateau)){
					moveForward(rover);
				}
		}
		return rover;
	}
	
	protected abstract void moveForward(Rover rover);
	protected abstract boolean canMoveForward(Rover rover,Plateau plateau);
}
