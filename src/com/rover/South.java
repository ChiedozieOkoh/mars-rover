package com.rover;

public class South extends Orientation {

	public South(){
		super(OrientationType.S);
	}
	@Override
	public void moveForward(Rover rover) {
		rover.y--;
	}

	@Override
	public boolean canMoveForward(Rover rover, Plateau plateau) {
		return rover.y > 0;
	}

}
