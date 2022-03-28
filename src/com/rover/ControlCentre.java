package com.rover;


public class ControlCentre {
	public final int plateauX;
	public final int plateauY;
	public Rover[] rovers; 
	public final CommandListExecutor[] commands; 

	public ControlCentre(String order) throws UnkownCommandException{
		String[] orders = order.split("\n");
		String   dimStr = orders[0];
		String[] dims   = dimStr.split(" ");
		rovers = new Rover[(orders.length - 1) / 2];
		commands = new CommandListExecutor [(orders.length -1) / 2];
		plateauX = Integer.parseInt(dims[0]);
		plateauY = Integer.parseInt(dims[1]);
		int j = 0;
		
		for(int i = 1; i < orders.length; i+=2){
			if(i + 1 < orders.length){
				rovers[j] = new Rover(orders[i], plateauX,plateauY);
				commands[j] = new CommandListExecutor(orders[i+1]);
			}
			j++;
		}
	}
	
	public void execute(){
		for(int i = 0; i < rovers.length; i++){
			commands[i].run(rovers[i]);
			rovers[i].display();
		}
	}

}
