package com.stewsters.weapons.gun;

import com.stewsters.Bullet;
import com.stewsters.LepEngine;
import com.stewsters.Person;
import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.Gun;
import com.stewsters.weapons.gun.attachment.Magazine;
import com.stewsters.weapons.gun.receiver.SemiAutomatic;

public class AssaultRifle extends Gun implements Weapon {

    public AssaultRifle(){
        deviance = 0.1f;
        triggerDown = false;
        receiver = new SemiAutomatic();
        msBetweenShots = 100; // 600 rpm
        lastFired = 0;
        maxRange = 100.f;      //50m effective
        muzzleVelocity = 5.f;  //375m/s
    }


}
