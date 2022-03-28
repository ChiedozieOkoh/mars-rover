package com.rover;

public class CommandGenerator {
	
	public CommandGenerator(){
		
	}
	public static Command generateCommand(String input) throws UnkownCommandException{
		switch(input){
			case "R":
				return new RoverOrientRight();
			case "L":
				return new RoverOrientLeft();
			case "M": 
				return new RoverGoForward();
			default: 
				throw new UnkownCommandException();
		}
	}
}
