package com.SEPR.game;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.badlogic.gdx.Game;

/*
MapGraph is the main class, it represents the map structure and is what the game engine will be interacting with
*/

public class MapGraph extends Game
{
	int CurrentPlayer;	//The current player number, used to represent who's turn it is
	int[] PlayerList;	//The list of players that are playing
	int TurnCounter;	//The number of turns that have passed since the beginning of the game
	boolean[][] MapArray;	//A 2D array representing all of the connections between each junction
	ArrayList<Integer> TrainList;	//An arraylist of trains that are currently active on the map
	Junction[] JunctionList;	//A list of junctions contained in the map (includes stations and checkpoints)

	//Constructor generates 2D MapArray based on given size
	public MapGraph(int size)
	{
		String FilePath = "map.txt";
		this.TurnCounter = 0;
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

				while(!s.startsWith("/")) {
					junctionLine = s.split(delims);
					connectionList = new int[junctionLine.length];

					for(int i=0; i<junctionLine.length; i++) {
						connectionList[i] = Integer.parseInt(junctionLine[i]);
					}

					jcl.add(connectionList);

					s = sc.nextLine();
				}

				JCL = (int[][])jcl.toArray(new int[0][]);

				if(ID<25) {
					jList.add(new Station(ID, JCL));
				} else if(ID>24 && ID<37) {
					jList.add(new Junction(ID, JCL));
				} else {
					jList.add(new Checkpoint(ID, JCL));
				}
			}
			sc.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}

		return (Junction[])jList.toArray(new Junction[0]);
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

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
}
