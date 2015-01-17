package com.SEPR.game;

import java.util.ArrayList;

/*
Junction is a connection between more than one track that can be travelled to by players
*/

public class Junction {

	int JunctionID;	//Unique identifying number for each junction
	int[][] JunctionsConnectedList;	//A 2D array of connected junctions, the first item of each column is the Next Junction, each item after that are all the "Checkpoints" in between
	ArrayList<Integer> TrainsPresent;	//A dynamic list of the ID numbers for the trains currently at the junction

	//Overloaded constructors for instantiating Junction with fewer arguments
	public Junction(int ID)
	{
		this(ID, null);
	}

	public Junction(int ID, int[][] JunctionsConnected)
	{
		this.JunctionID = ID;
		this.TrainsPresent = new ArrayList<Integer>();

		if(JunctionsConnected != null)
		{
			this.JunctionsConnectedList = JunctionsConnected;
		}
		else
		{
			this.JunctionsConnectedList = new int[1][1];	//If there are no connected junctions, the attribute defaults to {{0}}
		}
	}

	//Returns the ID for the Junction
	protected int GetID()
	{
		return this.JunctionID;
	}

	//Adds Train to the TrainsPresent list
	protected void AddTrain(Integer TrainID)
	{
		this.TrainsPresent.add(TrainID);
	}

	//Removes Train from the TrainsPresent list
	protected void RemoveTrain(Integer TrainID)
	{
		this.TrainsPresent.remove(TrainID);
	}

	//Returns an array of the ID numbers for the available junctions a player can move to
	protected int[] GetConnectedJunctions()
	{
		int Size = this.JunctionsConnectedList.length;
		int[] ReturnArray = new int[Size];

		for(int i=0; i<Size; i++)
		{
			ReturnArray[i] = this.JunctionsConnectedList[i][0];
		}

		return ReturnArray;
	}

	//Returns the list of train IDs currently at the junction
	protected ArrayList<Integer> GetTrains()
	{
		return this.TrainsPresent;
	}

	//Returns true if a train ID is at the junction
	protected boolean IsPresent(Integer TrainID)
	{
		return TrainsPresent.contains(TrainID);
	}

	//Returns the ID number of the next point on the line for a train to move to
	protected int FindNext(int Destination)
	{
		for(int i=0; i<this.JunctionsConnectedList.length; i++)
		{
			if(this.JunctionsConnectedList[i][0] == Destination)
			{
				return this.JunctionsConnectedList[i][1];
			}
		}
		return -1;
	}
}
