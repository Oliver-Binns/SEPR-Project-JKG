import java.util.ArrayList;

import com.sun.tools.javac.code.Attribute.Array;

public class Goal
{
	Junction StartLoc;
	Junction DestLoc;
	ArrayList<int[]> GoalStarted;
	int TurnLimit;
	int NoCarriages;
	int GoalID;
	
	public Goal (int GoalID, Junction StartLoc, Junction DestLoc, int TurnLimit, int NoCarriages)
	{
		this.GoalID = GoalID;
		this.StartLoc = StartLoc;
		this.DestLoc = DestLoc;
		this.TurnLimit = TurnLimit; //SET TO 0 IF NO LIMIT
		this.NoCarriages = NoCarriages;
		this.GoalStarted = new ArrayList<int[]>();
	}
	
	public void GoalStartedForTrain(int TurnCount, int TrainID){
		int[] pair = new int[]{TurnCount, TrainID};
		this.GoalStarted.add(pair);
	}
	
	public int GetID()
	{
		return this.GoalID;
	}
	
	public boolean CheckComplete(int CurrentTurnCount, int Player)
	{
		boolean CompleteFlag = true; //Uses a flag to determine whether the goal is complete, assume true- determine otherwise
		
		for(int i = 0; i < this.GoalStarted.size(); i++)
		{
			int TurnCount = this.GoalStarted.get(i)[0];
			if(this.TurnCount > this.TurnLimit){ //Goal has not been completed if the turn count has exceeded the limit
				CompleteFlag = false;
			}
		}
		
		return CompleteFlag; //TODO THIS METHOD STILL NEEDS IMPLEMENTING
	}
}
