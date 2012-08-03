package com.stewsters.weapons.gun.attachment;


public class Magazine {

    //TODO: keep track of bullets, return the correct one, also keep track of type (9mm hollowpoint)
    private int maxRounds = 8;
    private int currentRounds = 0;

    public Magazine(int maxRounds, int currentRounds)
    {
        this.maxRounds = maxRounds;
        this.currentRounds = currentRounds;
    }

    public boolean removeRound(){
        if(currentRounds > 0){
            currentRounds--;
            return true;
        }else{
            return false;
        }
    }

    public boolean addRound(){
        if(currentRounds < maxRounds){
            currentRounds++;
            return true;
        }else{
            return false;
        }
    }

}
