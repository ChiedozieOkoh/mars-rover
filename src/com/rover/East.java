package com.rover;

public class East extends Orientation {

	public East(){
		super(OrientationType.E);
	}
	@Override
	public void moveForward(Rover rover) {
		rover.x++;
	}

	@Override
	public boolean canMoveForward(Rover rover, Plateau plateau) {
		return rover.x < plateau.limitX;
	}

}
