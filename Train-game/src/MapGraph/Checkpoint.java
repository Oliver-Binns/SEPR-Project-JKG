package MapGraph;

public class Checkpoint extends Junction
{
	boolean IsFaulty;
	String FaultMessage;
	
	//Overloaded constructors for instantiating Checkpoint with fewer arguments
	public Checkpoint(int ID)
	{
		this(ID, null, null);
	}
	
	public Checkpoint(int ID, int[][] JunctionsConnected, int[] TrainsPresent)
	{
		super(ID, JunctionsConnected, TrainsPresent);
		this.IsFaulty = false;
		this.FaultMessage = "";
	}
	
	//Repairs the fault at a checkpoint
	protected void RepairFault()
	{
		this.IsFaulty = false;
	}
	
	//Causes or changes a fault at a checkpoint
	protected void CauseFault(String Message)
	{
		this.IsFaulty = true;
		this.FaultMessage = Message;
	}
}
