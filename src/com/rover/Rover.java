package com.rover;

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

	public boolean canMoveForward(){
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
	
	public  void orient(Cmd.Move move) {// change facing direction dependent on move command
		switch(move){
			case L: 
				orientation = Orientation.values()[Math.floorMod(orientation.ordinal() -1 , Orientation.values().length)];
				break;
			case R:
				orientation = Orientation.values()[(orientation.ordinal() + 1) % Orientation.values().length];	
				break;
		}
	}
	
	public void goForward(){// change x , y positions dependent on current facing direction
		switch(orientation){
			case N: 
				this.y++;
				break; 
			case E: 
				this.x++;
				break;
			case S: 
				this.y--;
				break; 
			case W: 
				this.x--;
		}
	}

	public void display(){
		System.out.println(x + " " + y +  " " + orientation.toString());
	}
	
}
