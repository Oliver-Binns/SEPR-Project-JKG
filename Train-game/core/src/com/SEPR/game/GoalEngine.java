package com.SEPR.game;

public class GoalEngine {
	private GetToDestinationGoal[] currentGoals;
	//OBJECT CONSTRUCTOR
	public GoalEngine() {
		currentGoals = new GetToDestinationGoal[3];
		for(int i = 0; i < currentGoals.length; i++) {
			currentGoals[i] = newGoal(i);
		}
	}
	
	public String[] getGoalDescriptors() {
		String[] goalDescriptors = new String[currentGoals.length];
		for(int i = 0; i < currentGoals.length; i++){
			goalDescriptors[i] = getGoalDescriptor(i);
		}
		return goalDescriptors;
	}
	
	private String getGoalDescriptor(int i) {
		String goalDescriptor = "Goal " + String.valueOf(i) + ": ";
		
		goalDescriptor += "Get to " + getCityName(currentGoals[i].getDestLocID()) + " ";
		if(currentGoals[i].getNumCarriages() > 1) {
			goalDescriptor += "with at least " + String.valueOf(currentGoals[i].getNumCarriages()) + " carriages ";
		}
		
		goalDescriptor += "for $" + String.valueOf(currentGoals[i].getRewardMoney()) + " and " + String.valueOf(currentGoals[i].getRewardPoints())  + " exp.";
		return goalDescriptor;
	}
	
	public void endTurn(Player[] players, int goalToDestroy) {
		int[] playerPoints = new int[players.length];
		int[] playerMoney = new int[players.length];
		for(int i = 0; i < players.length; i++) {
			playerMoney[i] = 0;
			playerPoints[i]= 0;
		}
		
		for(int i = 0; i < currentGoals.length; i++) {
			Boolean[] completeForPlayer = new Boolean[players.length];
			int numberPlayersCompleted = 0;
			for(int j = 0; j < players.length; j++) {
				if(currentGoals[i].CheckComplete(players[j].getPlayerTrains())) {
					completeForPlayer[j] = true;
					numberPlayersCompleted++;
				}
				else{
					completeForPlayer[j] = false;
				}
			}
			
			for(int j = 0; j < players.length; j++) {
				if(completeForPlayer[j]) {
					players[j].increasePlayerScore(currentGoals[i].getRewardPoints() / numberPlayersCompleted);
					players[j].increasePlayerWealth(currentGoals[i].getRewardMoney() / numberPlayersCompleted);
				}
			}
			
			if(numberPlayersCompleted > 0) { //GOAL COMPLETE- Destroy Goal
				destroyGoal(i);
			}
		}
		
	}
	
	public void destroyGoal(int goalID) {
		currentGoals[goalID] = newGoal(goalID);
	}
	
	private GetToDestinationGoal newGoal(int goalID) {
		GetToDestinationGoal createdGoal;
		
		int destLoc = random(0, 24);
		
		int rewardMoney = random(1000, 3000);
		int rewardPoints = random(1000, 3000);
		
		createdGoal = new GetToDestinationGoal(goalID, destLoc, 0, rewardMoney, rewardPoints); //no carriage-based goals for this hand-in
		
		return createdGoal;
		
	}
	
	private String getCityName(int junctionID) {
		switch(junctionID){
			case 0:
				return "Lisbon";
			case 1:
				return "Porto";
			case 2:
				return "Madrid";
			case 3:
				return "Dublin";
			case 4:
				return "London";
			case 5:
				return "Paris";
			case 6:
				return "Amsterdam";
			case 7:
				return "Geneva";
			case 8:
				return "Stuttgart";
			case 9:
				return "Oslo";
			case 10:
				return "Rome";
			case 11:
				return "Berlin";
			case 12:
				return "Prague";
			case 13:
				return "Stockholm";
			case 14:
				return "Zagreb";
			case 15:
				return "Warsaw";
			case 16:
				return "Budapest";
			case 17:
				return "Riga";
			case 18:
				return "Belgrade";
			case 19:
				return "Lviv";
			case 20:
				return "Athens";
			case 21:
				return "Bucharest";
			case 22:
				return "Kiev";
			case 23:
				return "Moscow";
			case 24:
				return "Istanbul";
			default:
				throw new IllegalArgumentException("Error- cannot get city name for junction id greater than 24.");
		}
	}
	private int random(int min, int max) {
		return min + (int)(Math.random()*max);
	}
}
