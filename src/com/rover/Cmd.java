package com.rover;

public class Cmd{
	private Move[] arguements; 
	public enum Move{
		L,
		R,
		M;
	}
	
	Cmd(String str){
		arguements = makeMOVEArray(str);
	}
	
	public void execute(Rover rover){
		for (int i = 0; i < arguements.length; i++) {
			switch (arguements[i]) {
			case M:
				if (rover.canMoveForward()) {
					rover.goForward();
				}
				break;
			default:
				rover.orient(arguements[i]);
				break;
			}
		}		
	}

	private  Move[] makeMOVEArray(String arguements){
		Move[] actions = new Move[arguements.length()];
		for(int i = 0; i < arguements.length(); i++){
			actions[i] = Move.valueOf(String.valueOf(arguements.charAt(i)));
		}
		return actions; 
	}
}