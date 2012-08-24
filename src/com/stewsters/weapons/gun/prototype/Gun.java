package com.stewsters.weapons.gun.prototype;

import com.stewsters.physics.Bullet;
import com.stewsters.LepEngine;
import com.stewsters.Person;
import com.stewsters.weapons.gun.attachment.Magazine;
import com.stewsters.weapons.gun.receiver.*;
import org.jbox2d.common.Vec2;

abstract public class Gun {

    public float deviance = 0.1f;
    public boolean triggerDown = false;
    public Receiver receiver;
    public int msBetweenShots = 500; // 120 rpm
    public int msToReload = 2000; // 2 second reload time
    public long lastFired = 0;
    public float bulletRemovalSpeed = 0.2f;      //50m effective
    public float muzzleVelocity = 5.f;  //375m/s


    //spawn a bullet 1 unit in front of use traveling in the direction specified by the click
    public void pullTrigger(Person holder, float xClick, float yClick) {
        Vec2 holderPosition = holder.body.getPosition();

        if (lastFired + msBetweenShots < System.currentTimeMillis()) {
            float xDiff = (float) xClick - holderPosition.x;
            float yDiff = (float) yClick - holderPosition.y;

            Vec2 diff = new Vec2(xDiff, yDiff);

            if (receiver.pullTrigger()) {

                Bullet bullet = new Bullet(holderPosition.add(new Vec2(2,2)), diff,muzzleVelocity, bulletRemovalSpeed);
                LepEngine.bullets.add(bullet);
                lastFired = System.currentTimeMillis();

            }
        }
        //remove a bullet from the clip
    }

    public void releaseTrigger() {
        receiver.releaseTrigger();
    }


    public void rightClick(Person holder, float xClick, float yClick) {
        if(receiver.getClass() == SemiAutomatic.class)
            ((SemiAutomatic) receiver).changeMags(new Magazine(20, 20));
        else if(receiver.getClass() == Automatic.class)
            ((Automatic) receiver).changeMags(new Magazine(30,30));
        else if(receiver.getClass() == Revolver.class){
            ((Revolver) receiver).reload();
        }
        else if(receiver.getClass() == BoltAction.class){

        }
    }


}
