package com.stewsters.weapons.gun.prototype;

import com.stewsters.LepEngine;
import com.stewsters.Person;
import com.stewsters.physics.Bullet;
import com.stewsters.weapons.Weapon;
import com.stewsters.weapons.gun.attachment.Magazine;
import com.stewsters.weapons.gun.receiver.Automatic;
import com.stewsters.weapons.gun.receiver.SemiAutomatic;
import org.jbox2d.common.Vec2;

/**
 * This is a basic semi-auto pistol
 */
public class Shotgun extends Gun implements Weapon {


    public Shotgun() {
        deviance = 0.1f;
        triggerDown = false;
        receiver = new SemiAutomatic();
        msBetweenShots = 1000; // 60 rpm
        lastFired = 0;
        bulletRemovalSpeed = 0.2f;    //50m effective
        muzzleVelocity = 100.f;  //375m/s
    }

    @Override
    public void reload(Person holder, float xClick, float yClick) {
        ((SemiAutomatic) receiver).changeMags(new Magazine(8, 8));
        receiver.cock();
    }

    public void pullTrigger(Person holder, float xClick, float yClick) {
        Vec2 holderPosition = holder.body.getPosition();

        if (lastFired + msBetweenShots < System.currentTimeMillis()) {
            float xDiff = (float) xClick - holderPosition.x;
            float yDiff = (float) yClick - holderPosition.y;

            Vec2 diff = new Vec2(xDiff, yDiff);

            if (receiver.pullTrigger()) {

                for (int i = 0; i < 10; i++) {
                    Bullet bullet = new Bullet(holderPosition.add(new Vec2(2, 2)), diff, muzzleVelocity, bulletRemovalSpeed);
                    LepEngine.bullets.add(bullet);
                }
                lastFired = System.currentTimeMillis();

            }
        }
        //remove a bullet from the clip
    }
}
