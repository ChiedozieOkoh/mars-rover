package com.rover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MarsRoverTest {

	
	static final PlateauSize TEST_DIMENSION = new PlateauSize(5,5); 
	
	@Test
	public void shouldMakeMarsRover(){
		
		
		
		assertRoverRotation(1,1,ORIENTATION.E,"1 1 N",CMD.R);
		assertRoverRotation(1,1,ORIENTATION.W,"1 1 N",CMD.L);
		assertRoverRotation(1,1,ORIENTATION.S,"1 1 E",CMD.R);
		assertRoverRotation(1,1,ORIENTATION.N,"1 1 W",CMD.R);
		
		assertRoverMove(2,3,ORIENTATION.W,"1 1 N","MMRMLL");
		assertRoverMove(1,5,ORIENTATION.N,"1 5 N","MMMMM");
		assertRoverMove(5,1,ORIENTATION.E,"5 1 E","MMMMM");
		assertRoverMove(1,0,ORIENTATION.S,"1 0 S","MMMMM");
		assertRoverMove(0,1,ORIENTATION.W,"0 1 W","MMMMM");
		
	}

	private void assertRoverRotation(int x, int y, ORIENTATION orientation, String origin, CMD move){
		Rover r = new Rover(origin,TEST_DIMENSION);
		move.execute(r);
		r.display();
		assertTrue(r.equals(x,y,orientation));
	}

	private void assertRoverMove(int x, int y, ORIENTATION orientation, String origin,String moves){
		Rover r =  new Rover(origin,TEST_DIMENSION);
		CMD[] cmdArr = CMD.makeCMDArray(moves);
		for(CMD cmd : cmdArr){
			cmd.execute(r);
		}
		r.display();
		assertTrue(r.equals(x,y,orientation));
	}
	
	
	@Test
	public void shouldMakeMaster(){
		final String order = "5 5\n" + 
				"1 1 N\n" + 
				"LM\n" + 
				"2 3 E\n" + 
				"MLM\n";
		Rover[] expected = new Rover[2];
		expected[0] = new Rover("0 1 W",TEST_DIMENSION);
		expected[1] = new Rover("3 4 N",TEST_DIMENSION);
		assertSlavesFollow(expected,order);
	}
	
	private void assertSlavesFollow(Rover[] expected,String order){
		Master master = new Master(order);
		master.execute();
		int  i = 0;
		for(Rover r : master.slaves){
			assertEquals(r.x,expected[i].x);
			assertEquals(r.y,expected[i].y);
			assertEquals(r.orientation,expected[i].orientation);
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
