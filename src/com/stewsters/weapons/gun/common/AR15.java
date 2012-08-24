package com.stewsters.weapons.gun.common;

import com.stewsters.Person;
import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.attachment.Magazine;
import com.stewsters.weapons.gun.prototype.Gun;
import com.stewsters.weapons.gun.receiver.SemiAutomatic;

public class AR15 extends Gun implements Weapon {

    public AR15() {
        deviance = 0.1f;
        triggerDown = false;
        receiver = new SemiAutomatic();
        msBetweenShots = 200; // 150 rpm
        lastFired = 0;
        bulletRemovalSpeed = 0.2f;      //50m effective
        muzzleVelocity = 375.f;  //375m/s
    }

    @Override
    public void reload(Person holder, float xClick, float yClick) {
        ((SemiAutomatic) receiver).changeMags(new Magazine(20, 20));
        receiver.cock();
    }


}
