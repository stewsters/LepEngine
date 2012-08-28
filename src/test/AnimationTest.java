package test;

import com.stewsters.graphic.AnimationCache;
import com.stewsters.graphic.AnimationManager;
import com.stewsters.graphic.ImageCache;
import com.stewsters.world.tile.Tile;
import org.jbox2d.common.Vec2;
import processing.core.PApplet;
import processing.core.PImage;

public class AnimationTest extends PApplet {

    AnimationManager manager;
    Tile tile;

    @Override
    public void setup() {
        size(200, 200);
        frameRate(30);
        ImageCache.init("/home/bloodred/code/LepEngine/asset/image/tile");
        AnimationCache.init("/home/bloodred/code/LepEngine/asset/image/animation");

        manager = new AnimationManager(this, "zombie/stand");
        tile = new Tile(this, "road.png", new Vec2(10, 10));
    }

    @Override
    public void draw() {

        background(200);
        manager.display(this, 50, 50, (float) (2f * ((float) mouseX / 200f) * Math.PI));

        tile.render(this);
    }

    @Override
    public void mousePressed() {
        manager.setAnimation(this, "zombie/walk", false);
    }

}
