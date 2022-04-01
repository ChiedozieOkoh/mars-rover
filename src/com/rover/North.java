package com.rover;

public class North extends Orientation{
	public North(){
		super(OrientationType.N);
	}
	
	@Override
	public void moveForward(Rover rover) {
		rover.y++;
	}

	@Override
	public boolean canMoveForward(Rover rover, Plateau plateau) {
		return rover.y < plateau.limitY;
	}
}