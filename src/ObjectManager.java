import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	//member variable is when it's defined in that class
	//local is when it's only in the method
	static Integer score = 0;
	Rocketship rock;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	
	//Getter
	public Integer getScore() {
		return score;
	}
	
	
	//https://central.jointheleague.org/levels/Level2/Mod2Recipes/InvadersModelDraw.html
	ObjectManager(Rocketship rock){
		this.rock = rock;
		
	}
	
	void addProjectile(Projectile missile) {
		projectiles.add(missile);
	}
	
	void addAlien(){
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));

	}
	
	void update() {
	
		rock.update();
		//https://central.jointheleague.org/levels/Level2/Mod2Recipes/InvadersCollision.html
			for(int i = 0; i < aliens.size(); i++){
				//updates alien with update method
				
				aliens.get(i).update();
				if(aliens.get(i).y > LeagueInvaders.HEIGHT) {
					//if the alien is outside --> set isActive variable to false
					//boolean isActive = false;
					aliens.get(i).isActive = false;
					//isActive is part of the initial game Object
				}
			}
			
			//repeat with the projectiles
			for(int i = 0; i < projectiles.size(); i++){
				//if (rock.isActive = false) {
				//	break;
				//}
				projectiles.get(i).update();
				if(projectiles.get(i).y > LeagueInvaders.HEIGHT) {
					//boolean isActive = false;
					projectiles.get(i).isActive = false;
				}
			}	
				checkCollision();
				purgeObjects();
			
		}
//If the rocket is marked inActive, you can skip all the remaining 
//updates and purging because the game is over.
	
		
	
	
		
	void draw(Graphics g){
		rock.draw(g);
		for(int i = 0; i < aliens.size(); i++){
			aliens.get(i).draw(g);
		}
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	
	void purgeObjects() {
		for (int i = aliens.size()-1; i >= 0; i--) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = projectiles.size()-1; i >= 0; i--) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		
		}
	}
	
	//Create a method called checkCollision
	void checkCollision() {
		//Add code that iterates through every alien and checks if it collides
		//with any "enemy" (Rocket or Projectile). 
		for(int i = 0; i < aliens.size(); i++) {
			//If they collide, set the Alien AND "enemy's" isActive variables to false.
			if(rock.collisionBox.intersects(aliens.get(i).collisionBox)) { 
				rock.isActive = false;
				aliens.get(i).isActive = false;
				}
			for(int a = 0; a < projectiles.size(); a++) {
				if(projectiles.get(a).collisionBox.intersects(aliens.get(i).collisionBox)) {
					projectiles.get(a).isActive = false; 
					aliens.get(i).isActive = false;
					score++; //score = score + 1;
					}
			}
			
			
			//https://central.jointheleague.org/levels/Level2/Mod2Recipes/InvadersCollision.html

		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();

	}
	
}
