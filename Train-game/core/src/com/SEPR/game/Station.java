package com.SEPR.game;

/*
Station is a sub-class of Junction that has extra properties, they will act as destinations for players.
*/

public class Station extends Junction {	
	//Overloaded constructors for instantiating Station with fewer arguments
	public Station(int ID) {
		super(ID, null);
	}
	
	public Station(int ID, int[][] JunctionsConnected) {
		super(ID, JunctionsConnected);
	}
}
