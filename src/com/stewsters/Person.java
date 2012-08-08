package com.stewsters;

import com.stewsters.weapons.Weapon;

import org.jbox2d.collision.shapes.CircleDef;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.Body;
import processing.core.PApplet;

public class Person {

    public Person(){
        body = new Body();//CircleDef();

    }

    public final int pixelWidth = 16;

    public Body body;

	public float xPos = 100.f;
	public float yPos = 100.f;
	public float xVel = 0.f;
	public float yVel = 0.f;
    public Weapon weapon;
	
	public void render(PApplet context)
	{
		context.rect(xPos-(pixelWidth/2), yPos-(pixelWidth/2), pixelWidth, pixelWidth);
	}


	
//	public void update()
//	{
//		xPos += xVel;
//		yPos += yVel;
//
//	}
}
