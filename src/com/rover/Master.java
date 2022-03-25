package com.rover;


public class Master {
	public final int plateauX;
	public final int plateauY;
	public Rover[] slaves; 
	public final Cmd[] commands; 

	public Master(String order){
		String[] orders = order.split("\n");
		String   dimStr = orders[0];
		String[] dims   = dimStr.split(" ");
		slaves = new Rover[(orders.length - 1) / 2];
		commands = new Cmd [(orders.length -1) / 2];
		plateauX = Integer.parseInt(dims[0]);
		plateauY = Integer.parseInt(dims[1]);
		int j = 0;
		
		for(int i = 1; i < orders.length; i+=2){
			if(i + 1 < orders.length){
				slaves[j] = new Rover(orders[i], plateauX,plateauY);
				commands[j] = new Cmd(orders[i+1]);
			}
			j++;
		}
	}
	
	public void execute(){
		for(int i = 0; i < slaves.length; i++){
			commands[i].execute(slaves[i]);
			slaves[i].display();
		}
	}

}
