package com.rover;

import java.util.HashMap;

import com.rover.CompassDirection.East;
import com.rover.CompassDirection.North;
import com.rover.CompassDirection.South;
import com.rover.CompassDirection.West;
import com.rover.Orientation.OrientationType;

public class Position  {
	public int x; 
	public int y;
	public Orientation orientation;
	private final HashMap<OrientationType,CompassDirection> orientationMap; 
	
	public Position(int x , int y , Orientation orientation){
		this.x = x;
		this.y = y; 
		this.orientation = orientation; 
		this.orientationMap = new HashMap<>();
		
		orientationMap.put(OrientationType.N, new North());
		orientationMap.put(OrientationType.E, new East());
		orientationMap.put(OrientationType.S, new South());
		orientationMap.put(OrientationType.W, new West());
	}

	public void moveForward(){
		CompassDirection direction = orientationMap.get(orientation.getCurrentOrientation());
		direction.moveInThisDirection(this);
	}
	public boolean canMoveForward(Plateau plateau){
		CompassDirection direction = orientationMap.get(orientation.getCurrentOrientation());
		return direction.canMoveInThisDirection(this, plateau);
	}
	public boolean equals( Position p1){
		return (x == p1.x && y == p1.y && orientation.getCurrentOrientation() == p1.orientation.getCurrentOrientation());
	}
	public void display(){
		System.out.println(x + " " + y +  " " + orientation.getCurrentOrientation().toString());
	}
}
