package test;

import com.stewsters.graphic.Animation;
import com.stewsters.graphic.AnimationManager;
import com.stewsters.graphic.AnimationStore;
import processing.core.PApplet;

import java.util.Random;

import static java.lang.System.currentTimeMillis;

public class AnimationTest extends PApplet {

    AnimationManager manager;
    Random random;

    @Override
    public void setup() {
        size(200, 200);
        frameRate(30);
        AnimationStore.init();
        manager = new AnimationManager(this,"zombie/stand");
        //animation = new Animation(this, "zombie/walk");
        random = new Random();
    }

    @Override
    public void draw() {

        background(200);

        manager.display(this, 50, 50);

    }
    @Override
    public void mousePressed()
    {
        manager.setAnimation(this,"zombie/walk",false);
        manager.face((float) (2f*((float)mouseX / 200f)*Math.PI));

    }



}
