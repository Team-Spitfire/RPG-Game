/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eainf_rpg;

import java.io.IOException;

/**
 *
 * @author benbartel
 */
public class Enemy {
    public String name;
    public int maxHp;
    public int currHp;
    public Weapon weapon;
    public Armor armor;
    public Player player;
    
    public Enemy() {
        maxHp = 100;
        currHp = 100;
    }
    
    public void enemyTurn() throws IOException{
        if(currHp < 10){
            usePotion();
        }
        else{
           // rangeCheck();
        }
    }
    /*
    public void rangeCheck(){
        if(){
            
        }
    }
    */
    
    public void weaponHit() throws IOException {
        int dmg = weapon.getAtk();
        player.getDamage(dmg);
    }
    
    public void getDamage(int dmg){
       currHp = currHp - dmg;
       boolean tot = obGestorben();
       if(tot = true){
            dead();
        }
    }
    
    public boolean obGestorben(){
        boolean gestorben;
        if(currHp <= 0){
            gestorben = true;
        } 
        else{
            gestorben = false;
        }
            return gestorben;
    }
    
    public void dead(){
        
    }
    
    private void usePotion() {
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrHp() {
        return currHp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setCurrHp(int currHp) {
        this.currHp = currHp;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    
    
           
}
