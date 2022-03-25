package com.rover;


public class Master {
	public final PlateauSize plateauSize; 
	public Rover[] slaves; 
	public final String[] moveCommands; 

	public Master(String order){
		String[] orders = order.split("\n");
		String   dimStr = orders[0];
		String[] dims   = dimStr.split(" ");
		slaves = new Rover[(orders.length - 1) / 2];
		moveCommands = new String [(orders.length -1) / 2];
		this.plateauSize = new PlateauSize(Integer.parseInt(dims[0]),Integer.parseInt(dims[1])); 
		int j = 0;
		
		for(int i = 1; i < orders.length; i+=2){
			if(i + 1 < orders.length){
				slaves[j] = new Rover(orders[i], plateauSize);
				moveCommands[j] = new String(orders[i+1]);
			}
			j++;
		}
	}
	
	public void execute(){
		for(int i = 0; i < slaves.length; i++){
			CMD[] cmdArray = CMD.makeCMDArray(moveCommands[i]);
			for(CMD cmd : cmdArray){
				cmd.execute(slaves[i]);
			}
			slaves[i].display();
		}
	}

}
