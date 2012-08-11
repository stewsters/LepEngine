package com.stewsters.physics;

import org.jbox2d.common.Vec2;
import processing.core.PApplet;

public class Camera {

    public static final int windowSizeX = 800;
    public static final int windowSizeY = 800;

    public static float zoom = 6;

    public static Vec2 target;



    public static void focusOnGame(PApplet context){

        context.translate(-zoom * target.x + (windowSizeX/2), zoom * target.y +(windowSizeX/2));
        context.scale(zoom,-zoom);

    }

    public static Vec2 cameraToGame(Vec2 click)
    {
        Vec2 translated = click.sub(new Vec2(-zoom * target.x + (windowSizeX/2), zoom * target.y +(windowSizeX/2)));
        return new Vec2( (translated.x /zoom) , (translated.y /-zoom) );
    }

}
