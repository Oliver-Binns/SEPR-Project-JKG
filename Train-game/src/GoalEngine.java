import java.util.ArrayList;

public class GoalEngine {
	private ArrayList<Goal> currentGoals;
	
	//OBJECT CONSTRUCTOR
	public GoalEngine(){
		currentGoals = new ArrayList<Goal>;
		for(int i = 0; i < 3; i++){
			currentGoals.add(newGoal());
		}
	}
	
	public String[] getGoalDescriptors(){
		String[] goalDescriptors = new String[currentGoals.size()];
		for(int i = 0; i < currentGoals.size(); i++){
			goalDescriptors[i] = getGoalDescriptor(i);
		}
		return goalDescriptors;
	}
	
	private String getGoalDescriptor(int i){
		String goalDescriptor = "Goal " + String.valueOf(i) + ": ";
		
		goalDescriptor += "Get to " + getCityName(currentGoals[i].getDestLocID()) + " ";
		if(currentGoals[i].getNumCarriages() > 1){
			goalDescriptor += "with at least " + String.valueOf(currentGoals[i].getNumCarriages()) + " carriages ";
		}
		
		if(currentGoals[i] instanceof GetToDestinationViaStationGoal){
			goalDescriptor += "via " + getCityName(currentGoals.get(i).startLocID());
			goalDescriptor += "within " + String.valueOf(getTurnLimit()) + " turns ";
		}
		goalDescriptor += "for $" + String.valueOf(currentGoals.get(i).getRewardMoney()) + " and " + String.valueOf(currentGoals.get(i).getRewardPoints())  + " exp.";
	}
	
	public endTurn(Player[] players, int goalToDestroy){
		int[] playerPoints = new Player[players.length];
		int[] playerMoney = new Player[players.length];
		for(int i = 0; i < players.length; i++){
			playerMoney[i] = 0;
			playerPoints[i]= 0;
		}
		
		for(int i = 0; i < currentGoals.size(); i++){
			Boolean[] completeForPlayer = new Boolean[players.length];
			int numberPlayersCompleted = 0;
			for(int j = 0; j < players.length; j++){
				if(currentGoals.get(i).checkComplete(players[j])){
					completeForPlayer[j] = true;
					numberPlayersCompleted++;
				}
				else{
					completeForPlayer[j] = false;
				}
			}
			
			for(int j = 0; j < players.length; j++){
				if(completeForPlayer[j]){
					players[j].increasePlayerScore(currentGoals.get(i).getRewardPoints() / numberPlayersCompleted);
					players[j].increasePlayerWealth(currentGoals.get(i).getRewardMoney() / numberPlayersCompleted);
				}
			}
			
			if(numberPlayersCompleted > 0){ //GOAL COMPLETE- Destroy Goal
				destroyGoal(i);
			}
		}
		
	}
	
	public void destroyGoal(int goalID){
		currentGoals.set(goalID, newGoal(goalID));
	}
	
	private Goal newGoal(int goalID){
		int r = random(0, 2);
		
		int destLoc = random(0, 24);
		int rewardMoney = random(1000, 3000);
		int rewardPoints = random(1000, 3000);
		
		
		if(r == 0){
			int startLocID = random(0, 24);
			GetToDestinationViaStationGoal createdGoal = new GetToDestinationViaStationGoal(goalID, startLocID, destLocID, 0, 0, rewardMoney, rewardPoints);
		}
		else{
			GetToDestinationGoal createdGoal = new GetToDestinationGoal(goalID, destLoc, 0, rewardMoney, rewardPoints); //no carriage-based goals for this hand-in
			return createdGoal;
		}
	}
	
	private String getCityName(int junctionID){
		switch(junctionID){
			case 0:
				return "Lisbon";
				break;
			case 1:
				return "Porto";
				break;
			case 2:
				return "Madrid";
				break;
			case 3:
				return "Dublin";
				break;
			case 4:
				return "London";
				break;
			case 5:
				return "Paris";
				break;
			case 6:
				return "Amsterdam";
				break;
			case 7:
				return "Geneva";
				break;
			case 8:
				return "Stuttgart";
				break;
			case 9:
				return "Oslo";
				break;
			case 10:
				return "Rome";
				break;
			case 11:
				return "Berlin";
				break;
			case 12:
				return "Prague";
				break;
			case 13:
				return "Stockholm";
				break;
			case 14:
				return "Zagreb";
				break;
			case 15:
				return "Warsaw";
				break;
			case 16:
				return "Budapest";
				break;
			case 17:
				return "Riga";
				break;
			case 18:
				return "Belgrade";
				break;
			case 19:
				return "Lviv";
				break;
			case 20:
				return "Athens";
				break;
			case 21:
				return "Bucharest";
				break;
			case 22:
				return "Kiev";
				break;
			case 23:
				return "Moscow";
				break;
			case 24:
				return "Istanbul";
				break;
			default:
				throw new IllegalArgumentException("Error- cannot get city name for junction id greater than 24.");
				break;
		}
	}
	private int random(int min, int max){
		randomNum = min + (int)(Math.random()*max);
	}
}