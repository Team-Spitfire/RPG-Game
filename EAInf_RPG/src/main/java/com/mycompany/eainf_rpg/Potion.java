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
    public String desc;

    public Potion(String name, int healValue, String desc) {
        this.name = name;
        this.healValue = healValue;
        this.desc = desc;
    }

    
    
    
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
    
    public String getName() {
        return name;
    }

    public int getHealValue() {
        return healValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealValue(int healValue) {
        this.healValue = healValue;
    }
    
    
    
    
    
    
}
