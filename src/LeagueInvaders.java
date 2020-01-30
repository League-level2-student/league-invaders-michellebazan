
public class LeagueInvaders {
/*/
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
  print(segments.size());
}

void drawFood() {
  //Draw the food
  fill(220,20,60);
  rect(foodX, foodY, 10, 10);
}

void drawSnake() {
  //Draw the head of the snake followed by its tail
  fill(50,205,50);
  rect(head.xpos,head.ypos,10,10);
  manageTail();
}


//*
// ***** TAIL MANAGEMENT METHODS *****
// These methods make sure the tail is the correct length.
//*

void drawTail() {
  //Draw each segment of the tail 
  //https://central.jointheleague.org/levels/Level2/Mod2Recipes/Snake3.html
  for(int i = 0; i < segments.size(); i++){
    rect(segments.get(i).xpos , segments.get(i).ypos,10,10);
  }

}

void manageTail() {
  //After drawing the tail, add a new segment at the "start" of the tail and remove the one at the "end" 
  //This produces the illusion of the snake tail moving.
  checkTailCollision();
  drawTail();
  segments.add(0,new Segment(head.xpos, head.ypos));
  segments.remove(segments.size()-1);
  
}

void checkTailCollision() {
  //If the snake crosses its own tail, shrink the tail back to one segment
  for(int i = 0; i < segments.size(); i ++){
    if(head.xpos == segments.get(i).xpos && head.ypos == segments.get(i).ypos){
      checkFood = 1;
      segments = new ArrayList();
     // segments.add(new Segment(head.xpos, head.ypos));
    }
  }
   
}



//*
// ***** CONTROL METHODS *****
// These methods are used to change what is happening to the snake
//*

void keyPressed() {
  //Set the direction of the snake according to the arrow keys pressed
    int direction1 = direction;
 //   direction = keyCode;
    if(keyCode == UP && direction1 != DOWN) {
      direction = UP;
    } else if (keyCode == DOWN&& direction1 != UP){
      direction = DOWN;
    } else if (keyCode == LEFT&& direction1 != RIGHT){
      direction = LEFT;
    } else if (keyCode == RIGHT&& direction1 != LEFT){
      direction = RIGHT;
    }
  }


void move() {
  //Change the location of the Snake head based on the direction it is moving.
  
    
  switch(direction) {
  case UP:
    // move head up here 
    head.ypos -=10;
    break;
  case DOWN:
    // move head down here 
    head.ypos +=10;
    break;
  case LEFT:
   // figure it out 
   head.xpos -=10;
    break;
  case RIGHT:
    // mystery code goes here 
    head.xpos += 10;
    break;
  //default: checkBoundaries();
    
  }
  checkBoundaries();
}

void checkBoundaries() {
 //If the snake leaves the frame, make it reappear on the other side
 if(head.xpos>=501){
   head.xpos = 10;
 }else if(head.xpos<=-1){
   head.xpos = 490;
 }else if(head.ypos>=501){
   head.ypos = 10;
 }else if(head.ypos<=-1){
   head.ypos = 490;
 }  
}



void eat() {
  //When the snake eats the food, its tail should grow and more food appear
  if (head.xpos == foodX && head.ypos == foodY){
    checkFood++;
    foodX = ((int)random(50)*10);
    foodY = ((int)random(50)*10);
    segments.add(new Segment(head.xpos, head.ypos));
  }
}
*/
}
