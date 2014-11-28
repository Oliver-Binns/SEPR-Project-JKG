
public class GetToDestinationViaStationGoal extends Goal {
	int StartLocID;
	int TurnLimit;
	
	
	public GetToDestinationViaStationGoal(int GoalID, int StartLocID,
			int DestLocID, int TurnLimit, int NoCarriages) {
		super(GoalID, DestLocID, NoCarriages);
		
		this.StartLocID = StartLocID;
		this.TurnLimit = TurnLimit; //SET TO 0 IF NO LIMIT
	}

	@Override
	public boolean CheckComplete() {
		// TODO Auto-generated method stub

	}

}
