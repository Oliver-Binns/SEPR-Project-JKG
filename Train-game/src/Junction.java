import java.util.List;

public class Junction
{
	List<?> ConnectedTracks;
	boolean IsFaulty;
	int TrainsPresent;
//	int JunctionID
	
	public Junction()
	{
//		int this.JunctionID = ID
		this.IsFaulty = false;
		this.TrainsPresent = 0;
	}
	
	public void RepairFault()
	{
		this.IsFaulty = false;
	}
}
