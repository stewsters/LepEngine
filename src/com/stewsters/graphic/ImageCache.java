package com.stewsters.graphic;


import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ImageCache {

    public static String baseTileDir;
    private static Map<String, PImage> cache;

    public static void init(String newBaseTileDir) {
        cache = new HashMap<String, PImage>();
        baseTileDir = newBaseTileDir;
    }

    public static PImage getPImage(PApplet context, String name) {
        if (!cache.containsKey(name)) {
            File file = new File(baseTileDir + File.separator + name);
            if (file == null) return null;
            cache.put(name, context.loadImage(file.getAbsolutePath()));
        }
        return cache.get(name);
    }

}
