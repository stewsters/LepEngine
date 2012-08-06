package com.stewsters.weapons.gun;

import com.stewsters.Bullet;
import com.stewsters.LepEngine;
import com.stewsters.Person;
import com.stewsters.weapons.gun.attachment.Magazine;
import com.stewsters.weapons.gun.receiver.*;

abstract public class Gun {

    public float deviance = 0.1f;
    public boolean triggerDown = false;
    public Receiver receiver;
    public int msBetweenShots = 500; // 120 rpm
    public int msToReload = 2000; // 2 second reload time
    public long lastFired = 0;
    public float maxRange = 100.f;      //50m effective
    public float muzzleVelocity = 5.f;  //375m/s


    //spawn a bullet 1 unit in front of use traveling in the direction specified by the click
    public void leftClick(Person holder, int xClick, int yClick) {

        if (lastFired + msBetweenShots < System.currentTimeMillis()) {
            float xDiff = (float) xClick - holder.xPos;
            float yDiff = (float) yClick - holder.yPos;

            if (receiver.fireRound()) {

                Bullet bullet = new Bullet(holder.xPos, holder.yPos, muzzleVelocity, xDiff, yDiff, maxRange);
                LepEngine.bullets.add(bullet);
                lastFired = System.currentTimeMillis();

            }
        }
        //remove a bullet from the clip
    }

    public void leftRelease() {
        receiver.leftRelease();
    }


    public void rightClick(Person holder, int xClick, int yClick) {
        if(receiver.getClass() == SemiAutomatic.class)
            ((SemiAutomatic) receiver).changeMags(new Magazine(20, 20));
        else if(receiver.getClass() == Automatic.class)
            ((Automatic) receiver).changeMags(new Magazine(30,30));
        else if(receiver.getClass() == Revolver.class){
            ((Revolver) receiver).reload();
        }
        else if(receiver.getClass() == BoltAction.class){
            ((BoltAction) receiver).cock();
        }
    }


}
