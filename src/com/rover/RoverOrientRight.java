package com.rover;

public class RoverOrientRight implements Command{

	@Override
	public void execute(Rover rover) {
		rover.orientRight();
	}
	
}
