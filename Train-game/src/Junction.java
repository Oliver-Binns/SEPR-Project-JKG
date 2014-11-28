package MapGraph;

import java.util.ArrayList;


public class Junction {

	int JunctionID;
	int[][] JunctionsConnectedList;
	ArrayList<Integer> TrainsPresent;

	public Junction(int ID)
	{	
		this(ID, null, null);
	}

	public Junction(int ID, int[][] JunctionsConnected, int[] TrainsPresent)
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
		
		if(TrainsPresent != null)
		{
			for(int Train : TrainsPresent)
			{
				this.TrainsPresent.add(Train);
			}
		}
	}
	
	protected void AddTrain(Integer TrainID)
	{
		this.TrainsPresent.add(TrainID);
	}
	
	protected void RemoveTrain(Integer TrainID)
	{
		this.TrainsPresent.remove(TrainID);
	}

	protected int GetJunctionID()
	{
		return this.JunctionID;
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
	
<<<<<<< HEAD
	protected boolean IsPresent(Integer TrainID)
	{
		return TrainsPresent.contains(Integer TrainID);
	}
	
=======
>>>>>>> cda2e81d373d0c5d6aedd3d72126c1208cac3003
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
