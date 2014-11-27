package MapGraph;

public class Station extends Junction
{
	String Name;
	
	public Station(int ID)
	{
		this(ID, null, null, "None");
	}
	
	public Station(int ID, int[][] JunctionsConnected, int[] TrainsPresent)
	{
		this(ID, JunctionsConnected, TrainsPresent, "None");
	}
	
	public Station(int ID, int[][] JunctionsConnected, int[] TrainsPresent, String Name)
	{
		this.Name = Name;
		super(ID, JunctionsConnected, TrainsPresent);
	}
}
