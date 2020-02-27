import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel 
					implements ActionListener, KeyListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int x = 500;
    int y = 800;
    Font titleFont;
    Font enterFont;
    Timer frameDraw;
    Rocketship rock;
    
    GamePanel(){ 
    	titleFont = new Font("Arial", Font.PLAIN, 48);
    	enterFont = new Font("Arial", Font.PLAIN, 25);
    	// The first parameter is an int for how fast your want
    	//the timer to repeat. This is in milliseconds so 1000 
    	//is equal to 1 second. We want the game to run at 60 
    	//frames per second. So the first parameter will be 1000 / 60. 
    	frameDraw = new Timer(1000/60,this);
        frameDraw.start();
        rock = new Rocketship(250,700,50,50);

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
    	g.drawString("LEAGUE INVADERS", x-480, y-700);
    	
    	g.setFont(enterFont);
    	g.drawString("Press ENTER to start", x-390, y-450);
    	
    	g.drawString("Press SPACE for instructions", x-430, y-300);
    }
    void drawGameState(Graphics g) {  
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	rock.draw(g);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//https://central.jointheleague.org/levels/Level2/Mod2Recipes/InvadersRocketUpdate.html
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		} 
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		}
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		}
		else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
