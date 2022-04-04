package com.rover;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;



public class MarsRoverTest {
	static final int TEST_LIMIT_X = 5;
	static final int TEST_LIMIT_Y = 5; 
	@Test
	public  void shouldTurnRover(){
		Rover origin = new Rover(1,1,new North());
		Move turnRight = Move.R;
		Rover expected = new Rover(1,1,new East());
		
		assertRoverPositionAfterMove(origin,turnRight,expected);
	}

	@Test 
	public void shouldMoveRover(){
		Rover origin = new Rover(1,1,new West());
		Move moveForward = Move.M;
		Rover expected = new Rover(0,1,new West());
		
		assertRoverPositionAfterMove(origin,moveForward,expected);
	}
	
	@Test
	public void shouldNotMoveRover(){
		Rover origin = new Rover(TEST_LIMIT_X,TEST_LIMIT_Y,new North());
		Move moveForward = Move.M; 
		Rover expected = new Rover(TEST_LIMIT_X,TEST_LIMIT_Y,new North());
		
		assertRoverPositionAfterMove(origin,moveForward,expected);
	}
	
	private void assertRoverPositionAfterMove(Rover origin, Move move, Rover expectedPosition){
		ArrayList<Rover>originList = new ArrayList<>();
		originList.add(origin);
		
		ArrayList<Move[]>moveList = new ArrayList<>();
		Move[] moves = new Move[1];
		moves[0] = move;
		moveList.add(moves);
		
		Plateau testPlateau = new Plateau(TEST_LIMIT_X,TEST_LIMIT_Y,originList,moveList);
		testPlateau.run();
		Rover computedPosition = testPlateau.getOccupiedSpaces().get(0);
		assertTrue(computedPosition.equals(expectedPosition));
	}
}
