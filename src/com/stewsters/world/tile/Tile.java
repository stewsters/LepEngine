package com.stewsters.world.tile;


import com.stewsters.graphic.ImageCache;
import org.jbox2d.common.Vec2;
import processing.core.PApplet;
import processing.core.PImage;

public class Tile {

    PImage image;
    Vec2 center;

    public Tile(PApplet context, String path, Vec2 worldCoordCenter){
        image = ImageCache.getPImage(context, path);
        center = worldCoordCenter;
    }

    public void render(PApplet context){
        context.image(image,center.x,center.y);
    }

}
