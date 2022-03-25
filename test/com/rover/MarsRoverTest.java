package com.rover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.rover.Rover.Orientation;

public class MarsRoverTest {

	
	static final int TEST_PLATEAU_X = 5;
	static final int TEST_PLATEAU_Y = 5;
	@Test
	public void shouldMakeMarsRover(){
		assertRoverRotation(1,1,Orientation.E,"1 1 N",new Cmd("R"));
		assertRoverRotation(1,1,Orientation.W,"1 1 N",new Cmd("L"));
		assertRoverRotation(1,1,Orientation.S,"1 1 E",new Cmd("R"));
		assertRoverRotation(1,1,Orientation.N,"1 1 W",new Cmd("R"));
		
		assertRoverMove(2,3,Orientation.W,"1 1 N","MMRMLL");
		assertRoverMove(1,5,Orientation.N,"1 5 N","MMMMM");
		assertRoverMove(5,1,Orientation.E,"5 1 E","MMMMM");
		assertRoverMove(1,0,Orientation.S,"1 0 S","MMMMM");
		assertRoverMove(0,1,Orientation.W,"0 1 W","MMMMM");
	}

	private void assertRoverRotation(int x, int y, Orientation orientation, String origin, Cmd move){
		Rover r = new Rover(origin,TEST_PLATEAU_X,TEST_PLATEAU_Y);
		move.execute(r);
		r.display();
		assertTrue(r.equals(x,y,orientation));
	}

	private void assertRoverMove(int x, int y, Orientation orientation, String origin,String moves){
		Rover r =  new Rover(origin,TEST_PLATEAU_X,TEST_PLATEAU_Y);
		Cmd cmd = new Cmd(moves);
		cmd.execute(r);
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
		expected[0] = new Rover("0 1 W",TEST_PLATEAU_X,TEST_PLATEAU_Y);
		expected[1] = new Rover("3 4 N",TEST_PLATEAU_X,TEST_PLATEAU_Y);
		assertSlavesFollow(expected,order);
	}
	
	private void assertSlavesFollow(Rover[] expected,String order){
		Master master = new Master(order);
		master.execute();
		int  i = 0;
		for(Rover r : master.slaves){
			assertEquals(r.getX(),expected[i].getX());
			assertEquals(r.getY(),expected[i].getY());
			assertEquals(r.getOrientation(),expected[i].getOrientation());
			i++;
		}
		
	}

	public static final String TEST_POSITION = "1 2 N";
	public static final String TEST_COMMANDS = "LMLMLMLMM";
	public static final String TEST_POSITION_1 = "3 3 E";
	public static final String TEST_COMMANDS_1 = "MMRMMRMRRM";
	
}
