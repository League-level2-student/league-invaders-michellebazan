import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 10;
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
	}
	
}
