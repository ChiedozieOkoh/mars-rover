package com.rover;

public class RoverOrientLeft implements Command{
	@Override
	public void execute(Rover rover){
		rover.orientLeft();
	}
}
