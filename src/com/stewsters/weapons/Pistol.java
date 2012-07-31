package com.stewsters.weapons;

import com.stewsters.Bullet;
import com.stewsters.LepEngine;
import com.stewsters.Person;

public class Pistol implements Weapon {

	
	
	private static final float deviance = 0.1f;
	private boolean triggerDown = false;
	private int clipsize = 8;
	private int msBetweenShots = 500;

    //spawn a bullet 1 unit in front of use traveling in the direction specified by the click
	public void click(Person holder, int xClick, int yClick){
		  float xDiff = (float)xClick - holder.xPos;
		  float yDiff = (float)yClick - holder.yPos;
		 
		  Bullet bullet = new Bullet(holder.xPos,holder.yPos,5.f,xDiff,yDiff, 100.f);
		  LepEngine.bullets.add(bullet);

        //remove a bullet from the clip
	}

	@Override
	public void unclick(Person me, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
