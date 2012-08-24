package com.stewsters.weapons.gun.prototype;


import com.stewsters.Person;
import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.receiver.BoltAction;

public class Rifle extends Gun implements Weapon {

    public Rifle() {
        deviance = 0.1f;
        triggerDown = false;
        receiver = new BoltAction();
        msBetweenShots = 500; // 600 rpm
        lastFired = 0;
        bulletRemovalSpeed = 0.2f;      //50m effective
        muzzleVelocity = 10.f;  //375m/s
    }

    @Override
    public void reload(Person holder, float xClick, float yClick)
    {
        ((BoltAction) receiver).cock();

    }



}
