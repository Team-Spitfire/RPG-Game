/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eainf_rpg;
/**
 *
 * @author benbartel
 */
public class Player {
    public String name;
    public int maxHp;
    public int currHp;
    public Weapon weapon;
    public Armor armor;
    public Enemy enemy;

    public Player(String name) {
        maxHp = 100;
        currHp = 100;
        this.name = name;
    }

    public void weaponHit () {
        int dmg = weapon.getAtk();
        enemy.getDamage(dmg);
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
    
        
        
        
    
        
        
}