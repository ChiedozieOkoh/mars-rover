package com.rover;

public class Position  {
	public int x; 
	public int y;
	public Orientation orientation;
	
	
	public Position(int x , int y , Orientation orientation){
		this.x = x;
		this.y = y; 
		this.orientation = orientation; 
	
	}

	public void moveForward(){
		switch(this.orientation.getCurrentOrientation()){
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
				break; 
		}
	}
	public boolean canMoveForward(Plateau plateau){
		switch (orientation.getCurrentOrientation()){
		case N:
			return y < plateau.limitY;
		case E: 
			return x < plateau.limitX;
		case S: 
			return y > 0;
		case W:
			return x > 0;
		}
		return false;
	}
}
