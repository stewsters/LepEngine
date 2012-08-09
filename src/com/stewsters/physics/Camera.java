package com.stewsters.physics;

import org.jbox2d.common.Vec2;
import processing.core.PApplet;

public class Camera {

    public static final int windowSizeX = 400;
    public static final int windowSizeY = 400;

    public static float zoom = 2;

    public static void focusOnGame(PApplet context, Vec2 target){

        context.translate(-zoom * target.x + (windowSizeX/2), zoom * target.y +(windowSizeX/2));
        context.scale(zoom,-zoom);

    }

}
