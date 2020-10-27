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
public class Armor {

    public String name;
    public int def;
    public int rare;
    public String desc;

    public Armor(String name, int def, int rare, String desc) {
        this.name = name;
        this.def = def;
        this.rare = rare;
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public int getDef() {
        return def;
    }

    public String getDesc() {
        return desc;
    }

}
