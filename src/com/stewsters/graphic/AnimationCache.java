package com.stewsters.graphic;

import processing.core.PApplet;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *  This stores animations
 */
public class AnimationCache {
    public static String baseAnimationDir;

    private static Map<String, Animation> cache;

    public static void init(String newBaseAnimationDir){
        cache = new HashMap<String, Animation>();
        baseAnimationDir = newBaseAnimationDir;
    }

    public static Animation getAnimation(PApplet context, String name){
        if(!cache.containsKey(name)){
            cache.put(name, new Animation(context, baseAnimationDir + File.separator+ name));
        }
        return cache.get(name);
    }

}
