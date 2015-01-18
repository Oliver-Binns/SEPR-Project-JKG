package com.SEPR.game;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Player {
	//INSTANCE CONSTANTS
	private final int PLAYER_ID;
	private final int HOME_STATION_ID;
	
	//INSTANCE VARIABLES
	private ArrayList<Train> playerTrains;
	private int score;
	private int wealth;
	
	//CONSTRUCTOR - SET ALL PARAMETERS FOR OBJECT
	public Player(int playerID, int homeStationID) {
		PLAYER_ID = playerID;
		HOME_STATION_ID = homeStationID;
		//player has no trains when initialised!
		playerTrains = new ArrayList<Train>();
		//PLAYER HAS NO WEALTH AND NO SCORE AT THE BEGINNING OF THE GAME...
		score = 0;
		wealth = 0;
	}
	
	public ArrayList<Train> getPlayerTrains() {
		return playerTrains;
	}
	
	public void buyNewTrain(int cost, int engineType, int ownerID, int trainID, int faultRate) {
		if(playerTrains.size() < 100) {
			if(wealth >= cost){
				Train newTrain = new Train(engineType, PLAYER_ID, trainID, HOME_STATION_ID, faultRate);
				playerTrains.add(newTrain);
				wealth -= cost;
			}
			else{
				JOptionPane.showMessageDialog(null, "You can't afford this train.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "You can only have 100 trains!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public int getPlayerScore() {
		return score;
	}
	public void increasePlayerScore(int numPoints) {
		score += numPoints;
	}
	
	public int getPlayerWealth() {
		return wealth;
	}
	public void increasePlayerWealth(int numWealth) {
		wealth += numWealth;
	}
	
}
