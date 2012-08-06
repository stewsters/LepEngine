package com.stewsters.weapons.gun.receiver;


import com.stewsters.weapons.gun.attachment.Magazine;

public class Automatic implements Receiver {

    boolean cocked = false;
    boolean chamber = false;
    Magazine magazine = new Magazine(20, 20);

    @Override
    public boolean cock() {

        cocked = true;
        if (!chamber)
            chamber = magazine.removeRound();
        return true;
    }

    @Override
    public void leftRelease() {
        //doesnt really matter
    }


    /**
     * pull trigger
     * uncocks, empties chamber, and may reload
     *
     * @return
     */
    @Override
    public boolean fireRound() {
        if (!cocked)
            return false;

        if (!chamber) { //click, no ammo fired
            cocked = false;
            return false;
        }

        chamber = magazine.removeRound();
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
