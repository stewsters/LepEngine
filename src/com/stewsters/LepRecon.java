package com.stewsters;

import java.util.ArrayList;
import processing.core.PApplet;

public class LepRecon extends PApplet{

	Person me;
	ArrayList<Bullet> bullets;
	
	public void setup(){
		size(200,200);
		me = new Person();
		bullets = new ArrayList<Bullet>();
		
	}
	
	public void draw(){	
		background(255);
		
		//Updates
		me.update();
		for(Bullet bullet: bullets)
		{
			bullet.update();
		}
		
		//Renders
		me.render(this);
		for(Bullet bullet: bullets)
		{
			bullet.render(this);
		}
	}
	
	
	
	/**
	 * Controls
	 */
	public void keyPressed() {
		  if (key == 'w') {
		    me.yVel = -1;
		  }
		  else if (key == 's')
		  {
			  me.yVel = 1;
		  }
		  else if (key == 'a')
		  {
			  me.xVel = -1;
		  }
		  else if (key == 'd')
		  {
			  me.xVel = 1;
		  }
		}

		public void keyReleased() {

		  if (key == 'w') {
			  me.yVel = max(0, me.yVel);
		  }
		  else if (key == 's')
		  {
			  me.yVel = min(0, me.yVel);
		  }
		  else if (key == 'a')
		  {
			  me.xVel = max(0, me.xVel);
		  }
		  else if (key == 'd')
		  {
			  me.xVel = min(0, me.xVel);
		  }
		}
	
	
		//Find trajectory and make a projectile
		public void mousePressed() {
		  float xDiff = (float)mouseX - me.xPos;
		  float yDiff = (float)mouseY - me.yPos;
		 
		  Bullet bullet = new Bullet(me.xPos,me.yPos,5.f,xDiff,yDiff);
		  bullets.add(bullet);
		  
		  //spawn a bullet 1 unit in front of use traveling in the direction specified by the click
		}

		
}
