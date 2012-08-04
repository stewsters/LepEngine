package com.stewsters.weapons.gun.receiver;

import com.stewsters.Bullet;
import com.stewsters.LepEngine;
import com.stewsters.Person;
import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.Gun;
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



}
