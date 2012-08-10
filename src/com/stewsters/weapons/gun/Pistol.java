package com.stewsters.weapons.gun;

import com.stewsters.Person;
import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.attachment.Magazine;
import com.stewsters.weapons.gun.receiver.Automatic;
import com.stewsters.weapons.gun.receiver.SemiAutomatic;

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
        bulletRemovalSpeed = 0.2f;    //50m effective
        muzzleVelocity = 5.f;  //375m/s
    }

    @Override
    public void rightClick(Person holder, float xClick, float yClick) {
        ((SemiAutomatic) receiver).changeMags(new Magazine(8, 8));
        receiver.cock();
    }

}
