import java.util.Random;

public class Actions 
{
	public int Attack;
	public int Punch;
	public int Kick;
	public int Power;
	public int Defense;
	
	//Constructor
	public Actions()
	{
		this.SortingValues();
	}
	
	//acoes
	public void SortingValues()
	{
		Random rand = new Random();
		
		if(rand.nextInt(2)==0)
		{
			this.Defense=1;
		}
		else
		{
			this.Attack=1;
			
			if(rand.nextInt(3)==0)
		    {
				this.Kick=1;
				this.Punch=0;
				this.Power=0;
			}
			else if(rand.nextInt(3)==1)
			{
				this.Kick=0;
				this.Punch=1;
				this.Power=0;
			}
			else
			{
				this.Kick=0;
				this.Punch=0;
				this.Power=1;
			}
		}
	}
}
