import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	//member variable is when it's defined in that class
	//local is when it's only in the method
	Rocketship ship;
	Projectile missile;
	//fix below --
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	(Alien) ArrayList aliens = new ArrayList();
	Random random;
	
	//Model Management
	//figure out steps 4 - array list & 5 -- update method
	//
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
			((Alien) aliens.get(i)).update();
			//find out how to get alien's y position
			//check alien y position vs game's height
			//if(aliens.get(y) > LeagueInvaders.HEIGHT) {
				//if the alien is outside --> set isActive variable to false
				//figure out the isActive variable
				
			//}
			
			//repeat with the projectiles
		}
		
	void draw() {
		
	}
	
	void purgeObjects() {
		
	}
}
