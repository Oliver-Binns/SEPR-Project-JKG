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
	
	public boolean CheckComplete(int CurrentTurnCount, int TrainID, ArrayList<?> TrainsAtDestStation)
	{
		boolean CompleteFlag = true; //Uses a flag to determine whether the goal is complete, assume true- determine otherwise
		
		//IF THERE WAS A START STATION...
			//IF TRAIN HAS BEEN TO START STATION...
				//IF THERE WAS A TURN LIMIT...	
					CompleteFlag = CompleteFlag && TurnLimitExceeded(CurrentTurnCount, TrainID);
				//ELSE TRAIN HAS BEEN TO START STATION- IF IT IS AT DEST STATION-> GOAL COMPLETE
					//Return True?
				//ENDIF
			//ELSE TRAIN NOT BEEN TO START
				//Return False?
			//ENDIF
		//NO START STATION
			//
		return CompleteFlag; //TODO THIS METHOD STILL NEEDS IMPLEMENTING
	}
	
	private boolean TurnLimitExceeded(int CurrentTurnCount, int TrainID)
	{
		
		/*for(int i = 0; i < this.GoalStarted.size(); i++)
		{
			int TurnCountWhenStarted = this.GoalStarted.get(i)[0];
			if(this.TurnLimit <= (CurrentTurnCount - TurnCountWhenStarted)){
				//Turn Limit has not been exceeded
				return false;
			}
			else{
				//Turn Limit has been exceeded for this train
				this.GoalStarted.remove(i);
			}
		}
		return false;*/
	}
}
