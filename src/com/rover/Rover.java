package com.rover;





public class Rover{
	private int x; 
	private int y;
	public Orientation orientation;

	
	public Rover(int x , int y , Orientation orientation){
		this.x = x;
		this.y = y; 
		this.orientation = orientation; 
		
	}

	private boolean canMoveForward(Vector v, Orientation orientation,Plateau plateau){
		switch(orientation){
		case N:
			return y + v.deltaY <= plateau.limitY;
		case E:
			return x + v.deltaX <= plateau.limitX;
		case S:
			return y + v.deltaY >= 0;
		case W:
			return x + v.deltaX >= 0;
		default:
			return false;
		}
	}
	public void applyVector(Vector vector,Plateau plateau){
		if (canMoveForward(vector,orientation,plateau)) {
			x += vector.deltaX;
			y += vector.deltaY;
		}
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public boolean equals( Rover p1){
		return (x == p1.x && y == p1.y && orientation.getCurrentOrientation() == p1.orientation.getCurrentOrientation());
	}
	public void display(){
		System.out.println(x + " " + y +  " " + orientation.getCurrentOrientation().toString());
	}
}
