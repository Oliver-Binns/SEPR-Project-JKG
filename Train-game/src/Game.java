import java.util.List;


public class Game
{
	MapGraph Map;
	int TurnCounter;
	int CurrentPlayer;
	List<?> Players;
	List<?> Goals;

	public Game()
	{
		SetupPlayers();
		SetupMap();
		SetupGoals();
		//initialise map
	}
	
	private void SetupPlayers()
	{
		this.CurrentPlayer = 0;
		//initialise players
		Player player0 = new Player();
		Player player1 = new Player();
		this.Players.add(player0);	// TODO fix adding players to the list
		this.Players.add(player1);
	}
	
	private void SetupMap()
	{
		
	}
	
	private void SetupGoals()
	{
		
	}
	
	public void nextTurn()
	{
		this.CurrentPlayer = 0;
		NewGoal();
	}
	
	private void NewGoal()
	{
		if(this.Goals.size() == 3)
		{
			//TODO Ask players to pick a goal
		}
		else{
			while(this.Goals.size() < 3)
			{
				Goal newGoal;
				this.Goals.add(newGoal); //TODO fix new goal creation
			}
		}
	}
}
