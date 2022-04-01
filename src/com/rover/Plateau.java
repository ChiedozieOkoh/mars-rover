package com.rover;

import java.util.ArrayList;
import java.util.HashMap;

import com.rover.MoveFunction.MoveForward;
import com.rover.MoveFunction.MoveLeft;
import com.rover.MoveFunction.MoveRight;

public class Plateau {
	public  final int limitX;
	public  final int limitY;
	private final ArrayList<Rover> roverList; 
	private final ArrayList<Move[]> moveList;
	private final HashMap<Move,MoveFunction>moveGenerator;
	
	public Plateau(int limitX , int limitY , ArrayList<Rover> originList , ArrayList<Move[]> moveList) {
		this.limitX = limitX;
		this.limitY = limitY;
		this.roverList = new ArrayList<>(originList.size());
		for(Rover origin : originList){
			this.roverList.add( new Rover(origin.x,origin.y,origin.orientation));
		}
		
		this.moveList = new ArrayList<>(moveList.size());
		this.moveList.addAll(moveList);
		
		moveGenerator = new HashMap<>();
		moveGenerator.put(Move.L, new MoveLeft());
		moveGenerator.put(Move.R, new MoveRight());
		moveGenerator.put(Move.M, new MoveForward());
	}
	
	public ArrayList<Rover> getOccupiedSpaces(){
		return roverList;
	}
	
	private Rover doMoveAtPosition(Rover rover, Move move){
		MoveFunction moveFunction = moveGenerator.get(move);
		moveFunction.execute(rover, this);
		return rover; 
	}
	
	public void run(){
		for(int i = 0; i < roverList.size(); i++){
			Rover currentRover = roverList.get(i);
			for(Move move : moveList.get(i)){
				currentRover = doMoveAtPosition(currentRover,move);
			}
			
			currentRover.display();
		}
	}
}
