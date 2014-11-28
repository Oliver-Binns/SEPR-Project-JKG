
public class GetToDestinationGoal extends Goal {

	public GetToDestinationGoal(int GoalID, int DestLocID, int NoCarriages) {
		super(GoalID, DestLocID, NoCarriages);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean CheckComplete(Train TrainX) {
		// TODO Auto-generated method stub
		return Train.currentJunction == DestLocID;
	}

}
