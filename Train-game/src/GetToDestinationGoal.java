
public class GetToDestinationGoal extends Goal {

	//OBJECT CONSTRUCTOR
	public GetToDestinationGoal(int GoalID, int DestLocID, int NoCarriages) {
		super(GoalID, DestLocID, NoCarriages);
		// TODO Auto-generated constructor stub
	}

	//OTHER METHODS
	@Override
	public boolean CheckComplete(Train TrainX) {
		return Train.GetCurrentJunctionID() == getDestLocID();
	}

}
