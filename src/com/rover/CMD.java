package com.rover;

public enum CMD{
	L("LEFT"),
	R("RIGHT"),
	M("MOVE");
	CMD(String str){}
	public void execute(Rover rover){
		switch(this){
		case M:
			if(rover.canMoveForward()){
				rover.goForward();
			}
		default:
			rover.orientation = rover.orientation.orient(this);
			break;
		}		
	}

	public static CMD[] makeCMDArray(String cmdSequence){
		CMD[] actions = new CMD[cmdSequence.length()];
		for(int i = 0; i < cmdSequence.length(); i++){
			actions[i] = CMD.valueOf(String.valueOf(cmdSequence.charAt(i)));
		}
		return actions; 
	}
}