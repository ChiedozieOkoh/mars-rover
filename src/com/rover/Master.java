package com.rover;

public class Master {
	public Dimension plateauSize; 
	public Rover[] slaves; 
	public static class Dimension{
		int x; 
		int y;
		public Dimension(int x , int y ){
			this.x = x; 
			this.y = y;
		}
		public boolean contains(int x , int y){
			return x <= this.x && y <= this.y;
		}
	}
	public Master(String order){
		String[] orders = order.split("\n");
		String   dimStr = orders[0];
		String[] dims   = dimStr.split(" ");
		slaves = new Rover[(orders.length - 1) / 2];
		this.plateauSize = new Dimension(Integer.parseInt(dims[0]),Integer.parseInt(dims[1])); 
		int j = 0;
		for(int i = 1; i < orders.length; i+=2){
			if(i + 1 < orders.length){
				slaves[j] = new Rover(new Cmd(orders[i],orders[i + 1]),plateauSize);
			}
			j++;
		}
	}
	
	public void execute(){
		for(Rover r : slaves){
			r.execute();
			r.display();
		}
	}

}
