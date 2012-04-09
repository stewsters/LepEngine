package com.stewsters;

import com.stewsters.weapons.Weapon;

import processing.core.PApplet;

public class Person {

	public float xPos = 100.f;
	public float yPos = 100.f;
	public float xVel = 0.f;
	public float yVel = 0.f;
	public Weapon weapon;
	
	public void render(PApplet context)
	{
		context.rect(xPos, yPos, 5, 5);
	}
	
	public void update()
	{
		xPos += xVel;
		yPos += yVel;
		
	}
}
