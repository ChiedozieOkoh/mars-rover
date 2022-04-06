package com.rover;

public class Position {
	private int x; 
	private int y;
	
	public Position(int x, int y) {
		this.x = x; 
		this.y = y;
	}

	public void applyVector(Vector vector,Orientation orientation, Plateau plateau){
		if (canMoveForward(vector,orientation,plateau)) {
			x += vector.deltaX;
			y += vector.deltaY;
		}
	}
	
	public boolean equals(Position p1){
		return x == p1.getX() && y == p1.getY();
	}
	
	public int getX(){
		return x; 
	}
	
	public int getY(){
		return y;
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
	
	
	
}
