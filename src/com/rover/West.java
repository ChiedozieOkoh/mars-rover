package com.rover;

public class West extends Orientation {
	
	public West(){
		super(OrientationType.W);
	}
	@Override
	public void moveForward(Rover rover) {
		rover.x--;
	}

	@Override
	public boolean canMoveForward(Rover rover, Plateau plateau) {
		return rover.x > 0;
	}

}
