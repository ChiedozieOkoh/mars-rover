package com.rover;

public enum Move {
	L(-1,0),
	M(0,1),
	R(1,0);
	private final int rotation;
	private final int vectorScale;
	
	Move(int rotation,int vectorScale){
		this.rotation = rotation;
		this.vectorScale = vectorScale;
	}
	
	public int getVectorScale(){
		return vectorScale;
	}
	
	public int getRotation(){
		return rotation;
	}
}
