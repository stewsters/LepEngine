package com.stewsters.weapons;

import com.stewsters.Person;


public interface Weapon {


    public void leftClick(Person holder, float xClick, float yClick);

    public void rightClick(Person holder, float xClick, float yClick);

    public void leftRelease();
}
