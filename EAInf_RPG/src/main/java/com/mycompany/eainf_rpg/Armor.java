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
    public String def;
    public String desc;

    public Armor(String name, String def, String desc) {
        this.def = def;
        this.name = name;
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDef() {
        return def;
    }

    public String getDesc() {
        return desc;
    }

}
