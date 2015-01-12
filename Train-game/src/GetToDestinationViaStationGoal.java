import java.util.ArrayList;

public class GetToDestinationViaStationGoal extends Goal {
	private final int START_LOC_ID;	//read only - once a goal has been instantiated, it can not be changed!
	private final int TURN_LIMIT;	//read only - once a goal has been instantiated, it can not be changed!
	private ArrayList<int[]> goalStarted;	//stores pairs of turn count and train id when trains arrive at the start location!
	private ArrayList<int[]> reachedStation;
	
	//OBJECT CONSTRUCTOR
	public GetToDestinationViaStationGoal(int goalID, int startLocID, int destLocID, int turnLimit, int noCarriages) {
		super(goalID, destLocID, noCarriages);
		
		this.START_LOC_ID = startLocID;
		this.TURN_LIMIT = turnLimit; //SET TO 0 IF NO LIMIT
		this.goalStarted = new ArrayList<int[]>();
	}

	//ACCESSORS & MUTATORS
	public int getStartLocID() {	//This needs to be public as we need to be able to set a listener for trains arriving at the start loc id
		return START_LOC_ID;
	}
	public int getTurnLimit() {	//subclass needs to access the noCarriages
		return TURN_LIMIT;
	}
	
	//OTHER METHODS
	@Override
	public boolean checkComplete(ArrayList trainsList) {	//CHECKS COMPLETE FOR A PARTICULAR PLAYER BY ITERATING
		int carriages = 0;
		for(int i = 0; i < trainsList.size(); i++){	//RUN THROUGH LIST OF TRAINS AND CHECK IF NO CARRIAGES IS SUFFICIENT...
			for(int j = 0; j < reachedStation.size(); j++){
				//nested 'for' is inefficient :(
				int [] pair = reachedStation.get(j);
				if(trainsList.get(i) == pair[0]){
					carriages += pair[1];
				}
			}
		}
		return carriages >= this.getNoCarriages();
	}
	
	public void reachedDestinationStation(int turnCount, int trainID, int noCarriages) {	//NEED TO SET A LISTENER FOR WHEN A TRAIN ARRIVES AT THE DESTINATION LOCATION!
		//CHECK IF TRAIN HAS BEEN TO START LOCATION...
		for(int i = 0; i < this.goalStarted.size(); i++){
			int [] pair = this.goalStarted.get(i);
			if(trainID == pair[1]){
				this.goalStarted.remove(i); //remove item so this train can't leave and come back again without returning to the start location!
				if(this.getTurnLimit() >= (turnCount - pair[0])){
					int [] newPair = new int[]{trainID, noCarriages};
					this.reachedStation.add(newPair);
				}
			}
		}
			//CHECK IF TIME IS UNDER LIMIT
				//ADD TRAIN ID & CARRIAGES TO LIST OF COMPLETED TRAINS
				
	}
	public void goalStartedForTrainX(int turnCount, int trainID) {	//NEED TO SET AN EVENT LISTENER FOR WHEN A TRAIN ARRIVES AT THE START LOCATION!
		int [] pair = new int[]{turnCount, trainID};
		this.goalStarted.add(pair);
	}
	
	//maybe make a clean-up function that removes any trains from the goalStarted list that have run out of time to complete?
}
