package com.stewsters.physics;


import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;

public class Wall {
    BodyDef bodyDef;
    Body body;
    PolygonShape wallBox;

    public Wall(){

        bodyDef = new BodyDef();
        bodyDef.position.set( 0, -10.0f );
        // Create Body in World.
        body = Game.world.createBody( bodyDef );
        wallBox = new PolygonShape();
        wallBox.setAsBox( 50.0f, 10.0f );
        body.createFixture( wallBox, 1.0f );
    }

}
