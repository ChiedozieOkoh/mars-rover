package com.rover;

import java.util.ArrayList;
import java.util.HashMap;

import com.rover.MoveFunction.MoveForward;
import com.rover.MoveFunction.MoveLeft;
import com.rover.MoveFunction.MoveRight;

public class Plateau {
	public  final int limitX;
	public  final int limitY;
	private final ArrayList<Position> originList; 
	private final ArrayList<Move[]> moveList;
	private final HashMap<Move,MoveFunction>moveMap;
	
	public Plateau(int limitX , int limitY , ArrayList<Position> originList , ArrayList<Move[]> moveList) {
		this.limitX = limitX;
		this.limitY = limitY;
		this.originList = new ArrayList<>(originList.size());
		for(Position origin : originList){
			this.originList.add( new Position(origin.x,origin.y,origin.orientation));
		}
		
		this.moveList = new ArrayList<>(moveList.size());
		this.moveList.addAll(moveList);
		
		moveMap = new HashMap<>();
		moveMap.put(Move.L, new MoveLeft());
		moveMap.put(Move.R, new MoveRight());
		moveMap.put(Move.M, new MoveForward());
	}
	
	public ArrayList<Position> getOccupiedSpaces(){
		return originList;
	}
	
	private Position doMoveAtPosition(Position position, Move move){
		MoveFunction moveFunction = moveMap.get(move);
		moveFunction.execute(position, this);
		return position; 
	}
	
	public void run(){
		for(int i = 0; i < originList.size(); i++){
			Position currentPosition = originList.get(i);
			for(Move move : moveList.get(i)){
				currentPosition = doMoveAtPosition(currentPosition,move);
			}
			
			currentPosition.display();
		}
	}
}
