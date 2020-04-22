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
				boolean isActive = false;
				//isActive is part of the inital game Object
			}
		}
		//repeat with the projectiles
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).update();
			if(projectiles.get(i).y > LeagueInvaders.HEIGHT) {
				boolean isActive = false;
			}
		}	
			
	}
		
	void draw() {
		
	}
	
	void purgeObjects() {
		
	}
}
