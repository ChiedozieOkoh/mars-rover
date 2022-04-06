package com.rover;

import java.util.ArrayList;



public class Main {
	
	public static void main(String[] args) {
		String order = "5 5\n" + 
		"1 2 N\n" + 
		"LMLMLMLMM\n" + 
		"3 3 E\n" + 
		"MMRMMRMRRM\n";
		executeOrders(order);		
	}
	
	public static void executeOrders(String orders){
		String[] lines = orders.split("\n");
		int[] limits = parseLimits(lines[0]);
		
		ArrayList<Rover> positions = new ArrayList<>((lines.length -1)/2);
		ArrayList<Move[]> listOfMoves = new ArrayList<>((lines.length -1)/2);
		
		for(int i = 1; i < lines.length ; i+=2) {
			positions.add(parseRover(lines[i]));
			listOfMoves.add(parseMoveList(lines[i+1]));
		}
		Plateau plateau = new Plateau(limits[0],limits[1],positions,listOfMoves);
		plateau.run();
	}
	
	public static int[] parseLimits(String str){
		String [] strLimits = str.split(" ");
		int limits[] = new int [2];
		limits[0] = Integer.parseInt(strLimits[0]);
		limits[1] = Integer.parseInt(strLimits[1]);
		return limits; 
	}
	public static Rover parseRover(String str){
		String[] arguements = str.split(" ");
		int x = Integer.parseInt(arguements[0]);
		int y = Integer.parseInt(arguements[1]);
		Orientation orientation = OrientationGenerator.createOrientation(arguements[2]);
		return new Rover(x,y,orientation);
	}
	
	public static Move[] parseMoveList(String str){
		Move[] moves = new Move[str.length()];
		for(int i = 0; i < str.length(); i++){
			moves[i] = Move.valueOf(String.valueOf(str.charAt(i)));
		}
		return moves; 
	}
}
