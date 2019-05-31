
public abstract class Skills implements ISkills
{
	private int Id;
	private int Damage;
	
	public Skills(int id, int damage) 
	{
		Id = id;
		Damage = damage;
	}
	//GetSet
	@Override
	public int GetDamage() 
	{
		return Damage;
	}
	@Override
	public int GetId() 
	{
		return Id;
	}
}
