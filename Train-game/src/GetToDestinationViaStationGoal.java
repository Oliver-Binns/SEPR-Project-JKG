import java.util.ArrayList;

public class GetToDestinationViaStationGoal extends Goal {
	private final int StartLocID;	//read only - once a goal has been instantiated, it can not be changed!
	private final int TurnLimit;	//read only - once a goal has been instantiated, it can not be changed!
	private ArrayList<int[]> GoalStarted;	//stores pairs of turn count and train id when trains arrive at the start location!
	
	//OBJECT CONSTRUCTOR
	public GetToDestinationViaStationGoal(int GoalID, int StartLocID,
			int DestLocID, int TurnLimit, int NoCarriages) {
		super(GoalID, DestLocID, NoCarriages);
		
		this.StartLocID = StartLocID;
		this.TurnLimit = TurnLimit; //SET TO 0 IF NO LIMIT
		this.GoalStarted = new ArrayList<int[]>();
	}

	//ACCESSORS & MUTATORS
	public int getStartLocID() {	//This needs to be public as we need to be able to set a listener for trains arriving at the start loc id
		return StartLocID;
	}
	public int getTurnLimit() {	//subclass needs to access the noCarriages
		return TurnLimit;
	}
	protected int getDestLocID() {	//subclass needs to know our destination id
		return DestLocID;
	}
	
	//OTHER METHODS
	@Override
	public boolean CheckComplete(int TurnCount) {
		// TODO Auto-generated method stub
		boolean Complete = true;
		//if(TurnLimit < )
		return Complete;
	}
	
	public void GoalStartedForTrainX(int TurnCount, int TrainID) {	//NEED TO SET AN EVENT LISTENER FOR WHEN A TRAIN ARRIVES AT THE START LOCATION!
		int [] pair = new int[]{TurnCount, TrainID};
		this.GoalStarted.add(pair);
	}

}
