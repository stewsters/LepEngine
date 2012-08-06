package com.stewsters.weapons;

import com.stewsters.Person;


public interface Weapon {


    public void leftClick(Person holder, int xClick, int yClick);

    public void rightClick(Person holder, int xClick, int yClick);

    public void leftRelease();
}
