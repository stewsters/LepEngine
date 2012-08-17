package test;

import com.stewsters.graphic.Animation;
import com.stewsters.graphic.AnimationManager;
import com.stewsters.graphic.AnimationStore;
import processing.core.PApplet;

import static java.lang.System.currentTimeMillis;

public class AnimationTest extends PApplet {

    AnimationManager manager;
    @Override
    public void setup() {
        size(200, 200);
        frameRate(30);
        AnimationStore.init();
        manager = new AnimationManager(this,"zombie/stand");
        //animation = new Animation(this, "zombie/walk");

    }

    @Override
    public void draw() {

        background(200);
        manager.display(this, 10, 10);

    }
    @Override
    public void mousePressed()
    {
        manager.setAnimation(this,"zombie/walk",false);
    }



}
