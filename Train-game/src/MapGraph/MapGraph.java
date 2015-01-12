package MapGraph;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.scanner;


public class MapGraph
{
	int CurrentPlayer;
	int[] PlayerList;
	int TurnCounter;
	Goal[] ActiveGoalList;
	int[][] MapArray;
	ArrayList<Integer> TrainList;
	Junction[] JunctionList;
	
	//Constructor generates 2D MapArray based on given size
	public MapGraph(int size)
	{
		String FilePath = "map.txt";
		this.CurrentPlayer = 1;
		this.PlayerList = [1,2];
		this.TurnCounter = 0;
		this.ActiveGoalList = new Goal[3];
		this.MapArray = new boolean[size][size];
		this.TrainList = new ArrayList<Integer>();
		this.JunctionList = this.GetJunctionList(FilePath);
		this.CreateMapArray();
	}
	
	//Takes the JunctionList and generates a 2D MapArray from their respective JunctionConnectedList
	protected void CreateMapArray()
	{
		for(Junction j : this.JunctionList)
		{
			int index = j.GetID();
			this.MapArray[index][index] = true;
			for(int connection : j.GetConnectedJunctions())
			{
				int Next = j.FindNext(connection);
				
				this.MapArray[index][next] = true;
				this.MapArray[next][index] = true;
			}
		}
	}

	private ArrayList<Junction> GetJunctionList(String File) {
		File map = new File(File);
		
		try {
			Scanner sc = new Scanner(map);
			
			while(sc.hasNextLine()) {
				String i = sc.nextLine();
				
			}
		}
	}

	//Moves the Train from a specified location to a specified destination
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
	
	//Increments the turn counter
	protected void IncrementTurn()
	{
		this.TurnCounter++;
	}
	
	//Adds the Goal to the GoalList
	protected void AddGoal(Goal goal)
	{
		this.ActiveGoalList.add(goal);
	}
	
	//Removes the Goal from the GoalList
	protected void RemoveGoal(Goal goal)
	{
		this.ActiveGoalList.remove(goal);
	}
	
	//Adds the Train to the specified Junction
	protected void AddTrain(int TrainID, int Location)
	{
		this.TrainList.add(Integer.valueOf(TrainID));
		this.JunctionList[Location].AddTrain(TrainID);
	}
	
	//Removes the Train from the specified Junction
	protected void RemoveTrain(int TrainID, int Location)
	{
		this.TrainList.remove(Integer.valueOf(TrainID));
		this.JunctionList[Location].RemoveTrain(TrainID);
	}
	
	//Changes CurrentPlayer to indicate a new turn.
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
