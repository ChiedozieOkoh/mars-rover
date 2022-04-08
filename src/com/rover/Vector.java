package com.rover;

public class Vector {
	public final int deltaX;
	public final int deltaY;
	public Vector(int deltaX, int deltaY) {
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	public Vector scale(int scalar){
		return new Vector(this.deltaX * scalar,this.deltaY * scalar);
	}
}
