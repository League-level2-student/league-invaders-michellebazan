
public class LeagueInvaders {
/*jnkmk,
//*
// ***** SEGMENT CLASS *****
// This class will be used to represent each part of the moving snake.
//*

class Segment {

//Add x and y member variables. They will hold the corner location of each segment of the snake.
int xpos;
int ypos;

// Add a constructor with parameters to initialize each variable.
Segment(int xpos, int ypos){
  this.xpos = xpos;
  this.ypos = ypos;
}

}


//*
// ***** GAME VARIABLES *****
// All the game variables that will be shared by the game methods are here
//*
int Segment;
int foodX;
int foodY;

int xpos =((int)random(50)*10);
int ypos = ((int)random(50)*10);
int direction =  UP;
int checkFood;
Segment head = new Segment(xpos,ypos);

ArrayList<Segment> segments = new ArrayList<Segment>();

//*
// ***** SETUP METHODS *****
// These methods are called at the start of the game.
//*

void setup() {
  size(500,500);

  frameRate(20);
  dropFood();
  
}

void dropFood() {
  //Set the food in a new random location
  foodX = ((int)random(50)*10);
  foodY = ((int)random(50)*10);
}



//*
// ***** DRAW METHODS *****
// These methods are used to draw the snake and its food 
//*

void draw() {
  background(0);
  drawFood();
  move();
  drawSnake();
  eat();
}

void drawFood() {
  //Draw the food
  fill(220,20,60);
  rect(foodX, foodY, 10, 10);
}

void drawSnake() {
  //Draw the head of the snake followed by its tail
  fill(50,205,50);
  rect(xpos,ypos,10,10);
  manageTail();
}


//*
// ***** TAIL MANAGEMENT METHODS *****
// These methods make sure the tail is the correct length.
//*

void drawTail() {
  //Draw each segment of the tail 
  
  //got stuck here
  //https://central.jointheleague.org/levels/Level2/Mod2Recipes/Snake3.html
  for(int i = 0; i < segments.size(); i++){
    rect(segments.get(i).xpos, segments.get(i).ypos,10,10);
  }

}

void manageTail() {
  //After drawing the tail, add a new segment at the "start" of the tail and remove the one at the "end" 
  //This produces the illusion of the snake tail moving.
  checkTailCollision();
  drawTail();
  segments.add(new Segment(head.xpos, head.ypos));
  segments.remove(0);
  
}

void checkTailCollision() {
  //If the snake crosses its own tail, shrink the tail back to one segment
  checkFood = 1;
  segments = new ArrayList();
  segments.add(new Segment(head.xpos, head.ypos));
}



//*
// ***** CONTROL METHODS *****
// These methods are used to change what is happening to the snake
//*

void keyPressed() {
  //Set the direction of the snake according to the arrow keys pressed
    direction = keyCode;
    if(keyCode == UP) {
      head.ypos = ypos;
      ypos= ypos-2;
    } else if (keyCode == DOWN){
      head.ypos = ypos;
      ypos= ypos+2;
    } else if (keyCode == LEFT){
      head.xpos = xpos;
      xpos= xpos-2;  
    } else if (keyCode == RIGHT){
      head.xpos = xpos;
      xpos=xpos+2;
    }
  }


void move() {
  //Change the location of the Snake head based on the direction it is moving.
  
    
  switch(direction) {
  case UP:
    // move head up here 
    direction = UP;
    break;
  case DOWN:
    // move head down here 
    direction = DOWN;
    break;
  case LEFT:
   // figure it out 
   direction = LEFT;
    break;
  case RIGHT:
    // mystery code goes here 
    direction = RIGHT;
    break;
  //default: checkBoundaries();
    
  }
  checkBoundaries();
}

void checkBoundaries() {
 //If the snake leaves the frame, make it reappear on the other side
 if(xpos>500){
   xpos = xpos - 500;
 }else if(xpos<0){
   xpos = xpos + 500;
 }else if(ypos>500){
   ypos = ypos - 500;
 }else if(ypos<0){
   ypos = ypos + 500;
 }  
}



void eat() {
  //When the snake eats the food, its tail should grow and more food appear
  if (xpos == foodX && ypos == foodY){
    checkFood++;
    foodX = ((int)random(50)*10);
    foodY = ((int)random(50)*10);
    segments.add(new Segment(head.xpos, head.ypos));
    //it does not move
    
  }
}
*/
}
