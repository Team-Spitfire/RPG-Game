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

    public Enemy(String name, int maxHp, int currHp, Weapon weapon, Armor armor) {
        this.name = name;
        this.maxHp = maxHp;
        this.currHp = currHp;
        this.weapon = weapon;
        this.armor = armor;
    }

    

    public void weaponHit() throws IOException {
        int dmg = weapon.getAtk();
        App.getPlayer().getDamage(dmg);
    }

    public void getDamage(int dmg) throws IOException {
        System.out.println("enemy hp" + currHp);
        
        currHp = currHp - dmg;
        System.out.println(currHp);
        
        
        
    }

    public boolean obGestorben() {
        boolean gestorben;
        if (currHp <= 0) {
            gestorben = true;
        } else {
            gestorben = false;
        }
        return gestorben;
    }

    public void dead() {
        
        App.getPlayer().enemyDied();
    }

    public void usePotion() {

    }

    private void genHp() {
        switch (App.getPlayer().getLevel()) {
            case 1:
                maxHp = 50;
                currHp = 50;
                break;
            case 2:
                maxHp = 80;
                currHp = 80;
                break;
            case 3:
                maxHp = 125;
                currHp = 125;
                break;
            default:
                break;
        }
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
