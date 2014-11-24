public class Goal
{
	Junction StartLoc;
	Junction DestLoc;
	int TurnCount;
	int TurnLimit;
	int NoCarriages;
	int DestCountry; //should this be a class Country?
	
	public Goal (Junction StartLoc, Junction DestLoc, int TurnLimit, int NoCarriages, int DestCountry)
	{
		this.TurnCount = 0;
		this.StartLoc = StartLoc;
		this.DestLoc = DestLoc;
		this.TurnLimit = TurnLimit;
		this.NoCarriages = NoCarriages;
		this.DestCountry = DestCountry;
	}
	
	public void TurnIncrement()
	{
		this.TurnCount++;
	}
	
	public boolean CheckComplete(Player player)
	{
		return false; //TODO THIS METHOD STILL NEEDS IMPLEMENTING
	}
}
