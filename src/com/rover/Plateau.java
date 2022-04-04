package com.rover;

import java.util.ArrayList;

public class Plateau {
	public  final int limitX;
	public  final int limitY;
	private final ArrayList<Rover> roverList; 
	private final ArrayList<Move[]> moveList;
	
	public Plateau(int limitX , int limitY , ArrayList<Rover> originList , ArrayList<Move[]> moveList) {
		this.limitX = limitX;
		this.limitY = limitY;
		this.roverList = new ArrayList<>(originList.size());
		for(Rover origin : originList){
			this.roverList.add( new Rover(origin.x,origin.y,origin.orientation));
		}
		
		this.moveList = new ArrayList<>(moveList.size());
		this.moveList.addAll(moveList);
	}

	public ArrayList<Rover> getOccupiedSpaces(){
		return roverList;
	}

	private Rover doMoveAtPosition(Rover rover, Move move){
		Command command = CommandGenerator.createCommand(rover.orientation.getCurrentOrientation(), move);
		command.execute(rover, this);
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
