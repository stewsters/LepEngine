package com.stewsters.graphic;

import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;

public class Animation {
    public static final String baseAnimationDir = "/home/bloodred/code/LepEngine/asset/image/animation";

    PImage[] images;
    int imageCount;

    Long msRunTime = 1000l; //default is a ms

    public Animation(PApplet context, String imagePrefix) {
        File animationFolder = new File(baseAnimationDir + File.separator + imagePrefix);
        System.out.println(animationFolder.getAbsolutePath());
        File[] files = animationFolder.listFiles();

        imageCount = files.length;
        images = new PImage[imageCount];

        for (int i = 0; i < imageCount; i++) {
            String filename = files[i].getAbsolutePath();
            images[i] = context.loadImage(filename);
        }
    }

    public void display(PApplet context, Long frameTime, float xpos, float ypos) {

        int frame = (int)Math.floor(( (float)(frameTime % msRunTime)  / (float) msRunTime) * imageCount);
        context.image(images[frame], xpos, ypos);
    }

    public int getWidth() {
        return images[0].width;
    }
}