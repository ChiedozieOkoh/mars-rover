package com.rover;

import java.util.HashMap;
import java.util.function.Function;

import com.rover.Orientation.OrientationType;


public class  Rover {
	Position position;
	
	
	public Rover(Position origin ){
		this.position = origin;
	
		
	}
	

	public OrientationType getCurrentOrientation() {
		return position.orientation.getCurrentOrientation();
	}

	
	public boolean equals( Position p1){
		return (position.x == p1.x && position.y == p1.y && position.orientation.getCurrentOrientation() == p1.orientation.getCurrentOrientation());
	}
	


	public void display(){
		System.out.println(position.x + " " + position.y +  " " + position.orientation.getCurrentOrientation().toString());
	}
	
}
