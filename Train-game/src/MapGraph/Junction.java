package MapGraph;

import java.util.ArrayList;


public class Junction {

	int JunctionID;
	int[][] JunctionsConnectedList;
	ArrayList<Integer> TrainsPresent;

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
			this.JunctionsConnectedList = new int[1][1];
		}
	}

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

	protected ArrayList<Integer> GetTrains()
	{
		return this.TrainsPresent;
	}


	protected boolean IsPresent(Integer TrainID)
	{
		return TrainsPresent.contains(Integer TrainID);
	}

	protected int FindNext(int Destination)
	{
		int Dest;

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
