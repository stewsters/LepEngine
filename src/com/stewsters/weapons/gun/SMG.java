package com.stewsters.weapons.gun;

import com.stewsters.Person;
import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.attachment.Magazine;
import com.stewsters.weapons.gun.receiver.Automatic;

public class SMG extends Gun implements Weapon {

    public SMG() {
        deviance = 0.2f;
        triggerDown = false;
        receiver = new Automatic();
        msBetweenShots = 100; // 300 rpm
        lastFired = 0;
        maxRange = 200.f;      //50m effective
        muzzleVelocity = 5.f;  //375m/s
    }

    public void rightClick(Person holder, int xClick, int yClick) {
        ((Automatic) receiver).changeMags(new Magazine(30, 30));
        receiver.cock();
    }

}
