package com.stewsters;

import processing.core.PApplet;

public class Bullet {

	public float bulletVelocity = 5.0f;
	
	public float xPos;
	public float yPos;
	public float xVel;
	public float yVel;
	
	public Bullet(float xP,float yP, float velocity, float xVelUnscaled, float yVelUnscaled){
		
		//get distance squared
		float innateDistance = (float) Math.sqrt((xVelUnscaled * xVelUnscaled) + (yVelUnscaled * yVelUnscaled));
		float multiplier = bulletVelocity / innateDistance;
		
		xVel = multiplier * xVelUnscaled;
		yVel = multiplier * yVelUnscaled;
		xPos = xP;
		yPos = yP;
	}
	
	//TODO: keep  
	public void render(PApplet context)
	{
		context.rect(xPos, yPos, 1, 1);
	}
	
	//TODO: check for collision
	public void update()
	{
		xPos += xVel;
		yPos += yVel;
	}
}
