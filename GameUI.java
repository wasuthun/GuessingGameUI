import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

class GameUI implements Runnable{
private JFrame frame;
private JButton enterButton;
private JButton quitButton;
private JPanel panel;
private JLabel label;
private JTextField inputField;
private JPanel hintpanel;
private JLabel Hint;
private GuessingGame game;
private JLabel guess;
private String temp;

public GameUI(GuessingGame game){
	this.game=game;
	frame=new JFrame();
	initComponent();
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

}
public void initComponent(){
	guess=new JLabel("you use"+game.getCount()+"guess");
	temp="Welocome to my world";
	Hint=new JLabel(temp);
	label=new JLabel("Enter your guess");
	frame.setLayout(new BorderLayout());
	inputField=new JTextField(7);
	enterButton=new JButton("Enter");
	quitButton=new JButton("Give Up");
	panel=new JPanel();
	hintpanel=new JPanel();
	
	panel.add(label);
	panel.add(inputField);
	panel.add(enterButton);
	panel.add(quitButton);
	
	
	hintpanel.setBorder(BorderFactory.createTitledBorder("Hint"));
	hintpanel.add(Hint);
	
	frame.add(hintpanel,BorderLayout.NORTH);
	frame.add(panel,BorderLayout.CENTER);
	frame.add(guess, BorderLayout.SOUTH);

	ClickEnter click=new ClickEnter();
	enterButton.addActionListener(click);
	ClickGiveUP ss=new ClickGiveUP();
	quitButton.addActionListener(ss);
}

public void run()
{frame.pack();
	frame.setVisible(true);
	
}
class ClickGiveUP implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		temp="The Secret number is "+game.getSecret();
		Hint.setText(temp);
		JOptionPane.showMessageDialog(frame, "finish");
		
	}
	
}
class ClickEnter implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0)
	{try
	{
		int inputnumber=Integer.parseInt(inputField.getText().trim());
		game.setCount();
		guess.setText("you use"+game.getCount()+"guess");
		if(game.guess(inputnumber)){
		  temp="Correct";
		  Hint.setText(temp);
		  JOptionPane.showMessageDialog(frame, temp);
		}else{
			temp=game.getHint();
			Hint.setText(temp);
		}
		inputField.setText("");
	} catch (NumberFormatException e)
	{
		temp="ERROR Please try again";
		Hint.setText(temp);
		JOptionPane.showMessageDialog(frame, temp, "Error", 0);
	}
		
	}
	
}
public static void main(String[] args)
{
	GameUI gui=new GameUI(new GuessingGame(20));
	gui.run();
}

}