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
public class Weapon {

    public String name;
    public int atk;
    public int rare;
    public String desc;

    public Weapon(String name, int atk, int rare, String desc) {
        this.name = name;
        this.atk = atk;
        this.rare = rare;
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public int getRare() {
        return rare;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public String getDesc() {
        return desc;
    }

}
