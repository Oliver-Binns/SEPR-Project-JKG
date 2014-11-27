package MapGraph;

public class Checkpoint extends Junction
{
	bool IsFaulty;
	
	public Checkpoint(int ID)
	{
		this(ID, null, null);
	}
	
	public Checkpoint(int ID, int[][] JunctionsConnected, int[] TrainsPresent)
	{
		this.IsFaulty = false;
		super(ID, JunctionsConnected, TrainsPresent);
	}
}
