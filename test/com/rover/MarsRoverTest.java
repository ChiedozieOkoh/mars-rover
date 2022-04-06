package com.rover;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;



public class MarsRoverTest {
	static final int TEST_LIMIT_X = 5;
	static final int TEST_LIMIT_Y = 5; 
	@Test
	public  void shouldTurnRover(){
		String origin  = "1 1 N";
		String turnRight = "R";
		String expected = "1 1 E";
		
		assertRoverPositionAfterMove(origin,turnRight,expected);
	}

	@Test 
	public void shouldMoveRover(){
		String origin = ("1 1 W");
		String moveForward = "M";;
		String expected = "0 1 W";
		assertRoverPositionAfterMove(origin,moveForward,expected);
	}
	
	@Test
	public void shouldNotMoveRover(){
		String origin = "5 5 N";
		String moveForward = "M";
		String expected = "5 5 N";
		
		assertRoverPositionAfterMove(origin,moveForward,expected);
	}
	
	private void assertRoverPositionAfterMove(String origin, String move, String expectedPosition){
		Rover rover = Main.parseRover(origin);
		ArrayList<Rover>originList = new ArrayList<>();
		originList.add(rover);
		
		ArrayList<Move[]>moveList = new ArrayList<>();
		Move[] moves = Main.parseMoveList(move);
		moveList.add(moves);
		
		Rover expectedRover = Main.parseRover(expectedPosition);
		
		Plateau testPlateau = new Plateau(TEST_LIMIT_X,TEST_LIMIT_Y,originList,moveList);
		testPlateau.run();
		Rover computedPosition = testPlateau.getOccupiedSpaces().get(0);
		assertTrue(computedPosition.equals(expectedRover));
	}
}
