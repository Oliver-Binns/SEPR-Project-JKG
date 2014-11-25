public class Junction 
{
	int JunctionID;
	List<Integer> JunctionsConnectedList;	//Needs to be changed to int[] at a later date when map has been finalised
	List<Integer> TrainsPresent;

	private Junction(int ID, int[] JunctionsConnected, int[] TrainsPresent)
	{
		JunctionsConnected = new ArrayList<>();
		TrainsPresent = new ArrayList<>();
		
		this.JunctionID = ID;
		
		for(int Connection : JunctionsConnected)
		{
			this.JunctionsConnectedList.add(Connection);
		}
		
		for(int Train : TrainsPresent)
		{
			this.TrainsPresent.add(Train);
		}
	}
	
	private static void AddTrain(int TrainID)
	{
		TrainsPresent.add(TrainID);
	}
	
	private static void RemoveTrain(int TrainID)
	{
		TrainsPresent.remove(TrainID);
	}

	private static int GetJunctionID()
	{
		
		return this.JunctionID;
	}
	
	private static int[] GetConnectedJunctions()
	{
		return this.JunctionsConnectedList.toArray();
	}
	
	private static int[] GetTrains()
	{
		return this.TrainsPresent.toArray();
	}
	private static int FindNext(int Location, int Destination)
	{
		return 0;
	}
}
