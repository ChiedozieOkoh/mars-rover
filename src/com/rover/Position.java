package com.rover;

public class Position {
	private int x; 
	private int y;
	
	public Position(int x, int y) {
		this.x = x; 
		this.y = y;
	}

	public void applyVector(Vector vector,Orientation orientation, Plateau plateau){
		x  = clamp(x + vector.deltaX,plateau.limitX);
		y  = clamp(y + vector.deltaY,plateau.limitY);
		
	}
	
	public boolean equals(Position p1){
		return x == p1.getX() && y == p1.getY();
	}
	
	private int clamp(int i,int limit){
		if(i > limit){
			return limit;
		}
		
		if(i < 0){
			return 0;
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
