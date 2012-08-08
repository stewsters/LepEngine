package com.stewsters;

import com.stewsters.weapons.gun.*;
import com.stewsters.weapons.gun.receiver.Revolver;
import org.jbox2d.collision.AABB;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import processing.core.PApplet;
import sun.font.PhysicalStrike;

import java.util.ArrayList;
import java.util.Iterator;

public class LepEngine extends PApplet {

    public World world;
    public static Person me;
    public static ArrayList<Bullet> bullets;

    public void setup() {

        AABB boundingBox = new AABB( new Vec2(-1000f,-1000f),new Vec2(1000f,1000f));
        world = new World(boundingBox, new Vec2(0,0), true);
        world.setContinuousPhysics(true);



        size(400, 400);
        me = new Person();
        me.weapon = new Magnum();
        bullets = new ArrayList<Bullet>();

        frameRate(30);
    }

    public void draw() {
        background(64);

        //Updates
//        me.update();


        if (mousePressed) {
            if (mouseButton == LEFT)
                me.weapon.leftClick(me, mouseX, mouseY);
            else if (mouseButton == RIGHT)
                me.weapon.rightClick(me, mouseX, mouseY);
        } else {
            me.weapon.leftRelease();
        }

        //30 physics frames per second
        world.step(1.0f/30, 10);

        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().update())
                iterator.remove();
        }


        //Renders
        me.render(this);
        for (Bullet bullet : bullets) {
            bullet.render(this);
        }

    }


    /**
     * Controls
     */
    public void keyPressed() {
        if (key == 'w') {
            me.yVel = -1;
        } else if (key == 's') {
            me.yVel = 1;
        } else if (key == 'a') {
            me.xVel = -1;
        } else if (key == 'd') {
            me.xVel = 1;
        }
    }

    public void keyReleased() {

        if (key == 'w') {
            me.yVel = max(0, me.yVel);
        } else if (key == 's') {
            me.yVel = min(0, me.yVel);
        } else if (key == 'a') {
            me.xVel = max(0, me.xVel);
        } else if (key == 'd') {
            me.xVel = min(0, me.xVel);
        }
    }


//    //Find trajectory and make a projectile
//    public void mousePressed() {
//
//        if (me.weapon != null) {
//            me.weapon.leftClick(me, mouseX, mouseY);
//        }
//
//    }
//
//    public void mouseReleased() {
//        if (me.weapon != null) {
//            me.weapon.unclick(me, mouseX, mouseY);
//        }
//    }


}