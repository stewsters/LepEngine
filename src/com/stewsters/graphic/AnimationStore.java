package com.stewsters.graphic;

import processing.core.PApplet;

import java.util.HashMap;
import java.util.Map;

/**
 *  This stores animations
 */
public class AnimationStore {

    private static Map<String, Animation> store;

    public static void init(){
        store = new HashMap<String, Animation>();
    }


    public static Animation getAnimation(PApplet context, String name){
        if(!store.containsKey(name)){
            store.put(name, new Animation(context,name));
        }
        return store.get(name);
    }


}
