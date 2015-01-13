package MapGraph;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MapGraph
{
	int CurrentPlayer;
	int[] PlayerList;
	int TurnCounter;
	ArrayList<Goal> ActiveGoalList;
	boolean[][] MapArray;
	ArrayList<Integer> TrainList;
	Junction[] JunctionList;

	//Constructor generates 2D MapArray based on given size
	public MapGraph(int size)
	{
		String FilePath = "../dat/map";
		this.CurrentPlayer = 1;
		this.PlayerList = new int[] {1,2};
		this.TurnCounter = 0;
		this.ActiveGoalList = new ArrayList<Goal>();
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
				int next = j.FindNext(connection);

				this.MapArray[index][next] = true;
				this.MapArray[next][index] = true;
			}
		}
	}

	//Initializes all of the junction objects and links them together for the map.
	private Junction[] GetJunctionList(String File) {
		int ID;
		int[] connectionList;
		int[][] JCL;
		ArrayList<int[]> jcl = new ArrayList<int[]>();
		ArrayList<Integer> TL;
		File map = new File(File);
		ArrayList<Junction> jList = new ArrayList<Junction>();

		try {
			String delims = ",";
			Scanner sc = new Scanner(map);

			while(sc.hasNextLine()) {
				String s;
				String[] junctionLine;

				ID = Integer.parseInt(sc.nextLine());

				s = sc.nextLine();

				while(!s.equals("/")) {
					junctionLine = sc.nextLine().split(delims);
					connectionList = new int[junctionLine.length];

					for(int i=0; i<junctionLine.length; i++) {
						connectionList[i] = Integer.parseInt(junctionLine[i]);
					}

					jcl.add(connectionList);

					s = sc.nextLine();
				}

				JCL = (int[][])jcl.toArray();

				jList.add(new Junction(ID, JCL));
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}

		return (Junction[])jList.toArray();
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
