import java.util.ArrayList;

public class GenerateFighter 
{
	private ArrayList<Fighter> FighterList = new ArrayList<Fighter>();
	
	//Constructor
	public GenerateFighter()
	{

	}
	
	//GetSet
	public ArrayList<Fighter> GetFighterList()
	{
		return FighterList;
	}
	
	//lista de lutadores
	public void SetFighterList(Player player, Npc npc)
	{
		for(int i=0; i<player.GetDifficulty(); i++)
		{
			if(i != player.GetFightId())
			{
				if(i<5)
					FighterList.add(new Fighter(i, "Lutador - " + i, npc, 1000));
				else if(i<10)
					FighterList.add(new Fighter(i, "Lutador - " + i, npc, 3000));
				else
					FighterList.add(new Fighter(i, "Lutador - " + i, npc, 5000));
			}
			else
				FighterList.add(new Fighter(i, "Lutador - " + i, player, 1000));
		}
	}
	
	//imprime lista de lutadores
	@Override
	public String toString()
	{
		String listString = "";
		for(int i=0; i<FighterList.size(); i++)
		{
			listString += FighterList.get(i).GetName() + 
					      " - Controlador " + FighterList.get(i).GetController().GetName() + "\n";
		}
		return listString;
	}
}
