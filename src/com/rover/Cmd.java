package com.rover;

public class Cmd{
	private MOVE[] arguements; 
	public enum MOVE{
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

	private  MOVE[] makeMOVEArray(String arguements){
		MOVE[] actions = new MOVE[arguements.length()];
		for(int i = 0; i < arguements.length(); i++){
			actions[i] = MOVE.valueOf(String.valueOf(arguements.charAt(i)));
		}
		return actions; 
	}
}