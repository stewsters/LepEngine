package com.stewsters.weapons.gun.receiver;


import com.stewsters.weapons.gun.attachment.Magazine;

public interface Receiver {

    public boolean pullTrigger();

    public boolean cock();

    public void releaseTrigger();

}
