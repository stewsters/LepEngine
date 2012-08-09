package com.stewsters.physics;


import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import processing.core.PApplet;

public class Wall {
    BodyDef bodyDef;
    Body body;
    PolygonShape wallBox;

    Vec2 physicsCenter;
    Vec2 physicsDimensions;

    public Wall(Vec2 center, Vec2 dimensions) {

        physicsCenter = center;
        physicsDimensions = dimensions;

        bodyDef = new BodyDef();
        bodyDef.position.set(center);
        // Create Body in World.
        body = Game.world.createBody(bodyDef);
        wallBox = new PolygonShape();
        wallBox.setAsBox(dimensions.x, dimensions.y, new Vec2(0,0),0);
        body.createFixture(wallBox, 1.0f);
    }

    public static Wall createWall(Vec2 upperRight, Vec2 lowerLeft) {
        return new Wall(new Vec2((upperRight.x + lowerLeft.x) / 2f, (upperRight.y + lowerLeft.y) / 2f), upperRight.sub(lowerLeft));
    }

    public void render(PApplet context) {

        context.rect(physicsCenter.x, physicsCenter.y, physicsDimensions.x, physicsDimensions.y);
    }

}
