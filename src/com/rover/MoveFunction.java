package com.rover;

public interface MoveFunction {
	void execute(Rover rover, Plateau plateau);
	
	public static class MoveRight implements MoveFunction{
		public MoveRight(){
			
		}
		
		@Override
		public void execute(Rover rover, Plateau plateau) {
			rover.orientation.OrientRight();
		}
	}
	
	public static class MoveLeft implements MoveFunction{
		public MoveLeft(){
			
		}
		
		@Override 
		public void execute(Rover rover,Plateau plateau){
			rover.orientation.OrientLeft();
		}
	}
	
	public static class MoveForward implements MoveFunction{
		public MoveForward(){
			
		}
		
		@Override
		public void execute(Rover rover,Plateau plateau){
			if(rover.canMoveForward(plateau)){
				rover.moveForward();
			}
		}
	}
}
