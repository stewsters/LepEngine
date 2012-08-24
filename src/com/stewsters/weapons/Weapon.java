package com.stewsters.weapons;

import com.stewsters.Person;


public interface Weapon {


    public void pullTrigger(Person holder, float xClick, float yClick);

    public void reload(Person holder, float xClick, float yClick);

    public void releaseTrigger();
}
