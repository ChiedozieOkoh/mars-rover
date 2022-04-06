package com.rover;

public interface Command {
	void execute(Rover rover,Vector vector ,Plateau plateau);
	
	public static class TurnLeft implements Command{
		@Override
		public void execute(Rover rover,Vector vector, Plateau plateau){
			Orientation newOrientation = rover.orientation.orientLeft();
			rover.orientation = newOrientation;
		}
	}
	
	public static class TurnRight implements Command{
		@Override
		public void execute(Rover rover,Vector vector, Plateau plateau){
			Orientation newOrientation = rover.orientation.orientRight();
			rover.orientation = newOrientation;
		}
	}
	
	public static class MoveForward implements Command{
		@Override
		public void execute(Rover rover,Vector vector, Plateau plateau){
			rover.getPosition().applyVector(vector,rover.orientation, plateau);
		}
	}
}
