package com.stewsters;

import com.stewsters.graphic.AnimationStore;
import com.stewsters.physics.Bullet;
import com.stewsters.physics.Camera;
import com.stewsters.physics.Game;
import com.stewsters.physics.Wall;
import com.stewsters.weapons.gun.common.AR15;
import com.stewsters.weapons.gun.prototype.SMG;
import org.jbox2d.common.Vec2;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Iterator;

public class LepEngine extends PApplet {


    public static Person me;
    public static ArrayList<Bullet> bullets;
    public static ArrayList<Wall> walls;

    public void setup() {
        AnimationStore.init("/home/bloodred/privatecode/LepEngine/asset/image/animation");
        Game.initialize();
        rectMode(CENTER);

        size(Camera.windowSizeX, Camera.windowSizeY);
        me = new Person(this);
        me.weapon = new AR15();

        bullets = new ArrayList<Bullet>();
        walls = new ArrayList<Wall>();

        walls.add( new Wall(new Vec2(60, 60), new Vec2(40, 20)));
        walls.add( new Wall(new Vec2(-50, 50), new Vec2(20, 40)));
        walls.add( new Wall(new Vec2(-50, -50), new Vec2(20, 40)));
        walls.add(new Wall(new Vec2(50, -50), new Vec2(20, 40)));

        frameRate(30);
    }

    public void draw() {
        background(64);

        //Updates

        me.update();
        Game.step();

        pushMatrix();
        Camera.target = me.body.getPosition();
        Camera.focusOnGame(this);


        Vec2 gameCoord = Camera.cameraToGame(new Vec2(mouseX, mouseY));
        Vec2 facing = new Vec2(me.body.getPosition().x - gameCoord.x, me.body.getPosition().y - gameCoord.y);
        me.rotation = (float)Math.atan2(-facing.x, facing.y);

        if (mousePressed) {
            if (mouseButton == LEFT)
                me.weapon.pullTrigger(me, gameCoord.x, gameCoord.y);
            else if (mouseButton == RIGHT)
                me.weapon.reload(me, gameCoord.x, gameCoord.y);
        } else {
            me.weapon.releaseTrigger();
        }



        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().update())
                iterator.remove();
        }


        //Renders
        for(Wall wall : walls){
            wall.render(this);
        }

        me.render(this);
        for (Bullet bullet : bullets) {
            bullet.render(this);
        }

        if(p != null)
            p.render(this);
        popMatrix();

    }


    /**
     * Controls
     */
    Person p;

    public void keyPressed() {

        if (key == 'w') {
            me.animationManager.setAnimation(this,"character/walk",false);
            me.acceleration.y = me.maxSpeed;
        } else if (key == 's') {
            me.animationManager.setAnimation(this,"character/walk",false);
            me.acceleration.y = -me.maxSpeed;
        } else if (key == 'a') {
            me.animationManager.setAnimation(this,"character/walk",false);
            me.acceleration.x = -me.maxSpeed;
        } else if (key == 'd') {
            me.animationManager.setAnimation(this,"character/walk",false);
            me.acceleration.x = me.maxSpeed;
        }

        if(key == 'x'){
            println("x pushed");
            p = new Person(this);
        }
    }

    public void keyReleased() {

        if (key == 'w') {
            me.acceleration.y = min(0, me.acceleration.y);
        } else if (key == 's') {
            me.acceleration.y = max(0, me.acceleration.y);
        } else if (key == 'a') {
            me.acceleration.x = max(0, me.acceleration.x);
        } else if (key == 'd') {
            me.acceleration.x = min(0, me.acceleration.x);
        }
    }


//    //Find trajectory and make a projectile
//    public void mousePressed() {
//
//        if (me.weapon != null) {
//            me.weapon.pullTrigger(me, mouseX, mouseY);
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