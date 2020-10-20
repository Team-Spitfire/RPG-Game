/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eainf_rpg;

import java.util.ArrayList;

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
    //Weapon Hits and Damage Taking
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
    //Abfrage ob die Hitpoints unter 0 sind.
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
    //Methode die ausgeführt wird wenn der Spieler tot ist
    //Wird beinhalten --> HP auf 100, respawn, item loss?
    public void dead(){
        
    }
    
    public void loot(){
        //Auswahl der Drei Item Typen
        
        int itemTyp = 1 + (int)(Math.random() * ((3 - 1) + 1));
        switch (itemTyp) {
            case 1:
                generateWeapon();
                break;
            case 2:
                generateArmor();
                break;
            case 3:
                generatePotion();
                break;
            default:
                break;
        }
    }
    
    
    public void generateWeapon(){
        ArrayList<String> weaponNames = new ArrayList<> ();
        weaponNames.add("Iron Sword");
        weaponNames.add("Bronce Sword");
        
        int weaponNumber =(int)(Math.random() * (weaponNames.size()));
        
        String weaponName = null;
        int atk = 0;
        String desc = null;
        
        switch (weaponNumber) {
            case 0:
                weaponName = weaponNames.get(weaponNumber);
                atk = 10;
                desc = "This is a basic Iron Sword!";
                break;
            case 1:
                weaponName = weaponNames.get(weaponNumber);
                atk = 8;
                desc = "This is a basic Bronce Sword!";
                break;
            default:
                break; 
        }
        Weapon neueWeapon = new Weapon(weaponName, atk, desc);
        //------->Abfrage ob der Spieler den Loot haben will
        //Neues Fenster für jeden neuen Loot ???
        //Dann Auswahl ob man es haben will.
    }
    
    public void generateArmor(){
        
    }
    
    public void generatePotion(){
        
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