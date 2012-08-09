package com.stewsters.physics;

import org.jbox2d.common.Vec2;
import processing.core.PApplet;

public class Camera {

    public static final int windowSizeX = 400;
    public static final int windowSizeY = 400;

    public static float zoom = 2;

    public static Vec2 target;



    public static void focusOnGame(PApplet context){

        context.translate(-zoom * target.x + (windowSizeX/2), zoom * target.y +(windowSizeX/2));
        context.scale(zoom,-zoom);

    }

    public static Vec2 cameraToGame(Vec2 click)
    {
        return new Vec2( (click.x /zoom) , (click.y / -zoom) ).sub(new Vec2(-zoom * target.x + (windowSizeX/2),zoom * target.y +(windowSizeX/2)));


    }

}
