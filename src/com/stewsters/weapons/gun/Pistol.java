package com.stewsters.weapons.gun;

import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.receiver.Automatic;

/**
 * This is a basic semi-auto pistol
 */
public class Pistol extends Gun implements Weapon {


    public Pistol() {
        deviance = 0.1f;
        triggerDown = false;
        receiver = new Automatic();
        msBetweenShots = 500; // 600 rpm
        lastFired = 0;
        maxRange = 100.f;      //50m effective
        muzzleVelocity = 5.f;  //375m/s
    }


}