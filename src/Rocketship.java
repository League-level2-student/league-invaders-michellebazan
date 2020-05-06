import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 10;
		 //4. Call the loadImage method from the constructor:
	    if (needImage) {
	        loadImage ("rocket.png");
	    }
	}
	public void right() {
		if(x < 450) 
			x+=speed;
		
    }
	public void left() {
		if(x > 0)
			x-=speed;
    }
	public void up() {
		if(y > 0)
			y-=speed;
        
    }
	public void down() {
        if(y < 670)
        	y+=speed;
    }

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
        
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
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
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
} 
	
	
}
