import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {//runner/driver class that controls the entire program 
	//using the other classes that you will create later.
	JFrame frame = new JFrame("LeagueInvaders");
    //By Java convention, these variable names are 
	//capitalized to indicate they will not change
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel gamePanel; 
	

	LeagueInvaders() {
	gamePanel = new GamePanel();
	}
	public static void main(String[] args) { 
		//only main method in entire program
		LeagueInvaders game = new LeagueInvaders();
		
		
		game.setup();
	}
	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.addKeyListener(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	
	
}
