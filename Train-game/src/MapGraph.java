package MapGraph;


public class MapGraph
{
	int CurrentPlayer;
	int[] PlayerList;
	int TurnCounter;
	Goal[] ActiveGoalList;
	int[][] MapArray;
	ArrayList<Integer> TrainList;
	Junction[] JunctionList;
	
	public MapGraph(int size)
	{
		this.CurrentPlayer = 1;
		this.PlayerList = [1,2];
		this.TurnCounter = 0;
		this.ActiveGoalList = new Goal[3];
		this.MapArray = new int[size][size];
		this.TrainList = new ArrayList<Integer>();
		this.JunctionList = new Junction[size];
	}

	protected void CreateJunction(int[][] JunctionsConnected, int[] TrainsPresent)
	{
		
	}
	
	protected void CreateCheckPoint()
	{
		
	}
	
	protected void CreateStation()
	{
		
	}
	
	protected void MoveTrain(int TrainID, int Location, int Destination)
	{
		Junction Location = JunctionList[Location];
		
		if(Location.IsPresent(Integer.valueOf(TrainID)))
		{
			int NewLoc = Location.FindNext(Destination);
			Location.RemoveTrain(Integer.valueOf(TrainID));
			JunctionList[NewLoc].AddTrain(Integer.valueOf(TrainID));
		}
	}
	
	protected void IncrementTurn()
	{
		this.TurnCounter++;
	}
