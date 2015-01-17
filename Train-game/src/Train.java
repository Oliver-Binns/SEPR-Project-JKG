public class Train {
	//INSTANCE CONSTANTS
	//ENGINE_TYPE- 1 -Electric, 2 -Diesel, 3 -Flying
	private final int ENGINE_TYPE;
	
	private final int OWNER_ID;
	private final int TRAIN_ID;
	
	//INSTANCE VARIABLES
	private int currentJunction;
	private int faultRate;
	private boolean faulty;
	private int numCarriages;
	private int tier;
	
	//CONSTRUCTOR - SET ALL PARAMETERS FOR OBJECT
	public Train(int engineType, int ownerID, int trainID, int ownerHomeStation, int faultRate){
		ENGINE_TYPE = engineType;
		OWNER_ID = ownerID;
		TRAIN_ID = trainID;
		currentJunction = ownerHomeStation; //trains start at the owner's home station
		this.faultRate = faultRate;
		isFaulty = false;
		numCarriages = 1; //all trains start with 1 carriage!
		numTier = 1; //all trains start at tier 1!
		
	}
	
	//ACCESSORS
	public int getTrainID(){
		return TRAIN_ID;
	}
	public int getEngineType(){
		return ENGINE_TYPE;
	}
	public int getOwnerID(){
		return OWNER_ID;
	}
	//accessor for current junction
	public int getCurrentJunction(){
		return currentJunction;
	}
	public int getFaultRate(){
		return faultRate;
	}
	public boolean isFaulty(){
		return faulty;
	}
	public boolean getNumCarriages(){
		return numCarriages;
	}
	public boolean getTier(){
		return tier;
	}
	public void getSpeed(){
		if(ENGINE_TYPE == 1){
			return (tier + 1);
		}
		else{
			return 2;
		}
	}
	
	//move train from one junction to another.
	public void moveTrain(int destinationID){
		currentJunction = destinationID;
	}
	public void upgradeTrain(){
		if(tier <= 3){ //tier can't be higher than 3!
			tier++;
		}
		else{
			JOptionPane.showMessageDialog(null, "Trains have a maximum tier of 3!", "InfoBox: " + "Sorry!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void breakTrain(){
		faulty = true;
	}
	public void repairTrain(){
		faulty = false;
	}
	
}
