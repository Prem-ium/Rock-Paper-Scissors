import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RockPaperScissors_GUI implements ActionListener {
	private JFrame frame = new JFrame();
	private JPanel titlePanel = new JPanel();
	private JLabel title = new JLabel();
	private JPanel buttonPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JButton[] buttons = new JButton[3];
	private JLabel outcome = new JLabel();
	private String choices[] = {"ROCK", "PAPER", "SCISSORS"};
	private String AIChoice = "";
	private String userChoice = "";
	public RockPaperScissors_GUI() {
		setIcon();
	
		frame.setTitle("ROCK-PAPER-SCISSORS");
		frame.setResizable(false);
		frame.setSize(800, 500);
		frame.getContentPane().setBackground(new Color(123, 50, 250));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		title.setText("ROCK-PAPER-SCISSORS!");
		title.setOpaque(true);
		title.setFont(new Font("Ink Free", Font.BOLD, 50));
		title.setForeground(new Color(123, 50, 250));
		title.setBackground(new Color(0, 0, 10));
		
		outcome.setText("Click a weapon to see result");
		outcome.setOpaque(true);
		outcome.setFont(new Font("Ink Free", Font.BOLD, 25));
		outcome.setForeground(Color.BLACK);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 300);
		titlePanel.add(title);
		
		for(int i = 0; i < 3; i++) {
			buttons[i] = new JButton();
			buttons[i].setText(choices[i]);
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD,20));
			buttons[i].addActionListener(this);
			buttons[i].setForeground(new Color(123, 50, 250));
		}
		bottomPanel.add(outcome);
		buttonPanel.setBackground(new Color(123, 50, 250));
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.SOUTH);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		generateAIChoice();
		for(int i = 0;i < 3; i++) {
			if(e.getSource()==buttons[i]) {
				setUserChoice(buttons[i].getText());
			}
		}
		if (AIChoice.equals(choices[0])) {
			// AI CHOICE = ROCK
			if(userChoice.equals(choices[1])) {
				// YOU WIN
				outcome.setText(String.format("You threw %s to the Computer's %s. You WIN!", userChoice, AIChoice));
			} else if(userChoice.equals(choices[2])) {
				// YOU LOSE
				outcome.setText(String.format("You threw %s to the Computer's %s. You LOSE!", userChoice, AIChoice));
			} else {
				//TIE
				outcome.setText(String.format("You threw %s to the Computer's %s. You TIED!", userChoice, AIChoice));

			}
		} else if(AIChoice.equals(choices[1])) {
			// AI Choice = PAPER
			if(userChoice.equals(choices[0])) {
				// YOU LOSE
				outcome.setText(String.format("You threw %s to the Computer's %s. You LOSE!", userChoice, AIChoice));
			} else if (userChoice.equals(choices[2])) {
				// YOU WIN
				outcome.setText(String.format("You threw %s to the Computer's %s. You WIN!", userChoice, AIChoice));

			} else {
				//TIE
				outcome.setText(String.format("You threw %s to the Computer's %s. You TIED!", userChoice, AIChoice));

			}
		} else {
			// AI Choice = SCISSORS
			if(userChoice.equals(choices[0])) {
				// YOU WIN
				outcome.setText(String.format("You threw %s to the Computer's %s. You WIN!", userChoice, AIChoice));

			} else if(userChoice.equals(choices[1])) {
				// YOU LOSE
				outcome.setText(String.format("You threw %s to the Computer's %s. You LOSE!", userChoice, AIChoice));

			} else {
				//TIE
				outcome.setText(String.format("You threw %s to the Computer's %s. You TIED!", userChoice, AIChoice));

			}
		}
	}
	private void generateAIChoice() {
		double value = Math.random() * 11;
		if(value >= 6.7) {
			AIChoice = choices[0];
		} else if (value >= 3.4) {
			AIChoice = choices[1];
		} else {
			AIChoice = choices[2];
		}
	}
	private void setIcon() {
		// Allows for JPane to use an icon from the internet URL 
		try {
			URL url = new URL("https://www.clipartkey.com/mpngs/m/90-900256_transparent-rock-paper-scissors-clipart-rock-paper-scissors.png");
			Image image = ImageIO.read(url);
			frame.setIconImage(image);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}
	public static void main(String[] args) {
		new RockPaperScissors_GUI();
	}
}
