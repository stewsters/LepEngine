package com.stewsters.graphic;

import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;

public class Animation {

    PImage[] images;
    int imageCount;

    public long msRunTime = 1000l; //default is a ms

    public Animation(PApplet context, String animationDir) {
        File animationFolder = new File( animationDir);
        System.out.println(animationFolder.getAbsolutePath());
        File[] files = animationFolder.listFiles();

        imageCount = files.length;
        images = new PImage[imageCount];

        for (int i = 0; i < imageCount; i++) {
            String filename = files[i].getAbsolutePath();
            images[i] = context.loadImage(filename);
        }

    }

    public void display(PApplet context, Long frameTime, float xpos, float ypos, float angle) {

        int frame = (int)Math.floor(( (float)(frameTime % msRunTime)  / (float) msRunTime) * imageCount);
        context.pushMatrix();
        context.translate(xpos, ypos);
        context.scale(1f/8f);
        context.rotate(angle);
        context.image(images[frame], -16,-16);

        context.popMatrix();
    }

    public int getWidth() {
        return images[0].width;
    }
}