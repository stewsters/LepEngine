package com.stewsters.graphic;

import processing.core.PApplet;

/**
 * This controls the animation for a character.  also variables for transitioning animations
 */
public class AnimationManager {

    //TODO: add some kind of animation queue that can call other events
    Animation defaultAnimation;
    Animation currentAnimation;
    long animationStartTime = 0l;
    boolean keepLooping = false;


    public AnimationManager(PApplet context, String defaultAnimationName){
        defaultAnimation = AnimationStore.getAnimation(context, defaultAnimationName);
        currentAnimation = defaultAnimation;
        animationStartTime = System.currentTimeMillis();
        keepLooping = true;
    }


    public void setAnimation(PApplet context, String animationName, boolean loop){
        currentAnimation = AnimationStore.getAnimation(context, animationName);
        animationStartTime = System.currentTimeMillis();
        keepLooping = loop;
    }

    public void stopAnimation()
    {
        currentAnimation = defaultAnimation;
        animationStartTime = System.currentTimeMillis();
        keepLooping = true;
    }

    public void display(PApplet context, int xPos, int yPos){

        long animationTime = System.currentTimeMillis() - animationStartTime;

        if(!keepLooping && animationTime > currentAnimation.msRunTime)
        {
            stopAnimation();
        }
        currentAnimation.display(context,animationTime,xPos,yPos);
    }


}
