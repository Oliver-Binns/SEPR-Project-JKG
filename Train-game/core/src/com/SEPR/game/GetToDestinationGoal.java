package com.SEPR.game;

import java.util.ArrayList;

public class GetToDestinationGoal extends Goal {

	//OBJECT CONSTRUCTOR
	public GetToDestinationGoal(int goalID, int destLocID, int noCarriages, int rewardMoney, int rewardPoints) {
		super(goalID, destLocID, noCarriages, rewardMoney, rewardPoints);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean CheckComplete(ArrayList<Train> trainsList) { //just checks if train is at location - no carriage based goals for this hand in!
		boolean flag = false;
		for(int i = 0; i < trainsList.size(); i++){
			flag = flag || trainsList.get(i).getCurrentJunction() == getDestLocID();
		}
		return flag;
	}
}
