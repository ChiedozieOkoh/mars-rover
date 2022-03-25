package com.rover;

import com.rover.Master.Dimension;

public class  Rover {
	public Position coord; 
	public Direction actions; 
	private final Dimension limits;
	public Rover(Cmd cmd, Dimension limits){
		this.coord = new Position(cmd.origin);
		this.actions = new Direction(cmd.actions);
		this.limits = limits; 
	}
	private boolean canMoveForward(){
		switch (coord.cardinal){
			case N:
				return coord.y < limits.y;
			case E: 
				return coord.x < limits.x;
			case S: 
				return coord.y > 0;
			case W:
				return coord.x > 0;
		}
		return false;
	}
	public void execute(){
		for(MOVE move : actions.moves){
			this.coord.cardinal = this.coord.cardinal.orient(move);
			if(move == MOVE.M && canMoveForward()) {
				this.coord.inc();
			}
			
		}
	}
	
	public void display(){
		System.out.println(this.coord.x + " " + this.coord.y +  " " + this.coord.cardinal.toString());
	}

	public enum CARDINAL{
		N("NORTH"),
		E("EAST"),
		S("SOUTH"),
		W("WEST");
		CARDINAL(String str) {
		}

		public CARDINAL orient(MOVE move) {// change facing direction dependent on move command
			switch(move){
				case L: 
					return CARDINAL.values()[Math.floorMod(this.ordinal() -1 , CARDINAL.values().length)];
				case R: 
					return CARDINAL.values()[(this.ordinal() + 1) % CARDINAL.values().length];
				case M: 
					return this;
			}
			return this;
		}
	}

	public enum MOVE{
		L("LEFT"),
		R("RIGHT"),
		M("MOVE");
		MOVE(String str){}
	}

	public static class Position {
		
		public int x;
		public int y;
		public CARDINAL cardinal;
		public Position(String arg){
			String[] args = arg.split(" ");
			if(args.length < 3){
				
			}
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
			this.cardinal = CARDINAL.valueOf(args[2]);
		}
		
		public boolean equals(Position p1){
			return (x == p1.x && y == p1.y && cardinal == p1.cardinal);
		}
		public void inc(){// change x , y positions dependent on current facing direction
			switch(this.cardinal){
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
	}
	
	public static class Direction{
		public MOVE[] moves;
		
		public Direction(String arg){
			moves = new MOVE[arg.length()];
			for(int i = 0; i < arg.length(); i++){
				moves[i] = MOVE.valueOf(String.valueOf(arg.charAt(i)));
			}
		}
	}

	
}
