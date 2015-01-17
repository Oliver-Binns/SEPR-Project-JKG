public abstract class Goal
{
	private final int GOAL_ID;		//read only - once a goal has been instantiated, it can not be changed!
	private final int DEST_LOC_ID;	//read only - once a goal has been instantiated, it can not be changed!
	private final int NO_CARRIAGES;	//read only - once a goal has been instantiated, it can not be changed!
	private final int REWARD_MONEY;
	private final int REWARD_POINTS;
	
	//OBJECT CONSTRUCTOR
	public Goal (int goalID, int destLocID, int noCarriages, int rewardMoney, int rewardPoints) {
		REWARD_MONEY = rewardMoney;
		REWARD_POINTS = rewardPoints;
		GOAL_ID = goalID;
		DEST_LOC_ID = destLocID;
		NO_CARRIAGES = noCarriages;	//SET TO 0 IF NO CONSTRAINT
	}
	
	//ACCESSORS & MUTATORS
	public int getGoalID() {			//should be able to access the ID from anywhere
		return GOAL_ID;
	}
	protected int getNumCarriages() {	//subclass needs to access the noCarriages
		return NO_CARRIAGES;
	}
	protected int getDestLocID() {		//subclass needs to know our destination id
		return DEST_LOC_ID;
	}
	public getRewardMoney(){
		return REWARD_MONEY;
	}
	public getRewardPoints(){
		return REWARD_POINTS;
	}

	//OTHER METHODS
	public abstract boolean CheckComplete();
}