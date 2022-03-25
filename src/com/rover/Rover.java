package com.rover;

public class  Rover {
	public int x;
	public int y;
	public ORIENTATION orientation;
	

	
	private final PlateauSize limits;

	public Rover(String origin ,  PlateauSize limits){
		
		String[] args = origin.split(" ");
		if(args.length < 3){
			
		}
		x = Integer.parseInt(args[0]);
		y = Integer.parseInt(args[1]);
		orientation = ORIENTATION.valueOf(args[2]);
		
		this.limits = limits; 
	}
	
	public boolean canMoveForward(){
		switch (orientation){
			case N:
				return y < limits.y;
			case E: 
				return x < limits.x;
			case S: 
				return y > 0;
			case W:
				return x > 0;
		}
		return false;
	}
	public boolean equals( int x , int y ,ORIENTATION orientation){
		return (this.x == x && this.y == y && this.orientation == orientation);
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

	public static class Direction{
		public CMD[] moves;
		
		public Direction(String arg){
			
		}
	}

	
}
