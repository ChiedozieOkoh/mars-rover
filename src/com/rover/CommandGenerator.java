package com.rover;

import com.rover.Command.MoveForward;
import com.rover.Command.TurnLeft;
import com.rover.Command.TurnRight;

public class CommandGenerator {
	public static final Command createCommand(Orientation type,Move move){
		switch(move){
			case L:
				return new TurnLeft();
			case R:
				return new TurnRight();
			case M:
				return new MoveForward();
			default:
				return null;
		}
	}

}
