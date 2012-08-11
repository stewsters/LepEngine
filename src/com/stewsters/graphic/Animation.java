package com.stewsters.graphic;

import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;

class Animation {
    public static final String baseAnimationDir = "asset/image/animation";

    PImage[] images;
    int imageCount;
    int frame;

    Animation(PApplet context, String imagePrefix) {

        File animationFolder = new File(baseAnimationDir + File.pathSeparator + imagePrefix);
        File[] files = animationFolder.listFiles();

        imageCount = files.length;
        images = new PImage[imageCount];

        for (int i = 0; i < imageCount; i++) {
            // Use nf() to number format 'i' into four digits
            String filename = files[i].getAbsolutePath();
            images[i] = context.loadImage(filename);
        }
    }

    void display(PApplet context, float xpos, float ypos) {
        frame = (frame + 1) % imageCount;
        context.image(images[frame], xpos, ypos);
    }

    int getWidth() {
        return images[0].width;
    }
}