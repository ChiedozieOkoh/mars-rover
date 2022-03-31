package com.rover;

import java.util.ArrayList;

public class Plateau {
	public final int limitX;
	public final int limitY;
	private ArrayList<Position> originList; 
	private ArrayList<Move[]> moveList;
	public Plateau(int limitX , int limitY , ArrayList<Position> originList , ArrayList<Move[]> moveList) {
		this.limitX = limitX;
		this.limitY = limitY;
		this.originList = new ArrayList<>(originList.size());
		for(Position origin : originList){
			this.originList.add( new Position(origin.x,origin.y,origin.orientation));
		}
		
		this.moveList = new ArrayList<>(moveList.size());
		this.moveList.addAll(moveList);
	}
	
	
	
	private Position doMoveAtPosition(Position position, Move move){
		switch(move){
			case  L: 
				 position.orientation.OrientLeft();
				 break;
			case R:
				 position.orientation.OrientRight();
				 break;
			case M: 
				 if(position.canMoveForward(this)){
					 position.moveForward();
				 }
				 
		}
		return position; 
	}
	public void run(){
		for(int i = 0; i < originList.size(); i++){
			Position currentPosition = originList.get(i);
			for(Move move : moveList.get(i)){
				currentPosition = doMoveAtPosition(currentPosition,move);
			}
			Rover rover = new Rover(currentPosition);
			rover.display();
		}
	}
}
