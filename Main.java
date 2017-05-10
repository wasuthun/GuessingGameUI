
public class Main
{
	public static void main(String[] args)
	{
		GuessingGame game = new GuessingGame(27);
		GameConsole ui = new GameConsole();
		ui.play(game);
	}
}
