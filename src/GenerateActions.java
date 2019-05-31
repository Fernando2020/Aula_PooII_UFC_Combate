import java.util.ArrayList;

public class GenerateActions 
{
	ArrayList<Actions> ActionsList;
	
	//Constructor
	public GenerateActions()
	{
		ActionsList = new ArrayList<Actions>();
	}
	
	//lista de acoes
	public ArrayList<Actions> ActionsList()
	{
		for (int i = 0; i < 1000; i++) 
		{
			ActionsList.add(new Actions());
	    }
		return ActionsList;
	}
}
