package com.rover;

public class Command {
	private final Move move;
	public Command(Move move){
		this.move = move; 
	}
	void execute(Rover rover,Plateau plateau){
		Vector v = rover.getOrientation().forwardVector();
		v = v.scale(move.getVectorScale());
		rover.getPosition().applyVector(v,rover.getOrientation(), plateau);
		rover.orient(move);
	}
	
}

