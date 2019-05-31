
public abstract class EntityControllerBase 
{	
	private int Id;
	private String Name;
	private int Victory;
	private int Defeats;
	private int Difficulty;
	private int FightId;
	
	//Constructor
	public EntityControllerBase(int id, String name)
	{
		Id = id;
		Name = name;
	}
	
	//GetSet
	public int GetId()
	{
		return Id;
	}
	
	public String GetName()
	{
		return Name;
	}
	
	public int GetVictory()
	{
		return Victory;
	}
	public void SetVictory(int victory)
	{
		Victory += victory;
	}
	
	public int GetDefeats()
	{
		return Defeats;
	}
	public void SetDefeats(int defeats)
	{
		Defeats += defeats;
	}
	
	public int GetDifficulty()
	{
		return Difficulty;
	}
	public void SetDifficulty(int difficulty)
	{
		Difficulty = difficulty;
	}
	
	public int GetFightId()
	{
		return FightId;
	}
	public void SetFightId(int fightId)
	{
		FightId = fightId;
	}
}
