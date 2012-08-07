package com.stewsters.weapons.gun;


import com.stewsters.Person;
import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.receiver.Automatic;
import com.stewsters.weapons.gun.receiver.BoltAction;

public class Rifle extends Gun implements Weapon {

    public Rifle() {
        deviance = 0.1f;
        triggerDown = false;
        receiver = new BoltAction();
        msBetweenShots = 500; // 600 rpm
        lastFired = 0;
        maxRange = 300.f;      //50m effective
        muzzleVelocity = 10.f;  //375m/s
    }

    public void rightClick(Person holder, int xClick, int yClick)
    {
        ((BoltAction) receiver).cock();


    }



}
