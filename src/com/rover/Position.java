package com.rover;

public class Position {
	private int x; 
	private int y;
	
	public Position(int x, int y) {
		this.x = x; 
		this.y = y;
	}

	public void applyVector(Vector vector,Orientation orientation, Plateau plateau){
		x  = clamp(x + vector.deltaX,0,plateau.limitX);
		y  = clamp(y + vector.deltaY,0,plateau.limitY);
	}
	
	public boolean equals(Position p1){
		return x == p1.getX() && y == p1.getY();
	}
	
	private int clamp(int i,int lowerBound,int upperBound){
		if(i > upperBound){
			return upperBound;
		}
		
		if(i < lowerBound){
			return lowerBound;
		}
		return i;
	}
	
	public int getX(){
		return x; 
	}
	
	public int getY(){
		return y;
	}
}
