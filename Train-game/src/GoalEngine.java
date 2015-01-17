import java.util.ArrayList;

public class GoalEngine {
	private GetToDestinationGoal[] currentGoals;
	//OBJECT CONSTRUCTOR
	public GoalEngine(){
		currentGoals = new GetToDestinationGoal[3];
		for(int i = 0; i < currentGoals.length; i++){
			currentGoals[i] = newGoal();
		}
	}
	
	public String[] getGoalDescriptors(){
		String[] goalDescriptors = new String[currentGoals.length];
		for(int i = 0; i < currentGoals.length; i++){
			goalDescriptors[i] = getGoalDescriptor(i);
		}
		return goalDescriptors;
	}
	
	public String getGoalDescriptor(int i){
		String goalDescriptor = "Goal " + String.valueOf(i) + ": ";
		
		goalDescriptor += "Get to " + getCityName(currentGoals[i].getDestLocID()) + " ";
		if(currentGoals[i].getNumCarriages() > 1){
			goalDescriptor += " with at least " + String.valueOf(currentGoals[i].getNumCarriages()) + " carriages ";
		}
		
		if(currentGoals[i] instanceof GetToDestinationGoal){
			//description for get to destination goal
		}
		else{
			goalDescriptor += " via " + getCityName(currentGoal[i].startLocID());
			goalDescriptor += " within " + String.valueOf(getTurnLimit());
		}
		goalDescriptor += " for $" + String.valueOf(currentGoals[i].getRewardMoney()) + " and " + String.valueOf(currentGoals[i].getRewardPoints())  + " exp.";
	}
	
	public endTurn(ArrayList player1Trains; ArrayList player2Trains; int goalToDestroy){
		player1Points = 0;
		player1Money = 0;
		player2Points = 0;
		player2Money = 0;
		
		for(int i = 0; i < currentGoals.length; i++){
			Boolean player1 = currentGoals[i].checkComplete(player1Trains); //check complete for player 1
			Boolean player2 = currentGoals[i].checkCompleye(player2Trains); //check complete for player 2
			
			if(player1 && player2){ //if both players complete goal- reward money/points are halved!
				player1Money += currentGoals[i].getRewardMoney() / 2;
				player1Points += currentGoals[i].getRewardPoints() / 2;
				player2Money += currentGoals[i].getRewardMoney() / 2;
				player2Points += currentGoals[i].getRewardPoints() / 2;
			}
			else if(player1){
				player1Money += currentGoals[i].getRewardMoney();
				player1Points += currentGoals[i].getRewardPoints();
			}
			else if(player2){
				player2Money += currentGoals[i].getRewardMoney();
				player2Points += currentGoals[i].getRewardPoints();
			}
			
			if(player1 || player2){ //GOAL COMPLETE- Destroy Goal
				destroyGoal(i);
			}
		}
	}
	
	public void destroyGoal(int goalID){
		currentGoals[goalID] = newGoal(goalID);
	}
	
	private GetToDestinationGoal newGoal(int goalID){
		GetToDestinationGoal createdGoal;
		
		int destLoc = random(0, 24);
		createdGoal = new GetToDestinationGoal(goalID, destLoc, 0); //no carriage-based goals for this hand-in
		
		return createdGoal;
		
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