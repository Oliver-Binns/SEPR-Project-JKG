package com.SEPR.game;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.badlogic.gdx.Game;

/*
MapGraph is the main class, it represents the map structure and is what the game engine will be interacting with
*/

public class MapGraph extends Game {
	boolean[][] mapArray;	//A 2D array representing all of the connections between each junction
	ArrayList<Integer> trainList;	//An arraylist of trains that are currently active on the map
	Junction[] junctionList;	//A list of junctions contained in the map (includes stations and checkpoints)

	//Constructor generates 2D mapArray based on given size
	public MapGraph(int size) {
		String filePath = "map.txt";
		this.mapArray = new boolean[size][size];
		this.trainList = new ArrayList<Integer>();
		this.junctionList = this.GetJunctionList(filePath);
		this.CreateMapArray();
	}

	//Takes the junctionList and generates a 2D mapArray from their respective JunctionConnectedList
	protected void CreateMapArray() {
		for(Junction j : this.junctionList) {
			int index = j.GetID();
			this.mapArray[index][index] = true;
			for(int connection : j.GetConnectedJunctions()) {
				int next = j.FindNext(connection);

				this.mapArray[index][next] = true;
				this.mapArray[next][index] = true;
			}
		}
	}

	//Initializes all of the junction objects and links them together for the map.
	private Junction[] GetJunctionList(String file) {
		int ID;
		int[] connectionList;
		int[][] JCL;
		File map = new File(file);
		ArrayList<Junction> jList = new ArrayList<Junction>();

		//This try block reads junction information from a file (/dat/map) and instantiates each junction, it returns a list of junctions that it contains
		try {
			String delims = ",";
			Scanner sc = new Scanner(map);

			while(sc.hasNextLine()) {
				String s;
				String[] junctionLine;
				ArrayList<int[]> jcl = new ArrayList<int[]>();

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
	protected int MoveTrain(int trainID, int location, int destination) {
		Junction junctLocation = junctionList[location];
		int newLoc = -1;
		
		if(junctLocation.IsPresent(Integer.valueOf(trainID))) {
			newLoc = junctLocation.FindNext(destination);
			if(newLoc == -1) {
				return newLoc;
			}
			junctLocation.RemoveTrain(Integer.valueOf(trainID));
			junctionList[newLoc].AddTrain(Integer.valueOf(trainID));
		} else {
			return newLoc;
		}
		
		return newLoc;
	}
	
	/*protected boolean MoveTrain(int trainID, int location, int destination) {
		Junction junctLocation = junctionList[location];

		if(junctLocation.IsPresent(Integer.valueOf(trainID))) {
			int newLoc = junctLocation.FindNext(destination);
			if(newLoc == -1) {
				return false;
			}
			junctLocation.RemoveTrain(Integer.valueOf(trainID));
			junctionList[newLoc].AddTrain(Integer.valueOf(trainID));
		} else {
			return false;
		}
		
		return true;
	}
	*/

	//Adds the Train to the specified Junction
	protected void AddTrain(int trainID, int location) {
		this.trainList.add(Integer.valueOf(trainID));
		this.junctionList[location].AddTrain(trainID);
	}

	//Removes the Train from the specified Junction
	protected void RemoveTrain(int trainID, int location) {
		this.trainList.remove(Integer.valueOf(trainID));
		this.junctionList[location].RemoveTrain(trainID);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
}
