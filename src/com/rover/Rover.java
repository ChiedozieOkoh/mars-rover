package com.rover;

public class Rover{
	private Position position;
	public Orientation orientation;

	public Rover(int x , int y , Orientation orientation){
		position = new Position(x,y);
		this.orientation = orientation; 
	}

	public Position getPosition(){
		return position;
	}

	public boolean equals( Rover p1){
		return (position.equals(p1.getPosition()) && orientation == p1.orientation);
	}

	public void display(){
		System.out.println(position.getX() + " " + position.getY() +  " " + orientation.toString());
	}
}
