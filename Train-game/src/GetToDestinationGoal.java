import java.util.ArrayList;

public class GetToDestinationGoal extends Goal {

	//OBJECT CONSTRUCTOR
	public GetToDestinationGoal(int goalID, int destLocID, int noCarriages) {
		super(goalID, destLocID, noCarriages);
		// TODO Auto-generated constructor stub
	}

	//OTHER METHODS
	@Override
	public boolean checkComplete(ArrayList trainsList) {
		flag = false;
		for(int i = 0; i < trainsList.size(); i++){
			flag = flag || trainsList.get(i).getCurrentJunctionID() == getDestLocID();
		}
		return flag;
	}
}
