package com.stewsters.weapons.gun;

import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.receiver.Automatic;
import com.stewsters.weapons.gun.receiver.SemiAutomatic;

public class AssaultRifle extends Gun implements Weapon {

    public AssaultRifle(){
        deviance = 0.1f;
        triggerDown = false;
        receiver = new SemiAutomatic();
        msBetweenShots = 200; // 300 rpm
        lastFired = 0;
        maxRange = 150.f;      //50m effective
        muzzleVelocity = 7.f;  //375m/s
    }


}
