package com.rover;

public class RoverGoForward implements Command {

	@Override
	public void execute(Rover rover) {
		try {
			rover.goForward();
		} catch (UnkownRoverOrientation e) {
			e.printStackTrace();
		}
	}

}
