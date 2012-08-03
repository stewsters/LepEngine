package com.stewsters.weapons.gun;

import com.stewsters.Bullet;
import com.stewsters.LepEngine;
import com.stewsters.Person;
import com.stewsters.weapons.gun.attachment.Magazine;

abstract public class Gun {

    public float deviance = 0.1f;
    public boolean triggerDown = false;
    public Magazine magazine;
    public int msBetweenShots = 500; // 120 rpm
    public int msToReload = 2000; // 2 second reload time
    public long lastFired = 0;
    public float maxRange = 100.f;      //50m effective
    public float muzzleVelocity = 5.f;  //375m/s


    //spawn a bullet 1 unit in front of use traveling in the direction specified by the click
    public void click(Person holder, int xClick, int yClick) {

        if (lastFired + msBetweenShots < System.currentTimeMillis()) {
            float xDiff = (float) xClick - holder.xPos;
            float yDiff = (float) yClick - holder.yPos;

            if (magazine.removeRound()) {

                Bullet bullet = new Bullet(holder.xPos, holder.yPos, muzzleVelocity, xDiff, yDiff, maxRange);
                LepEngine.bullets.add(bullet);
                lastFired = System.currentTimeMillis();

            }
        }
        //remove a bullet from the clip
    }


    /**
     * Replace the mag.  //TODO: we need to make this take time.
     * @param freshMag
     * @return
     */
    public Magazine changeMags(Magazine freshMag){
        Magazine oldMag = magazine;
        magazine = freshMag;
        return oldMag;
    }

}
