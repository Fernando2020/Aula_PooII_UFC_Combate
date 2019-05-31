import java.util.ArrayList;

public class Championship 
{
	private int Id;
	private String Name;
	private ArrayList<Fighter> FighterList = new ArrayList<Fighter>();
	private ArrayList<Combat> CombatList = new ArrayList<Combat>();
	
	//Constructor
	public Championship(int id, String name)
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
	
	public ArrayList<Fighter> GetFighterList()
	{
		return FighterList;
	}
	public void SetFighterList(ArrayList<Fighter> fighterList)
	{
		FighterList = fighterList;
	}
	
	public ArrayList<Combat> GetCombatList()
	{
		return CombatList;
	}
	
	//lista de combate
	public void SetCombat(int playerController)
	{
		int idCombat = 1;
		for(int i=0; i<FighterList.size(); i++)
			if(i!=playerController) 
			{
				CombatList.add(new Combat(idCombat, "Luta - " + idCombat, FighterList.get(playerController), FighterList.get(i)));
				idCombat++;
			}
	}
	
	//inicio de combate
	public void InvokeCombat()
	{
		for(int i=0; i<CombatList.size(); i++)
		{
			CombatList.get(i).Play();
			
			if(GameOverVerification(CombatList.get(i).GetLoser())) 
				return;
		}
	}
	public boolean GameOverVerification(Fighter loser)
	{
		if(loser.GetController().getClass().getName().equals("Player"))
			return true;
		return false;
	}
}
