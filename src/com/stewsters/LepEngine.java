package com.stewsters;

import com.stewsters.weapons.Pistol;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Iterator;

public class LepEngine extends PApplet {

    public static Person me;
    public static ArrayList<Bullet> bullets;

    public void setup() {
        size(200, 200);
        me = new Person();
        me.weapon = new Pistol();
        bullets = new ArrayList<Bullet>();

    }

    public void draw() {
        background(255);

        //Updates
        me.update();

        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()){
            if(iterator.next().update())
                iterator.remove();
        }


        //Renders
        me.render(this);
        for (Bullet bullet : bullets) {
            bullet.render(this);
        }

        //we need to loop over and delete bullet.isGarbage()


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


    //Find trajectory and make a projectile
    public void mousePressed() {

        if (me.weapon != null) {
            me.weapon.click(me, mouseX, mouseY);
        }

    }

    public void mouseReleased() {
        if (me.weapon != null) {
            me.weapon.unclick(me, mouseX, mouseY);
        }
    }



}