public abstract class Goal
{
	private final int GoalID;		//read only - once a goal has been instantiated, it can not be changed!
	private final int DestLocID;	//read only - once a goal has been instantiated, it can not be changed!
	private final int NoCarriages;	//read only - once a goal has been instantiated, it can not be changed!
	
	//OBJECT CONSTRUCTOR
	public Goal (int GoalID, int DestLocID, int NoCarriages)
	{
		this.GoalID = GoalID;
		this.DestLocID = DestLocID;
		this.NoCarriages = NoCarriages;	//SET TO 0 IF NO CONSTRAINT
	}
	
	//ACCESSORS & MUTATORS
	public int getGoalID()	//should be able to access the ID from anywhere
	{
		return GoalID;
	}
	protected int getNoCarriages() {	//subclass needs to access the noCarriages
		return NoCarriages;
	}
	protected int getDestLocID() {	//subclass needs to know our destination id
		return DestLocID;
	}

	//OTHER METHODS
	public abstract boolean CheckComplete();
}