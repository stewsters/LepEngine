package com.stewsters.physics;

import org.jbox2d.common.Vec2;

import org.jbox2d.dynamics.World;


public class Game {

    public static World world;
    static final float timeStep = 1.0f / 30.0f;
    static final int velocityIterations = 6;
    static final int positionIterations = 2;


    public static void initialize() {

        world = new World(new Vec2(0,0.1f), true);
        //30 physics frames per second
//
        position = new Vec2(100,100);
    }


    public static void destroy(){
        world = null;
    }


    //Visual

    static Vec2 scale;
    static Vec2 position;
    //TODO:scale, rotate?
    public static Vec2 gameCoordsToDisplay(Vec2 gameCoord){
        return gameCoord.add(position);
    }

    public static void step() {

        world.step( timeStep, velocityIterations, positionIterations );
        world.clearForces();
    }
}
