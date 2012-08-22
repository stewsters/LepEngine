package test;

import com.stewsters.graphic.AnimationManager;
import com.stewsters.graphic.AnimationStore;
import processing.core.PApplet;

public class AnimationTest extends PApplet {

    AnimationManager manager;

    @Override
    public void setup() {
        size(200, 200);
        frameRate(30);
        AnimationStore.init("/home/bloodred/code/LepEngine/asset/image/animation");
        manager = new AnimationManager(this, "zombie/stand");

    }

    @Override
    public void draw() {

        background(200);
        manager.display(this, 50, 50, (float) (2f * ((float) mouseX / 200f) * Math.PI));

    }

    @Override
    public void mousePressed() {
        manager.setAnimation(this, "zombie/walk", false);
    }

}
