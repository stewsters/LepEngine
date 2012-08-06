package com.stewsters.weapons.gun.receiver;


import com.stewsters.weapons.gun.attachment.Magazine;

import java.security.PublicKey;

public class Revolver implements Receiver {

    boolean cocked = false;

    boolean released = true;

    int inlineChamber;
    int totalChambers;
    boolean[] chamber;

    public Revolver() {
        inlineChamber = 0;
        totalChambers = 6;
        chamber = new boolean[totalChambers];
    }


    @Override
    public boolean cock() {
        if (!cocked) {
            rotateCylinder();
            cocked = true;
            return true;
        } else
            return false;
    }

    private void rotateCylinder() {
        inlineChamber++;
        if (inlineChamber >= totalChambers)
            inlineChamber = 0;
    }

    @Override
    public void leftRelease() {
        if (released == false) {
            rotateCylinder();
            cocked = true;
            released = true;
        }
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

        if (!chamber[inlineChamber]) { //click, no ammo fired
            cocked = false;
            return false;
        }
        released = false;
        chamber[inlineChamber] = false;
        return true;

    }


    /**
     * Replace the mag.  //TODO: we need to make this take time.
     *
     * @return
     */
    public void reload(){
        for(int i = 0; i< totalChambers; i++)
        {
            chamber[i] = true;
        }

    }


}
