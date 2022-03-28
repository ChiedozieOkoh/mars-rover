package com.rover;

import java.util.HashMap;
import java.util.function.Function;


public class  Rover {
	private int x;
	private int y;
	private Orientation orientation;
	private final int limitX;
	private final int limitY;
	
	
	public enum Orientation{
		N("NORTH"),
		E("EAST"),
		S("SOUTH"),
		W("WEST");
		String oriName; 
		Orientation(String str) {
			this.oriName = str; 
		}

		@Override
		public String toString() {
			return oriName; 
		}
		
	}
	
	public Rover(String origin , int limitX, int limitY){
		String[] args = origin.split(" ");
		x = Integer.parseInt(args[0]);
		y = Integer.parseInt(args[1]);
		orientation = Orientation.valueOf(args[2]);	
		this.limitX = limitX;
		this.limitY = limitY;
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	private boolean canMoveForward(){
		switch (orientation){
			case N:
				return y < limitY;
			case E: 
				return x < limitX;
			case S: 
				return y > 0;
			case W:
				return x > 0;
		}
		return false;
	}

	public boolean equals( int x , int y ,Orientation orientation){
		return (this.x == x && this.y == y && this.orientation == orientation);
	}
	
	// change facing direction dependent on move command
	public void orientLeft() {
		orientation = Orientation.values()[Math.floorMod(orientation.ordinal() -1 , Orientation.values().length)];
	}
	public void orientRight(){
		orientation = Orientation.values()[(orientation.ordinal() + 1) % Orientation.values().length];
	}
	
	public void goNorth(){
		this.y++;
	}
	public void goEast(){
		this.x++;
	}
	public void goSouth(){
		this.y--;
	}
	public void goWest(){
		this.x--;
	}
	// change x , y positions dependent on current facing direction
	public void goForward() throws UnkownRoverOrientation{
		if(!canMoveForward()){
			return;
		}
		RoverMover movement = RoverMoverGenerator.GenerateRoverMover(orientation);
		movement.move(this);
	}

	public void display(){
		System.out.println(x + " " + y +  " " + orientation.toString());
	}
	
}
