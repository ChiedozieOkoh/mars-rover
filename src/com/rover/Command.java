package com.rover;

public interface Command {
	void execute(Rover rover, Plateau plateau);
	
	public static class TurnLeft implements Command{
		@Override
		public void execute(Rover rover, Plateau plateau){
			Orientation newOrientation = rover.orientation.orientLeft();
			rover.orientation = newOrientation;
		}
	}
	
	public static class TurnRight implements Command{
		@Override
		public void execute(Rover rover, Plateau plateau){
			Orientation newOrientation = rover.orientation.orientRight();
			rover.orientation = newOrientation;
		}
	}
	
	public static class MoveForwardWhenNorth implements Command{
		@Override
		public void execute(Rover rover, Plateau plateau) {
			if(rover.y < plateau.limitY){
				rover.y++;
			}
		}
	}
	
	public static class MoveForwardWhenEast implements Command{
		@Override
		public void execute(Rover rover,Plateau plateau){
			if(rover.x < plateau.limitX){
				rover.x++;
			}
		}
	}
	
	public static class MoveForwardWhenSouth implements Command{
		public void execute(Rover rover,Plateau plateau){
			if(rover.y > 0){
				rover.y--;
			}
		}
	}
	
	public static class MoveForwardWhenWest implements Command{
		public void execute(Rover rover,Plateau plateau){
			if(rover.x > 0){
				rover.x--;
			}
		}
	}
	
}
