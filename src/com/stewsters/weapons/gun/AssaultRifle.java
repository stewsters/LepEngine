package com.stewsters.weapons.gun;

import com.stewsters.Person;
import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.attachment.Magazine;
import com.stewsters.weapons.gun.receiver.SemiAutomatic;

public class AssaultRifle extends Gun implements Weapon {

    public AssaultRifle() {
        deviance = 0.1f;
        triggerDown = false;
        receiver = new SemiAutomatic();
        msBetweenShots = 200; // 300 rpm
        lastFired = 0;
        maxRange = 300.f;      //50m effective
        muzzleVelocity = 7.f;  //375m/s
    }

    public void rightClick(Person holder, int xClick, int yClick) {
        ((SemiAutomatic) receiver).changeMags(new Magazine(20, 20));
        receiver.cock();
    }


}
