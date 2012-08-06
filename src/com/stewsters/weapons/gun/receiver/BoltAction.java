package com.stewsters.weapons.gun.receiver;


import com.stewsters.weapons.gun.attachment.Magazine;

//This should be similar to a mosin-nagant
// sa
public class BoltAction implements Receiver {

    long timeToReload = 500;
    long lastReloaded = 0;


    boolean cocked = false;
    boolean chamber = false;
    boolean released = true;

    Magazine magazine = new Magazine(5, 5);


    @Override
    public boolean cock() {
        long currentTime = System.currentTimeMillis();
        if (lastReloaded + timeToReload < currentTime) {
            cocked = true;
            chamber = magazine.removeRound();
            lastReloaded = currentTime;
            return true;
        } else return false;
    }

    @Override
    public void leftRelease() {
        released = true;
    }


    /**
     * pull trigger
     * uncocks, empties chamber, and may reload
     *
     * @return
     */
    @Override
    public boolean fireRound() {
        if (!released)
            return false;

        if (!cocked)
            return false;

        if (!chamber) { //click, no ammo fired
            cocked = false;
            return false;
        }
        released = false;
        chamber = false;
        cocked = false;
        return true;

    }


    /**
     * Replace the mag.  //TODO: we need to make this take time.
     *
     * @param freshMag
     * @return
     */
    public Magazine changeMags(Magazine freshMag) {
        Magazine oldMag = magazine;
        magazine = freshMag;
        return oldMag;
    }


}
