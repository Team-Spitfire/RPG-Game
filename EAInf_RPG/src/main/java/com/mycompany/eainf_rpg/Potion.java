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
public class Potion {
    public String name;
    public int healValue;
    public int damageValue;

    public Potion(String name, int healValue, int damageValue) {
        this.name = name;
        this.healValue = healValue;
        this.damageValue = damageValue;
    }

    public String getName() {
        return name;
    }

    public int getHealValue() {
        return healValue;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealValue(int healValue) {
        this.healValue = healValue;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }
    
    
    
    
    
    
    
    
    
    
    
}
