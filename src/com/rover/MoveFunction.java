package com.rover;

public interface MoveFunction {
	void execute(Position position, Plateau plateau);
	
	public static class MoveRight implements MoveFunction{
		public MoveRight(){
			
		}
		
		@Override
		public void execute(Position position, Plateau plateau) {
			position.orientation.OrientRight();
		}
	}
	
	public static class MoveLeft implements MoveFunction{
		public MoveLeft(){
			
		}
		
		@Override 
		public void execute(Position position,Plateau plateau){
			position.orientation.OrientLeft();
		}
	}
	
	public static class MoveForward implements MoveFunction{
		public MoveForward(){
			
		}
		
		@Override
		public void execute(Position position,Plateau plateau){
			if(position.canMoveForward(plateau)){
				position.moveForward();
			}
		}
	}
}
