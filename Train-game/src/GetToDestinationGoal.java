
public class GetToDestinationGoal extends Goal {

	//OBJECT CONSTRUCTOR
	public GetToDestinationGoal(int goalID, int destLocID, int noCarriages) {
		super(goalID, destLocID, noCarriages);
		// TODO Auto-generated constructor stub
	}

	//OTHER METHODS
	@Override
	public boolean checkComplete(Train trainX) {
		return Train.getCurrentJunctionID() == getDestLocID();
	}
	
	public boolean reachedDestinationStation(int turnCount, int trainID) {
		//TODO implement this method!
		
		//CHECK IF TRAIN HAS BEEN TO START LOCATION...
			//CHECK
		//ELSE
		return false;
	}

}
