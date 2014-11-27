package MapGraph;

public class Checkpoint extends Junction
{
	bool IsFaulty;
	String FaultMessage;
	
	public Checkpoint(int ID)
	{
		this(ID, null, null);
	}
	
	public Checkpoint(int ID, int[][] JunctionsConnected, int[] TrainsPresent)
	{
		this.IsFaulty = false;
		this.FaultMessage = "";
		super(ID, JunctionsConnected, TrainsPresent);
	}
	
	protected void RepairFault()
	{
		this.IsFaulty = false;
	}
	
	protected void CauseFault(String Message)
	{
		this.IsFaulty = true;
		this.FaultMessage = Message;
	}
}
