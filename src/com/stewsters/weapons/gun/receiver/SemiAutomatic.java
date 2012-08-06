package com.stewsters.weapons.gun.receiver;


import com.stewsters.weapons.gun.attachment.Magazine;

public class SemiAutomatic implements Receiver {

    //TODO: add chamber
    Magazine magazine = new Magazine(20,20);



    public boolean removeRound(){
        return magazine.removeRound();
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
