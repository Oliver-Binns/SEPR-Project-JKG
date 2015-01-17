package com.SEPR.game;

/*
A checkpoint is a special subclass of junction that is only connected by two tracks, it is used to emulate different lengths of tracks
*/

public class Checkpoint extends Junction
{
	boolean IsFaulty;	//If true then the checkpoint (and consequently, track between two junctions) cannot be passed through
	String FaultMessage;	//Gives a reason for a faulty checkpoint
	
	//Overloaded constructors for instantiating Checkpoint with fewer arguments
	public Checkpoint(int ID)
	{
		this(ID, null, null);
	}

	public Checkpoint(int ID, int[][] JunctionsConnected, int[] TrainsPresent)
	{
		super(ID, JunctionsConnected, TrainsPresent);
		this.IsFaulty = false;
		this.FaultMessage = "";
	}
	
	//Repairs the fault at a checkpoint
	protected void RepairFault()
	{
		this.IsFaulty = false;
	}
	
	//Causes or changes a fault at a checkpoint
	protected void CauseFault(String Message)
	{
		this.IsFaulty = true;
		this.FaultMessage = Message;
	}
}
