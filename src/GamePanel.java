import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int x = 500;
    int y = 800;
    Font titleFont;
    Font enterFont;
    GamePanel(){ 
    	titleFont = new Font("Arial", Font.PLAIN, 48);
    	enterFont = new Font("Arial", Font.PLAIN, 25);
    }
    
    int currentState = MENU;
    // 3 void methods for updating the game in each state
    void updateMenuState() { 
    	
    }
    
    void updateGameState() { 
    	
    }
    
    void updateEndState()  { 
    	
    }
    //3 void methods for drawing the game in each state
    void drawMenuState(Graphics g) {  
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	
    	g.setFont(titleFont);
    	g.setColor(Color.YELLOW);
    	g.drawString("LEAGUE INVADERS", x-480, y-600);
    	
    	g.setFont(enterFont);
    	g.drawString("Press ENTER to start", x-420, y-300);
    	
    	g.drawString("Press SPACE for instructions", x-470, y-200);
    }
    void drawGameState(Graphics g) {  
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	
    }
    void drawEndState(Graphics g)  {  
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	
    	g.setFont(titleFont);
    	g.setColor(Color.GREEN);
    	g.drawString("End State", x, y);
    }
    
	@Override
	public void paintComponent(Graphics g){
		//g.fillRect(10, 10, 100, 100);
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
		
	}
}
