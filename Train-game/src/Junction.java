import java.util.List;

public class Junction
{
	List<?> ConnectedTracks;
	boolean IsFaulty;
	int TrainsPresent;
	
	public Junction()
	{
		this.IsFaulty = false;
		this.TrainsPresent = 0;
	}
	
	public void RepairFault()
	{
		this.IsFaulty = false;
	}
}
