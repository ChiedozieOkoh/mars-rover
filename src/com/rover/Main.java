package com.rover;

public class Main {
	
	
	public static void main(String[] args) {
		
		String order = "5 5\n" + 
		"1 2 N\n" + 
		"LMLMLMLMM\n" + 
		"3 3 E\n" + 
		"MMRMMRMRRM\n";
		Master master = new Master(order);
		master.execute();

	}

}
