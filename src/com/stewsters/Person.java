package com.stewsters;

import com.stewsters.physics.Game;
import com.stewsters.weapons.Weapon;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import processing.core.PApplet;

public class Person {

    /*physics*/
    Body body;
    BodyDef dynamicBodyDef;
    PolygonShape shape;
    FixtureDef dynamicFixDef;

    //char
    float maxSpeed = 50f;
    Vec2 velocity;
    public Weapon weapon;

    public Person(){
        velocity = new Vec2(0,0);

        dynamicBodyDef = new BodyDef();
        dynamicBodyDef.type = BodyType.DYNAMIC;
        dynamicBodyDef.position = new Vec2( 0f, 0f );
        body = Game.world.createBody( dynamicBodyDef );

        shape = new PolygonShape();
        shape.setAsBox( 1, 1 );
        dynamicFixDef = new FixtureDef();
        dynamicFixDef.shape = shape;
        dynamicFixDef.density = 1.0f;
        dynamicFixDef.friction = 0.3f;
        body.createFixture( dynamicFixDef );
    }

    public final int pixelWidth = 16;



	
	public void render(PApplet context)
	{
        Vec2 graphicPos = Game.gameCoordsToDisplay(body.getPosition());
		context.rect(graphicPos.x -(pixelWidth/2), graphicPos.y -(pixelWidth/2), pixelWidth, pixelWidth);
	}


	
	public void update()
	{
        body.setLinearVelocity(velocity);

	}
}
