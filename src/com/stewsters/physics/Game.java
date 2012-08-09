package com.stewsters.physics;

import org.jbox2d.common.Vec2;

import org.jbox2d.dynamics.World;

public class Game {

    public static World world;
    static final float timeStep = 1.0f / 30.0f;
    static final int velocityIterations = 6;
    static final int positionIterations = 2;


    public static void initialize() {
        world = new World(new Vec2(0f, 0f), true);
    }


    public static void destroy() {
        world = null;
    }


    public static void step() {

        world.step(timeStep, velocityIterations, positionIterations);
        world.clearForces();
    }
}
