package MapGraph;
import java.util.ArrayList;


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
		JunctionConstructor J = new JunctionConstructor();
		this.CurrentPlayer = 1;
		this.PlayerList = [1,2];
		this.TurnCounter = 0;
		this.ActiveGoalList = new Goal[3];
		this.MapArray = new int[size][size];
		this.TrainList = new ArrayList<Integer>();
		this.JunctionList = J.GetJunctionList;
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
		Junction JunctLocation = JunctionList[Location];
		
		if(JunctLocation.IsPresent(Integer.valueOf(TrainID)))
		{
			int NewLoc = JunctLocation.FindNext(Destination);
			JunctLocation.RemoveTrain(Integer.valueOf(TrainID));
			JunctionList[NewLoc].AddTrain(Integer.valueOf(TrainID));
		}
	}
	
	protected void IncrementTurn()
	{
		this.TurnCounter++;
	}

	protected void AddGoal(Goal goal)
	{
		this.ActiveGoalList.add(goal);
	}
	
	protected void RemoveGoal(Goal goal)
	{
		this.ActiveGoalList.remove(goal);
	}
	
	protected void AddTrain(int TrainID, int Location)
	{
		this.TrainList.add(Integer.valueOf(TrainID));
		this.JunctionList[Location].AddTrain(TrainID);
	}
	
	protected void RemoveTrain(int TrainID, int Location)
	{
		this.TrainList.remove(Integer.valueOf(TrainID));
		this.JunctionList[Location].RemoveTrain(TrainID);
	}
	
	protected void ChangePlayer()
	{
		switch(this.CurrentPlayer)
		{
			case 1:
				this.CurrentPlayer++;
				break;
			case 2:
				this.CurrentPlayer--;
				break;
		}
	}
}