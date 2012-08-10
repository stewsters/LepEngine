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
    public Body body;
    BodyDef dynamicBodyDef;
    PolygonShape shape;
    FixtureDef dynamicFixDef;


    //char
    float maxSpeed = 50f;
    Vec2 acceleration;
    public Weapon weapon;

    float personWidth = 1.f;

    public Person() {
        acceleration = new Vec2(0, 0);

        dynamicBodyDef = new BodyDef();
        dynamicBodyDef.type = BodyType.DYNAMIC;
        dynamicBodyDef.position = new Vec2(0f, 0f);
        body = Game.world.createBody(dynamicBodyDef);
        body.setLinearDamping(4f);

        shape = new PolygonShape();
        shape.setAsBox(personWidth/2f, personWidth/2f);
        dynamicFixDef = new FixtureDef();
        dynamicFixDef.shape = shape;
        dynamicFixDef.density = 1.0f;
        dynamicFixDef.friction = 1f;

        body.createFixture(dynamicFixDef);


    }

    public void destroy() {
        Game.world.destroyBody(body);
    }



    public void render(PApplet context) {
        context.stroke(255,0,0);
        context.rect(body.getPosition().x, body.getPosition().y, personWidth, personWidth);
    }


    public void update() {
        body.applyLinearImpulse(acceleration, dynamicBodyDef.position);

    }
}
