import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] snowFall;

public void setup()
{
  //your code here
  size(300, 300);
  snowFall = new SnowFlake[500];
  for(int i = 0; i < snowFall.length; i++)
    {
      snowFall[i] = new SnowFlake();
    }
  background(0);
}
public void draw()
{
  
  //your code here
  for(int i = 0; i <snowFall.length; i++)
  {
    snowFall[i].erase();
    snowFall[i].lookDown();
    snowFall[i].move();
    snowFall[i].wrap();
    snowFall[i].show();
  }
}
public void mouseDragged()
{
  //your code here
  if(mouseButton == LEFT)
  {
    noStroke();
    fill(255, 0, 0);
    ellipse(mouseX, mouseY, 10,10);
  }
  if(mouseButton == RIGHT)
  {
    fill(0);
    ellipse(mouseX, mouseY, 15, 15);
  }
  stroke (0);
}

class SnowFlake
{
  //class member variable declarations
  int x,y;
  boolean isMoving;
  SnowFlake()
  {
    //class member variable initializations
    x = (int)(Math.random()*300);
    y = (int)(Math.random()*301);
    isMoving = true;
  }
  public void show()
  {
    //your code here
    fill(255);
    ellipse(x, y, 5, 5);
  }
  public void lookDown()
  {
    //your code here
    if(get(x,y+4) != color (0) && (y < 296 && y > 7))
    {
      isMoving = false;
    }else
    {
      isMoving = true;
    }
  }
  public void erase()
  {
    //your code here
    fill(0);
    ellipse(x, y, 7, 7);
  }
  public void move()
  {
    //your code here
    if(isMoving == true)
    {
      y= y + 1;
    }else
    {
      y = y;  
    }
  }
  public void wrap()
  {
    //your code here
    if(y > 300)
    {
      y = (int)(Math.random()*-3);
      x = (int)(Math.random()*299);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
