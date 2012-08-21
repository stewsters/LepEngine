package com.stewsters.graphic;

import processing.core.PApplet;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *  This stores animations
 */
public class AnimationStore {
    public static String baseAnimationDir;

    private static Map<String, Animation> store;

    public static void init(String newBaseAnimationDir){
        store = new HashMap<String, Animation>();
        baseAnimationDir = newBaseAnimationDir;
    }

    public static Animation getAnimation(PApplet context, String name){
        if(!store.containsKey(name)){
            store.put(name, new Animation(context, baseAnimationDir + File.separator+ name));
        }
        return store.get(name);
    }

}
