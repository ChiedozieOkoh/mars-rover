package com.rover;

import com.rover.Rover.Orientation;

public class RoverMoverGenerator {

	public static RoverMover GenerateRoverMover(Orientation orientation) throws UnkownRoverOrientation {
		switch (orientation){
			case N: 
				return new RoverMoveNorth();
			case E:
				return new RoverMoveEast();
			case S:
				return new RoverMoveSouth();
			case W:
				return new RoverMoveWest();
			default :
				throw new UnkownRoverOrientation();
		}
	}
}
