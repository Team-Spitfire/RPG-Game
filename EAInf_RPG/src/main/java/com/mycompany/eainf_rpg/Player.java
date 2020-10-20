/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eainf_rpg;
import java.util.*;
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

    public Player() {
        maxHp = 100;
        currHp = 100;
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
