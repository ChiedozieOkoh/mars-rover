package com.rover;

import java.util.ArrayList;

import com.rover.Orientation.OrientationType;

public class Main {
	
	public static void main(String[] args) {
		String order = "5 5\n" + 
		"1 2 N\n" + 
		"LMLMLMLMM\n" + 
		"3 3 E\n" + 
		"MMRMMRMRRM\n";
		//ControlCentre master = new ControlCentre(order);
		//execute();
		parseAndExecuteOrders(order);
		
	}
	public static void parseAndExecuteOrders(String orders){
		String[] lines = orders.split("\n");
		String[] limits = lines[0].split(" ");
		
		int limitX = Integer.parseInt(limits[0]);
		int limitY = Integer.parseInt(limits[1]);
		
		ArrayList<Position> positions = new ArrayList<>((lines.length -1)/2);
		ArrayList<Move[]> listOfMoves = new ArrayList<>((lines.length -1)/2);
		
		for(int i = 1; i < lines.length ; i+=2) {
			positions.add(parsePosition(lines[i]));
			listOfMoves.add(parseMoveList(lines[i+1]));
		}
		Plateau plateau = new Plateau(limitX,limitY,positions,listOfMoves);
		plateau.run();
	}
	public static Position parsePosition(String str){
		String[] arguements = str.split(" ");
		int x = Integer.parseInt(arguements[0]);
		int y = Integer.parseInt(arguements[1]);
		OrientationType type  = OrientationType.valueOf(arguements[2]);
		
		return new Position(x,y,new Orientation(type));
	}
	public static Move[] parseMoveList(String str){
		Move[] moves = new Move[str.length()];
		for(int i = 0; i < str.length(); i++){
			moves[i] = Move.valueOf(String.valueOf(str.charAt(i)));
		}
		return moves; 
	}
	
}
