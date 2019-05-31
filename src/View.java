import java.util.ArrayList;
import java.util.Scanner;

public class View 
{
	private static Scanner scan;
	private static String name;
	private static int difficulty;
	private static int fighterId;
	
	public static void Start()
	{
		Dialogue();
	}
	
	public static void EndGame()
	{
		System.out.println("\nGame Over");
		return;
	}
	
	//dialogo
	private static void Dialogue()
	{
		scan = new Scanner(System.in);
		System.out.print("Digite seu Nickname: ");
		name = scan.next();
		
		Player player = new Player(0, name);
		Npc npc = new Npc(1, "Npc");
		
		player.SetDifficulty(ValidationDifficulty());
		player.SetFightId(SelectListFighter(difficulty));
		
		try 
		{
			ArrayList<Fighter> fighterList = RequestFighters(player, npc);
			InvokeChampionship(fighterList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			EndGame();
		}
	}
	
	//selecionar dificuldade
	private static int ValidationDifficulty()
	{
		boolean step = true;
		System.out.println("Selecione a dificuldade");
		while(step)
		{
			System.out.println("[1] - Facil\n[2] - Medio\n[3] - Dificil");
			difficulty = scan.nextInt();
			step = (difficulty>0 && difficulty<4) ? false : true;
		}
		return difficulty *= 10;
	}
	
	//selecionar lutador
	private static int SelectListFighter(int difficulty)
	{
		String list = "";
		
		for(int i=0; i<difficulty; i++)
			list += "Lutador " + i + "\n"; 

		System.out.println(list);
		
		System.out.print("Selecione o seu lutador: ");
		fighterId = scan.nextInt();
		fighterId = (fighterId>difficulty) ? difficulty : fighterId;

		return fighterId;
	}
	
	//gerar e escolher lutadores
	private static ArrayList<Fighter> RequestFighters(Player player, Npc npc)
	{
		GenerateFighter generateFighter = new GenerateFighter();
		InvokeFighter(player, npc, generateFighter);
		System.out.println("\n" + generateFighter.toString());
		return generateFighter.GetFighterList();
	}
	
	//gerar combate
	private static void InvokeFighter(Player player, Npc npc, GenerateFighter generateFighter)
	{
		generateFighter.SetFighterList(player, npc);
	}
	
	//invocar combate
	private static void InvokeChampionship(ArrayList<Fighter> fighterList)
	{
		Championship championship = new Championship(0, "Version - " + 0);
		championship.SetFighterList(fighterList);
		championship.SetCombat(fighterId);
		championship.InvokeCombat();
	}

	public static void InvokeResultCombat(Fighter winner, Fighter loser, int idCombate)
	{
		System.out.println("Combate numero #" + idCombate);
		System.out.println("Vencedor - Controlador: " + winner.GetController().GetName() + " / Lutador: " + winner.GetName());
		System.out.println("Perdedor - Controlador: " + loser.GetController().GetName() + " / Lutador: " + loser.GetName());
		System.out.println("***");
	}
}
