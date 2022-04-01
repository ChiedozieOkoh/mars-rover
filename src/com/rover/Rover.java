package com.rover;

import java.util.HashMap;

import com.rover.CompassDirection.East;
import com.rover.CompassDirection.North;
import com.rover.CompassDirection.South;
import com.rover.CompassDirection.West;
import com.rover.Orientation.OrientationType;

public class Rover{
	public int x; 
	public int y;
	public Orientation orientation;
	private final HashMap<OrientationType,CompassDirection> directionGenerator; 
	
	public Rover(int x , int y , Orientation orientation){
		this.x = x;
		this.y = y; 
		this.orientation = orientation; 
		this.directionGenerator = new HashMap<>();
		
		directionGenerator.put(OrientationType.N, new North());
		directionGenerator.put(OrientationType.E, new East());
		directionGenerator.put(OrientationType.S, new South());
		directionGenerator.put(OrientationType.W, new West());
	}

	public void moveForward(){
		CompassDirection direction = directionGenerator.get(orientation.getCurrentOrientation());
		direction.moveInThisDirection(this);
	}
	public boolean canMoveForward(Plateau plateau){
		CompassDirection direction = directionGenerator.get(orientation.getCurrentOrientation());
		return direction.canMoveInThisDirection(this, plateau);
	}
	public boolean equals( Rover p1){
		return (x == p1.x && y == p1.y && orientation.getCurrentOrientation() == p1.orientation.getCurrentOrientation());
	}
	public void display(){
		System.out.println(x + " " + y +  " " + orientation.getCurrentOrientation().toString());
	}
}
