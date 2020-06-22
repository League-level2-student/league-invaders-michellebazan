import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel 
					implements ActionListener, KeyListener{
	//member variable is when it's defined in that class
	//local is when it's only in the method
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int x = 500;
    int y = 800;
    Font titleFont;
    Font enterFont;
    Timer frameDraw;
    Timer alienSpawn;
    Rocketship rock;
    ObjectManager objMan;
    public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
    
	//Use the getScore method in the ObjectManager class to get the player's score and display it on the panel.
			
	GamePanel(){ 
    	titleFont = new Font("Arial", Font.PLAIN, 48);
    	enterFont = new Font("Arial", Font.PLAIN, 25);
    	// The first parameter is an int for how fast your want
    	//the timer to repeat. This is in milliseconds so 1000 
    	//is equal to 1 second. We want the game to run at 60 
    	//frames per second. So the first parameter will be 1000 / 60. 
    	frameDraw = new Timer(1000/60,this);
        frameDraw.start();

        rock = new Rocketship(220,650,50,50);
        objMan = new ObjectManager(rock);
        if (needImage) {
		    loadImage ("space.png");
		}
    }
    
    void startGame(){
    	//The constructor of the Timer class takes two parameters.
    	//The first parameter is an int for how fast your want the timer to 
    	//repeat in milliseconds.
    	//The second parameter takes a reference to an ActionListener object.
    	alienSpawn = new Timer(1000 , objMan);
    	objMan.score = 0;
    	alienSpawn.start();
    }
    
    int currentState = MENU;
    // 3 void methods for updating the game in each state
    void updateMenuState() { 
    	
    }
    
    void updateGameState() { 
    	//In the updateGameState method, add a call to the objectManager's update method
    	objMan.update();
    	if(rock.isActive == false) { 
    		currentState = END;
    		
    		rock = new Rocketship(220,650,50,50);
            objMan = new ObjectManager(rock);
    	}
    }
    
    void updateEndState()  { 
    	//empty
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
    	if (gotImage) {
        	g.drawImage(image,0,0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);

    	} else {
        	g.setColor(Color.BLACK);
        	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
        }
    	
    	//g.setColor(Color.BLACK);
    	//g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

    	//rock.draw(g);
    	//delete the call to the rocket's draw method and replace it with 
    	//a call to the objectManager's draw method.
    	objMan.draw(g);
    		
    }
    void drawEndState(Graphics g)  {  
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	
    	g.setFont(titleFont);
    	g.setColor(Color.GREEN);
    	g.drawString("End State", 150, 100);
    	g.drawString("Score: " + objMan.getScore(), 150, 200);
    	
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
		// menu --> game
		//startGame();
		// game --> end
		//alienSpawn.stop();
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		    	//replace the existing inactive rocketship with a new Rocketship object.
		    	rock = new Rocketship(220,650,50,50);
		    	
		    	//Replace the existing ObjectManager with a new ObjectMangaer object, 
		    	//passing the rocketship object to the constructor.
		    	objMan = new ObjectManager(rock);
		    	
		    	currentState = MENU;
		    } else if(currentState == MENU){
		    	startGame();
		        currentState++;
		    	//currentState = GAME;
		    } else if (currentState == GAME) {
		    	alienSpawn.stop();
		        currentState++;
		    	//currentState = END;
		    }
		} 
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    //calls up method up
		    rock.up();
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    //calls up method down - not working
		    rock.down();
		}
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			
		    System.out.println("RIGHT");
		    //calls up method right - not working
		    rock.right();
		}
		else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    //calls up method left
		    rock.left();
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			objMan.addProjectile(rock.getProjectile());
		}
		
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
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
