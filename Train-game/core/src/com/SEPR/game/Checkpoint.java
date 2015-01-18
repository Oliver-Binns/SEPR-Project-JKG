package com.SEPR.game;

/*
A checkpoint is a special subclass of junction that is only connected by two tracks, it is used to emulate different lengths of tracks
*/

public class Checkpoint extends Junction {
	boolean isFaulty;	//If true then the checkpoint (and consequently, track between two junctions) cannot be passed through
	String faultMessage;	//Gives a reason for a faulty checkpoint
	
	//Overloaded constructors for instantiating Checkpoint with fewer arguments
	public Checkpoint(int ID) {
		super(ID, null);
	}

	public Checkpoint(int ID, int[][] junctionsConnected)	{
		super(ID, junctionsConnected);
		this.isFaulty = false;
		this.faultMessage = "";
	}
	
	//Repairs the fault at a checkpoint
	protected void RepairFault() {
		this.isFaulty = false;
	}
	
	//Causes or changes a fault at a checkpoint
	protected void CauseFault(String Message) {
		this.isFaulty = true;
		this.faultMessage = Message;
	}
}
