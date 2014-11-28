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
	
	protected void AddTrain(int TrainID)
	{
		this.TrainsPresent.add(TrainID);
	}
	
	protected void RemoveTrain(int TrainID)
	{
		this.TrainsPresent.remove(Integer.valueOf(TrainID)); // why not just "TrainID"? 
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
	
	protected int[] GetTrains()
	{
		int Size = this.TrainsPresent.size();
		int[] ReturnArray = new int[Size];
		
		for(int i=0; i<Size; i++)
		{
			ReturnArray[i] = this.TrainsPresent.get(i);
		}
		
		return ReturnArray;
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
