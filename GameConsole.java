import java.util.Scanner;

public class GameConsole
{
	public int play(GuessingGame game)
	{
		Scanner sc = new Scanner(System.in);

		boolean gg;
		System.out.println("Guessing Game");
		System.out.print("Your guess?");
		int number;
	
		do
		{

			System.out.println(game.getHint());
			number = sc.nextInt();
			gg = game.guess(number);
			game.setCount();
		} while (gg == false);
		System.out.println("secret is" + number + "count"+game.getCount() );
		return number;
	}
}