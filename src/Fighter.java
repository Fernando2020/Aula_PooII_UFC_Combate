import java.util.ArrayList;
import java.util.Random;

public class Fighter 
{
	private int Id;
	private String Name;
	private int Life;
	private int Point;
	private ArrayList<Actions> ActionsList = new ArrayList<Actions>();
	private ArrayList<Skills> SkillsList = new ArrayList<Skills>();
	private EntityControllerBase Controller;
	
	//Constructor
	public Fighter(int id, String name, Player player, int point)
	{
		Id = id;
		Name = name;
		Controller = player;
		Life = 100;
		Point = point;
		AddSkillsList();
	}
	public Fighter(int id, String name, Npc npc, int point)
	{
		Id = id;
		Name = name;
		Controller = npc;
		Life = 100;
		Point = point;
		AddSkillsList();
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
	
	public int GetLife()
	{
		return Life;
	}
	
	public void SetLifeDamage(int damage)
	{
		Life -= damage;
	}
	public void SetLifeCure(int cure)
	{
		Life = cure;
	}
	
	public int GetPoint()
	{
		return Point;
	}
	public void SetPoint(int point)
	{
		Point += point;
	}
	
	public ArrayList<Actions> GetActionsList()
	{
		return ActionsList;
	}
	public void SetActionsList(ArrayList<Actions> actionsList)
	{
		ActionsList = actionsList;
	}
	
	//retorna lista de poderes
	public ArrayList<Skills> GetSkillsList()
	{
		return SkillsList;
	}
	//retorna entity poder invocado
	public Skills GetSkills()
	{
		Random rand = new Random();
		int number = rand.nextInt(SkillsList.size());
		return SkillsList.get(number);
	}
	
	//coquista novos poderes em funcao de pontos
	public void AddSkillsList()
	{
		if(Point>=1000 && SkillsList.size() == 0 )
			SkillsList.add(new Boxe());
		if(Point>=2000 && SkillsList.size() == 1)
			SkillsList.add(new JiuJitsu());
		if(Point>=3000 && SkillsList.size() == 2)
	    	SkillsList.add(new MuayThai());
		if(Point>=4000 && SkillsList.size() == 3)
	    	SkillsList.add(new Wrestling());
		if(Point>=5000 && SkillsList.size() == 4)
	    	SkillsList.add(new Karate());
	}
	public void RemoveSkillsList(Skills skills)
	{
		SkillsList.remove(skills);
	}
	
	public EntityControllerBase GetController()
	{
		return Controller;
	}
	
	//ataques simples
	public int GetPunch()
	{
		return 5;
	}
	public int GetKick()
	{
		return 10;
	}
}
