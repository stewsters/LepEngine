package com.stewsters;

import com.stewsters.physics.Game;
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


    public static Person me;
    public static ArrayList<Bullet> bullets;



    public void setup() {

//        AABB boundingBox = new AABB( new Vec2(-1000f,-1000f),new Vec2(1000f,1000f));

        Game.initialize();


        size(400, 400);
        me = new Person();
        me.weapon = new Magnum();
        bullets = new ArrayList<Bullet>();

        frameRate(30);
    }

    public void draw() {
        background(64);

        //Updates
        me.update();

        Game.step();


        if (mousePressed) {
            if (mouseButton == LEFT)
                me.weapon.leftClick(me, mouseX, mouseY);
            else if (mouseButton == RIGHT)
                me.weapon.rightClick(me, mouseX, mouseY);
        } else {
            me.weapon.leftRelease();
        }



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
            me.velocity.y = -me.maxSpeed;
        } else if (key == 's') {
            me.velocity.y = me.maxSpeed;
        } else if (key == 'a') {
            me.velocity.x = -me.maxSpeed;
        } else if (key == 'd') {
            me.velocity.x = me.maxSpeed;
        }
    }

    public void keyReleased() {

        if (key == 'w') {
            me.velocity.y = max(0, me.velocity.y);
        } else if (key == 's') {
            me.velocity.y = min(0, me.velocity.y);
        } else if (key == 'a') {
            me.velocity.x = max(0, me.velocity.x);
        } else if (key == 'd') {
            me.velocity.x  = min(0, me.velocity.x);
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