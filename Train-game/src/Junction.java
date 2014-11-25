import java.util.ArrayList;


public class Junction {

	int JunctionID;
	ArrayList<Integer> JunctionsConnectedList;	//Needs to be changed to int[] at a later date when map has been finalised
	ArrayList<Integer> TrainsPresent;

	public Junction(int ID)
	{	
		this(ID, null, null);
	}

	public Junction(int ID, int[] JunctionsConnected, int[] TrainsPresent)
	{
		this.JunctionsConnectedList = new ArrayList<Integer>();
		this.TrainsPresent = new ArrayList<Integer>();
		
		this.JunctionID = ID;
		
		if(JunctionsConnected != null)
		{
			for(int Connection : JunctionsConnected)
			{
				this.JunctionsConnectedList.add(Connection);
			}
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
		this.TrainsPresent.remove(Integer.valueOf(TrainID));
	}

	protected int GetJunctionID()
	{
		return this.JunctionID;
	}
	
	protected int[] GetConnectedJunctions()
	{
		int Size = this.JunctionsConnectedList.size();
		int[] ReturnArray = new int[Size];
		
		for(int i=0; i<Size; i++)
		{
			ReturnArray[i] = this.JunctionsConnectedList.get(i);
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
	protected int FindNext(int Location, int Destination)
	{ 
		return 0;
	}
}
