package test;

import com.stewsters.graphic.Animation;
import processing.core.PApplet;

import static java.lang.System.currentTimeMillis;

public class AnimationTest extends PApplet {

    Animation animation;
    Animation standAnimation;

    @Override
    public void setup() {
        size(200, 200);
        frameRate(30);
        animation = new Animation(this, "zombie/walk");
        standAnimation = new Animation(this, "zombie/stand");
    }

    @Override
    public void draw() {

        background(200);
        animation.display(this, currentTimeMillis(), 10, 10);
        standAnimation.display(this, currentTimeMillis(), 40, 20);
    }


}
