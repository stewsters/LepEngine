package com.stewsters;

import processing.core.PApplet;

public class Bullet {

	public float bulletVelocity = 5.0f;
	
	public float xPos;
	public float yPos;
	public float xVel;
	public float yVel;
	
	public float xDrag;
	public float yDrag;

    public float rangeTraveled;
	public float maxRange;

	public Bullet(float xP,float yP, float velocity, float xVelUnscaled, float yVelUnscaled,float maximumRange){
		
		//get distance squared
		float innateDistance = (float) Math.sqrt((xVelUnscaled * xVelUnscaled) + (yVelUnscaled * yVelUnscaled));
		float multiplier = velocity / innateDistance;
		bulletVelocity = velocity;

		xVel = multiplier * xVelUnscaled;
		yVel = multiplier * yVelUnscaled;
		xPos = xP;
		yPos = yP;
        rangeTraveled = 0;
        maxRange = maximumRange;
	}
	
	//TODO: keep old position for bullet drag
	public void render(PApplet context)
	{
		context.rect(xPos, yPos, 1, 1);
	}
	
	//TODO: check for collision
	public void update()
	{
		xDrag = xPos;
		yDrag = yPos;
		
		xPos += xVel;
		yPos += yVel;

        rangeTraveled += bulletVelocity;
	}

    public boolean isGarbage(){
        return (rangeTraveled > maxRange );

    }
}
