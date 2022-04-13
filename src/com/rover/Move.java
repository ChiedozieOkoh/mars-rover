package com.rover;

public enum Move {
	L(-1,0),
	R(1,0),
	M(0,1);
	
	private final int rotation;
	private final int vectorScale;
	
	Move(int rotation,int vectorScale){
		this.rotation = rotation;
		this.vectorScale = vectorScale;
	}
	void execute(Rover rover,Plateau plateau){
		Vector v = rover.getOrientation().forwardVector();
		v = v.scale(getVectorScale());
		
		rover.applyVector(v,plateau);
		rover.orient(this);
	}
	
	public int getVectorScale(){
		return vectorScale;
	}
	
	public int getRotation(){
		return rotation;
	}
}
