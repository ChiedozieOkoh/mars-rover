package com.rover;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.rover.Master.Dimension;
import com.rover.Rover.MOVE;
import com.rover.Rover.Position;

public class MarsRoverTest {

	
	static final Dimension TEST_DIMENSION = new Dimension(5,5); 
	
	@Test
	public void shouldMakeMarsRover(){
		
		
		
		assertRoverRotation(new Rover.Position("1 1 E"),"1 1 N",MOVE.R);
		assertRoverRotation(new Rover.Position("1 1 W"),"1 1 N",MOVE.L);
		assertRoverRotation(new Rover.Position("1 1 S"),"1 1 E",MOVE.R);
		assertRoverRotation(new Rover.Position("1 1 N"),"1 1 W",MOVE.R);
		
		assertRoverMove(new Rover.Position("2 3 W"),"1 1 N","MMRMLL");
		assertRoverMove(new Rover.Position("1 5 N"),"1 5 N","MMMMM");
		assertRoverMove(new Rover.Position("5 1 E"),"5 1 E","MMMMM");
		assertRoverMove(new Rover.Position("1 0 S"),"1 0 S","MMMMM");
		assertRoverMove(new Rover.Position("0 1 W"),"0 1 W","MMMMM");
		
	}

	private void assertRoverRotation(Position endPoint, String origin, MOVE move){
		Rover r = new Rover(new Cmd(origin,move.toString()),TEST_DIMENSION);
		r.execute();
		r.display();
		assertTrue(r.coord.equals(endPoint));
	}

	private void assertRoverMove(Position endPoint, String origin,String moves){
		Rover r =  new Rover(new Cmd(origin,moves),TEST_DIMENSION);
		r.execute();
		r.display();
		assertTrue(r.coord.equals(endPoint));
	}
	
	
	@Test
	public void shouldMakeMaster(){
		final String order = "5 5\n" + 
				"1 1 N\n" + 
				"LM\n" + 
				"2 3 E\n" + 
				"MLM\n";
		Position[] expected = new Position[2];
		expected[0] = new Rover.Position("0 1 W");
		expected[1] = new Rover.Position("3 4 N");
		assertSlavesFollow(expected,order);
	}
	
	private void assertSlavesFollow(Position[] expected,String order){
		Master master = new Master(order);
		master.execute();
		int i = 0; 
		for(Position pos : expected) {
			assertTrue(pos.equals(master.slaves[i].coord));
			i++;
		}
	}

	public static final String TEST_POSITION = "1 2 N";
	public static final String TEST_DIRECTIONS = "LMLMLMLMM";
	public static final String TEST_POSITION_1 = "3 3 E";
	public static final String TEST_DIRECTIONS_1 = "MMRMMRMRRM";
	
	public static void main(String[] args){
		
	}
}
