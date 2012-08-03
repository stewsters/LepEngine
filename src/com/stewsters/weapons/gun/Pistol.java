package com.stewsters.weapons.gun;

import com.stewsters.Bullet;
import com.stewsters.LepEngine;
import com.stewsters.Person;
import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.attachment.Magazine;

/**
 * This is a basic semi-auto pistol
 */
public class Pistol extends Gun implements Weapon {



    public Pistol(){
        deviance = 0.1f;
        triggerDown = false;
        magazine = new Magazine(20,20);
        msBetweenShots = 500; // 600 rpm
        lastFired = 0;
        maxRange = 100.f;      //50m effective
        muzzleVelocity = 5.f;  //375m/s
    }

    //spawn a bullet 1 unit in front of use traveling in the direction specified by the click
    public void click(Person holder, int xClick, int yClick) {

        if (lastFired + msBetweenShots < System.currentTimeMillis()) {
            float xDiff = (float) xClick - holder.xPos;
            float yDiff = (float) yClick - holder.yPos;

            Bullet bullet = new Bullet(holder.xPos, holder.yPos, muzzleVelocity, xDiff, yDiff, maxRange);
            LepEngine.bullets.add(bullet);
            lastFired = System.currentTimeMillis();
        }
        //remove a bullet from the clip
    }



}
