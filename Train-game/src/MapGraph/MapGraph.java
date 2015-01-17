package MapGraph;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
MapGraph is the main class, it represents the map structure and is what the game engine will be interacting with
*/

public class MapGraph
{
	int CurrentPlayer;	//The current player number, used to represent who's turn it is
	int[] PlayerList;	//The list of players that are playing
	int TurnCounter;	//The number of turns that have passed since the beginning of the game
	ArrayList<Goal> ActiveGoalList;	//The list of goals (max 3) that are available to the players at any point
	boolean[][] MapArray;	//A 2D array representing all of the connections between each junction
	ArrayList<Integer> TrainList;	//An arraylist of trains that are currently active on the map
	Junction[] JunctionList;	//A list of junctions contained in the map (includes stations and checkpoints)

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

		//This try block reads junction information from a file (/dat/map) and instantiates each junction, it returns a list of junctions that it contains
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

				if(ID<25) {
					jList.add(new Station(ID, JCL));
				} else if(ID>24 && ID<37) {
					jList.add(new Junction(ID, JCL));
				} else {
					jList.add(new Checkpoint(ID, JCL));
				}
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}

		return (Junction[])jList.toArray();
	}

	//Moves the Train from a specified location to a specified destination
	protected boolean MoveTrain(int TrainID, int Location, int Destination)
	{
		Junction JunctLocation = JunctionList[Location];

		if(JunctLocation.IsPresent(Integer.valueOf(TrainID)))
		{
			int NewLoc = JunctLocation.FindNext(Destination);
			if(NewLoc == -1) {
				return false;
			}
			JunctLocation.RemoveTrain(Integer.valueOf(TrainID));
			JunctionList[NewLoc].AddTrain(Integer.valueOf(TrainID));
		} else {
			return false;
		}
		
		return true;
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
