package ClueBoard;

import java.awt.GridLayout;

import javax.swing.*;

public class InfoPanel extends JPanel{

	public InfoPanel(Player player) {
		JButton nextPlayer = new JButton("Next Player");
		JButton makeAccusation = new JButton("Make and Accusation");
		JLabel turnLabel = new JLabel("Whose turn?");
		JLabel rollLabel = new JLabel("Roll");
		JLabel rollValue = new JLabel("5");
		JLabel guessLabel = new JLabel("Guess");
		JLabel guess = new JLabel ("o");
		JLabel responseLabel = new JLabel("Response");
		JLabel response = new JLabel("s");
		
		JTextField field = new JTextField("player 1");
		
		JPanel playerPanel = new JPanel();
		JPanel diePanel = new JPanel();
		JPanel guessPanel = new JPanel();
		JPanel resultPanel = new JPanel();
		
		playerPanel.add(turnLabel);
		playerPanel.add(field);
		
		diePanel.add(rollLabel);
		diePanel.add(rollValue);
		
		guessPanel.add(guessLabel);
		guessPanel.add(guess);
		
		resultPanel.add(responseLabel);
		resultPanel.add(response);
		
		diePanel.setBorder(BorderFactory.createTitledBorder("Die"));
		guessPanel.setBorder(BorderFactory.createTitledBorder("Guess"));
		resultPanel.setBorder(BorderFactory.createTitledBorder("Guess Result"));
		
		setLayout(new GridLayout(2, 3));
		add(playerPanel);
		add(nextPlayer);
		add(makeAccusation);
		add(diePanel);
		add(guessPanel);
		add(resultPanel);
		
	}

}
