import java.util.ArrayList;

public abstract class Goal
{
	int GoalID;
	int DestLocID;
	int NoCarriages;
	ArrayList<int[]> GoalStarted;
	//ArrayList<Train> TrainList;
	
	public Goal (int GoalID, int DestLocID, int NoCarriages)
	{
		this.GoalID = GoalID;
		this.DestLocID = DestLocID;
		this.NoCarriages = NoCarriages; //SET TO 0 IF NO CONSTRAINT
		this.GoalStarted = new ArrayList<int[]>();
		//this.TrainList = new ArrayList<Train>();
	}
	
	public int GetID()
	{
		return this.GoalID;
	}
	
	public void GoalStartedForTrainX(int TurnCount, int TrainID)
	{
		int [] pair = new int[]{TurnCount, TrainID};
		this.GoalStarted.add(pair);
	}
	public abstract boolean CheckComplete();
}
	
	/*public void GoalStartedForTrainX(int TurnCount, Train TrainX)
	{
		this.TrainList.add(TrainX);
		int flag1 = 0;
		int[] triple = new int[]{TrainX.TrainID, TurnCount, flag1};
		this.GoalStarted.add(triple);
	}
	
	public int GetID()
	{
		return this.GoalID;
	}
	
	public int TrainBeenToStart(Train TrainX) 
	{
		for (int i; i < this.GoalStarted.size(); i++ )
		{
			if (this.GoalStarted.get(i)[0] == TrainX.TrainID)
			{
				if (TrainX.CurrentJunction == this.StartLoc)
				{
					this.GoalStarted.get(i)[2] = 1				
				}					
			}
		}
		return this.GoalStarted.get(i)[2];
	}
			
	public boolean CheckComplete(int CurrentTurnCount, Train TrainX) // ArrayList<?> TrainsAtDestStation
	//can display more info if needed, than just False, if needed <Train has not yet reached starting place, Train has not attempted this goal, turn limit exceeded>
	{
		if (this.TrainList.contains(TrainX)== false)
		{
			return false; 
			//TrainX Object Has Not Taken This Goal
		}
		
		if (this.TurnLimitExceeded) //Train has exceeded Turn limit
		{
			return false 
			//and goal deleted 
		}
		
		if (this.StartLoc != -1) //If a start location is provided 
		{
			if (this.TrainBeenToStart(TrainX) == 0) //train has not yet been to start location => flag1 = 0
			{
				return false 
						//train hasn't yet completed the goal
			}
		}
		//train has already been to start location or the start location is not provided & is now at final destination
		if (TrainX.CurrentJunction== this.DestLoc) 
		{
			return true 
		}		
	}
	
	private boolean TurnLimitExceeded(int CurrentTurnCount, Train TrainX) 
	//Combining case of if Turn limit is not privded in this. If needed, can create separate method.
	{
		if (this.TurnLimit = -1)
		{
			return False; 
			//TurnLimit Wasn't Provided So Can't Be Exceeded for any of the trains
		}
		
		for (int i = 0, i < this.GoalStarted.size(), i++ )
		{
			int TurnCountWhenStarted = this.GoalStarted.get(i)[1];
			
			if ( (CurrentTurnCount - TurnCountWhenStarted) <= this.TurnLimit)
			{
				return false; 
				//Turn Limit has not been exceeded for this train
			}
			else			
			{
			this.GoalStarted.remove(i);	
			return True;
			}
		}
}*/

//	boolean CompleteFlag = true ; //Uses a flag to determine whether the goal is complete, assume true- determine otherwise

