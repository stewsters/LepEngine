package com.stewsters.weapons;

import com.stewsters.Person;


public interface Weapon {

	
	public void click(Person holder, int xClick, int yClick);

	public void unclick(Person me, int mouseX, int mouseY);
	
	public void update();
	
}
