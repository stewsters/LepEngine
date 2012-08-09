package com.stewsters;

import com.stewsters.physics.Game;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import processing.core.PApplet;

public class Bullet {


    /*physics*/
    public Body body;
    BodyDef dynamicBodyDef;
    PolygonShape shape;
    FixtureDef dynamicFixDef;

	public Vec2 bulletVelocity;
	
	public float xPos;
	public float yPos;
	public float xVel;
	public float yVel;
	
	public float xDrag;
	public float yDrag;
    public float bulletWidth;

    public float rangeTraveled;
	public float maxRange;

	public Bullet(Vec2 startingPos, float velocity, float xVelUnscaled, float yVelUnscaled,float maximumRange){

		bulletVelocity  = new Vec2(xVelUnscaled,yVelUnscaled);
        bulletVelocity.normalize();
        bulletVelocity.mul(velocity);

        dynamicBodyDef = new BodyDef();
        dynamicBodyDef.type = BodyType.DYNAMIC;
        dynamicBodyDef.position = startingPos;

        body = Game.world.createBody(dynamicBodyDef);
        body.setLinearDamping(.01f);

        shape = new PolygonShape();
        shape.setAsBox(bulletWidth/2f, bulletWidth/2f);
        dynamicFixDef = new FixtureDef();
        dynamicFixDef.shape = shape;
        dynamicFixDef.density = 1.0f;
        dynamicFixDef.friction = 1f;

        body.createFixture(dynamicFixDef);
        body.setLinearVelocity(bulletVelocity);

        rangeTraveled = 0;
        maxRange = maximumRange;
	}

	public void render(PApplet context)
	{
        context.stroke(255,255,0);
//        Vec2 pos = body.getPosition();
//        Vec2 vel = body.getLinearVelocity();
//        context.line(pos.x - vel.x, pos.y - vel.y, pos.x,pos.y);
        context.rect(body.getPosition().x, body.getPosition().y, bulletWidth, bulletWidth);
	}
	
	//TODO: check for collision
	public boolean update()
	{
//        rangeTraveled += bulletVelocity.length();
//        return (rangeTraveled > maxRange );
        return false;
	}

}
