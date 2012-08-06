package com.stewsters.weapons.gun.receiver;


import com.stewsters.weapons.gun.attachment.Magazine;

//TODO: add da, sa, and da/sa triggers
// sa
public class SemiAutomatic implements Receiver
{

    boolean cocked = false;
    boolean chamber = false;
    boolean released = true;

    Magazine magazine = new Magazine(20,20);

    @Override
    public boolean cock(){

        cocked = true;
        if(!chamber)
            chamber = magazine.removeRound();
        return true;
    }

    @Override
    public void leftRelease() {
        released = true;
    }


    /**
     * pull trigger
     * uncocks, empties chamber, and may reload
     * @return
     */
    @Override
    public boolean fireRound(){
        if(!released)
            return false;

        if(!cocked)
            return false;

        if(!chamber){ //click, no ammo fired
            cocked = false;
            return false;
        }
        released = false;
        chamber = magazine.removeRound();
        return true;

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
