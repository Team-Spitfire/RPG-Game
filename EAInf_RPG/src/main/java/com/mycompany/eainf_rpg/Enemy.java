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
    
    
    public Enemy() {
        genHp();
        generateWeapon();
        generateArmor();
    }
    
    public void enemyTurn() throws IOException{
        
        
        
        
        
        
        if(currHp < 10){
            usePotion();
        }
        else{
            
            
            
            
        }
    }
    
    
    public void weaponHit() throws IOException {
        int dmg = weapon.getAtk();
        App.getPlayer().getDamage(dmg);
    }
    
    public void getDamage(int dmg) throws IOException{
       currHp = currHp - dmg;
       boolean tot = obGestorben();
       if(tot = true){
            dead();
       }
       else{
           enemyTurn();
       }
    }
    
    public boolean obGestorben(){
        boolean gestorben;
        gestorben = currHp <= 0;
            return gestorben;
    }
    
    public void dead(){
        App.getPlayer().enemyDied();
    }
    
    
    
    
    
    
    private void usePotion() {
        
    }
    
    private void genHp(){
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
    
    private void generateWeapon(){
        Weapon weaponLvl1 = new Weapon("WeaponLvl1", 10, 1, "Lvl1");
        Weapon weaponLvl2 = new Weapon("WeaponLvl2", 15, 2, "Lvl2");
        Weapon weaponLvl3 = new Weapon("WeaponLvl3", 20, 3, "Lvl3");
        
        switch (App.getPlayer().getLevel()) {
            case 1:
                weapon = weaponLvl1;
                break;
            case 2:
                weapon = weaponLvl2;
                break;
            case 3:
                weapon = weaponLvl3;
                break;
            default:
                break;
        }
    }
    
    private void generateArmor(){
        Armor armorLvl1 = new Armor("ArmorLvl1", 10, 1, "Lvl1");
        Armor armorLvl2 = new Armor("ArmorLvl2", 10, 2, "Lvl2");
        Armor armorLvl3 = new Armor("ArmorLvl3", 10, 3, "Lvl3");
        
        switch (App.getPlayer().getLevel()) {
            case 1:
                armor = armorLvl1;
                break;
            case 2:
                armor = armorLvl2;
                break;
            case 3:
                armor = armorLvl3;
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
