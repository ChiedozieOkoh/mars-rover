package com.rover;

public class Rover{
	private Position position;
	private Orientation orientation;

	public Rover(int x , int y , Orientation orientation){
		position = new Position(x,y);
		this.orientation = orientation; 
	}

	public void orient(Move move){
		orientation = orientation.orient(move);
	}
	
	public Position getPosition(){
		return position;
	}
	public void applyVector(Vector v,Plateau plateau){
		position.applyVector(v,plateau);
	}
	public Orientation getOrientation(){
		return orientation;
	}
	
	public boolean equals( Rover p1){
		return (position.equals(p1.getPosition()) && orientation == p1.orientation);
	}
	
	public void display(){
		System.out.println(position.getX() + " " + position.getY() +  " " + orientation.toString());
	}
}
