import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	//member variable is when it's defined in that class
	//local is when it's only in the method
	Rocketship ship;
	Projectile missile;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random;
	
	//https://central.jointheleague.org/levels/Level2/Mod2Recipes/InvadersModelDraw.html
	ObjectManager(Rocketship ship){
		this.ship = ship;
	
	}
	
	void addProjectile(Projectile missile) {
		projectiles.add(missile);
	}
	
	void addAlien(){
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));

	}
	
	void update() {
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
			projectiles.get(i).update();
			if(projectiles.get(i).y > LeagueInvaders.HEIGHT) {
				//boolean isActive = false;
				projectiles.get(i).isActive = false;
			}
		}	
			
	}
		
	void draw(Graphics g){
		ship.draw(g);
		for(int i = 0; i < aliens.size(); i++){
			aliens.get(i).draw(g);
		}
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	
	void purgeObjects() {
		for (int i = aliens.size(); i >= 0; i--) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = projectiles.size(); i >= 0; i--) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		
		}
	}
}
