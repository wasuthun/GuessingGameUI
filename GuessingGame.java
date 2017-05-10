import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GuessingGame
{
	private int upperBound;
	private int secret;
	private String hint;
	private int count;

	public GuessingGame(int upperBound)
	{
		this.upperBound = upperBound;
		this.secret = getRandomNumber(upperBound);
		this.hint = "I'm thinking of a number between 1 and " + upperBound;
	}
public int getSecret(){
	return this.secret;
}
	public boolean guess(int number)
	{
		if (number == this.secret)
		{
			this.hint = "Correct.the secret is " + this.secret;
			return true;

		} else if (number < this.secret)
		{
			this.hint = "Sorry,your guess is too small";
			return false;
		} else
		{
			this.hint = "Sorry,your guess is too large";
			return false;
		}
	}
public void setCount(){
	count++;
}
public int getCount(){
	return this.count;
}
	public String getHint()
	{
		return this.hint;
	}

	private int getRandomNumber(int limit)
	{
		long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		return random.nextInt(limit) + 1;
	}
	
}

