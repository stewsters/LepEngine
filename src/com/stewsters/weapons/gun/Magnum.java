package com.stewsters.weapons.gun;

import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.receiver.Automatic;
import com.stewsters.weapons.gun.receiver.Revolver;

/**
 * This is a basic revolver
 *  think .357 S&W Magnum
 *
 */
public class Magnum extends Gun implements Weapon {


    public Magnum() {
        deviance = 0.1f;
        triggerDown = false;
        receiver = new Revolver();
        msBetweenShots = 500; // 600 rpm
        lastFired = 0;
        maxRange = 100.f;      //50m effective
        muzzleVelocity = 8.f;  //375m/s
    }


}
