package com.stewsters;

import com.stewsters.physics.Game;
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

    public float bulletWidth = 0.5f;
    public float minFlightSpeedSquared;

    public Bullet(Vec2 startingPos,  Vec2 bulletVelocity,float velocity, float velocityPercentage) {

        bulletVelocity.normalize();
        bulletVelocity.mulLocal(velocity);


        dynamicBodyDef = new BodyDef();
        dynamicBodyDef.type = BodyType.DYNAMIC;
        dynamicBodyDef.position = startingPos;

        body = Game.world.createBody(dynamicBodyDef);
        body.setLinearDamping(.1f);

        shape = new PolygonShape();
        shape.setAsBox(bulletWidth / 2f, bulletWidth / 2f);
        dynamicFixDef = new FixtureDef();
        dynamicFixDef.shape = shape;
        dynamicFixDef.density = 1.0f;
        dynamicFixDef.friction = 1f;

        body.createFixture(dynamicFixDef);
        body.setLinearVelocity(bulletVelocity);

        minFlightSpeedSquared = (float)Math.pow((double)(velocity * velocityPercentage), 2.0);
    }

    public void render(PApplet context) {
        context.noStroke();

//        Vec2 pos = body.getPosition();
//        Vec2 vel = body.getLinearVelocity();
//        context.line(pos.x - vel.x, pos.y - vel.y, pos.x,pos.y);
        context.rect(body.getPosition().x, body.getPosition().y, bulletWidth, bulletWidth);
    }

    //TODO: check for collision
    public boolean update() {

        if (body.getLinearVelocity().lengthSquared() < minFlightSpeedSquared) {
            System.out.println("boom");
            destroy();
            return true;
        } else
            return false;
    }

    public void destroy() {
        Game.world.destroyBody(body);
    }

}
