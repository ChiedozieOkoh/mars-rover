package com.rover;

import java.util.HashMap;

import com.rover.Orientation.OrientationType;

public class Rover{
	public int x; 
	public int y;
	public Orientation orientation;

	
	public Rover(int x , int y , Orientation orientation){
		this.x = x;
		this.y = y; 
		this.orientation = orientation; 
		
	}

	
	public boolean equals( Rover p1){
		return (x == p1.x && y == p1.y && orientation.getCurrentOrientation() == p1.orientation.getCurrentOrientation());
	}
	public void display(){
		System.out.println(x + " " + y +  " " + orientation.getCurrentOrientation().toString());
	}
}
