package com.rover;

import com.rover.Command.MoveForwardWhenEast;
import com.rover.Command.MoveForwardWhenNorth;
import com.rover.Command.MoveForwardWhenSouth;
import com.rover.Command.MoveForwardWhenWest;
import com.rover.Command.TurnLeft;
import com.rover.Command.TurnRight;
import com.rover.Orientation.OrientationType;

public class CommandGenerator {
	public static final Command createCommand(OrientationType type,Move move){
		switch(move){
			case L:
				return new TurnLeft();
			case R:
				return new TurnRight();
			case M:
				return createForwardCommand(type);
			default:
				return null;
		}
	}
	private static final Command createForwardCommand(OrientationType type){
		switch(type){
			case N: 
				return new MoveForwardWhenNorth();
			case E:
				return new MoveForwardWhenEast();
			case S:
				return new MoveForwardWhenSouth();
			case W:
				return new MoveForwardWhenWest();
			default:
				return null;
		}
	}
}
