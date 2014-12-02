import java.util.ArrayList;

public class GetToDestinationViaStationGoal extends Goal {
	private final int START_LOC_ID;	//read only - once a goal has been instantiated, it can not be changed!
	private final int TURN_LIMIT;	//read only - once a goal has been instantiated, it can not be changed!
	private ArrayList<int[]> goalStarted;	//stores pairs of turn count and train id when trains arrive at the start location!
	
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
	public boolean checkComplete(int turnCount) {
		// TODO Auto-generated method stub
		boolean complete = false;
		//if(TurnLimit < )
		return complete;
	}
	
	public void goalStartedForTrainX(int turnCount, int trainID) {	//NEED TO SET AN EVENT LISTENER FOR WHEN A TRAIN ARRIVES AT THE START LOCATION!
		int [] pair = new int[]{turnCount, trainID};
		this.goalStarted.add(pair);
	}

}
