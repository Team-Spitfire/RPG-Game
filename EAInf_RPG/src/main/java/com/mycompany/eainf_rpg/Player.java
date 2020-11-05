/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */package com.mycompany.eainf_rpg;import java.io.IOException;import java.util.ArrayList;/** * * @author benbartel *///Klasse Player wird geöffnetpublic final class Player {    public String name;    public int maxHp;    public static int currHp;     public Weapon weapon;    public Armor armor;    public Potion potion;    //public Potion potionLoot;    public Enemy enemy;    public int level;    public int goldCoins;    public int weaponLvl;    public int armorLvl;    public int potionLvl;    public Player(String name, int currHp, int maxHp, Weapon weapon, Armor armor, Potion potion, Enemy enemy, int level, int goldCoins, int weaponLvl, int armorLvl, int potionLvl) {        this.name = name;        this.maxHp = 100;        this.currHp = 100;        this.weapon = null;        this.armor = null;        this.potion = null;        this.enemy = null;        this.level = 1;        this.goldCoins = 10;        this.weaponLvl = weaponLvl;        this.armorLvl = armorLvl;        this.potionLvl = potionLvl;                createWeapon();        createArmor();        createPotion();    }    public void createWeapon(){        weapon = new Weapon("Sword", 15, 1, "Your basic starting Sword!");    }        public void createArmor(){        armor = new Armor("Armor", 20, 1, "Your basic starting Armor!");    }        public void createPotion(){        potion = new Potion("Potion", 15, 1, "Heals you just enough!");    }        //Weapon Hits and Damage Taking    //Zieht den Modifier der Armnor schon ab    public void weaponHit () {        int dmg = weapon.getAtk();        enemy.getDamage(dmg);    }        //rechnet die resistance aus (den erhaltenen Schaden) und bestimmt, ob der Spieler tot ist    public void getDamage(int dmg) throws IOException{        double modifier;        System.out.println(getCurrHp());        //setzt die Modifier je nach Rüstungsstärke        switch (armor.getDef()) {            case 20:                modifier = 0.8;                break;            case 40:                modifier = 0.6;                break;            case 60:                modifier = 0.4;                break;            default:                modifier = 0;                break;                                  }        System.out.println(getCurrHp());        //rechnet aus        int newDmg = (int)Math.ceil(dmg * modifier);        System.out.println("new dmg" + newDmg);        //überprüft, ob die Leben des Spielers auf 0 fallen, falls ja führt "dead" aus        currHp = currHp - newDmg;        System.out.println("new currHp" + currHp);        //dToIntProgressbar(currHp);                boolean tot = obGestorben();        if(tot = true){            dead();        }        //GameController.updateHpBar();    }                    //Abfrage ob die Hitpoints unter 0 sind.    public boolean obGestorben(){        boolean gestorben;        gestorben = currHp <= 0;        return gestorben;    }    //Methode die ausgeführt wird wenn der Spieler tot ist    //Wird beinhalten --> HP auf 100, respawn, item loss?    public void dead() throws IOException{        App.setRoot("Deads");    }                //public static void dToIntProgressbar(int currHp){    //    Double dHp = Double.valueOf(currHp);    //    Double progress = dHp / 100;    //    GameController.setProgress(progress);    //}            //Loot        public void loot(){        //Auswahl der Drei Item Typen        int goldCoinsLoot = 0;        int ifPotion = 0;                switch (level) {            case 1:                goldCoinsLoot = 20 + (int)(Math.random() * ((70 - 20) + 1));                ifPotion =(int)(Math.random() * ((3 - 1) + 1));                if(ifPotionInLoot(ifPotion) == true){                    generatePotion();                }                break;            case 2:                goldCoinsLoot = 50 + (int)(Math.random() * ((120 - 50) + 1));                ifPotion =(int)(Math.random() * ((3 - 1) + 1));                if(ifPotionInLoot(ifPotion) == true){                    generatePotion();                }                break;            case 3:                goldCoinsLoot = 100 + (int)(Math.random() * ((200 - 100) + 1));                ifPotion =(int)(Math.random() * ((3 - 1) + 1));                if(ifPotionInLoot(ifPotion) == true){                    generatePotion();                }                break;            default:                break;        }    }        public boolean ifPotionInLoot(int ifPotion){        boolean potionInLoot;        if(ifPotion == 3){            potionInLoot = true;        }        else {            potionInLoot = false;        }        return potionInLoot;    }                //Generate random Weapon aus Auswahl    //Auswahl erweiterbar        /*    public void generateWeapon(){        ArrayList<String> weaponNames = new ArrayList<> ();        weaponNames.add("Iron Sword");        weaponNames.add("Sword of the Fire");        weaponNames.add("Sword of the Sun God");                int weaponNumber =(int)(Math.random() * (weaponNames.size()));                String weaponName = null;        int atk = 0;        String desc = null;                switch (weaponNumber) {            case 0:                weaponName = weaponNames.get(weaponNumber);                atk = 10;                desc = "This is a basic Iron Sword!";                break;            case 1:                weaponName = weaponNames.get(weaponNumber);                atk = 18;                desc = "A pretty great Fire Sword?";                break;            case 2:                weaponName = weaponNames.get(weaponNumber);                atk = 25;                desc = "The Ultimate Sword of the Sun God!";                break;                default:                break;         }        weaponLoot = new Weapon(weaponName, atk, desc);    */                        //Jetzt wird abgefragt ob der Spieler die Waffe haben möchte.        //Wenn ja, --> weapon = weaponLoot;                        //------->Abfrage ob der Spieler den Loot haben will        //Neues Fenster für jeden neuen Loot ???        //Dann Auswahl ob man es haben will.        //Generates random Armor aus Auswahl    //Auswahl erweiterbar                /*    public void generateArmor(){        ArrayList<String> armorNames = new ArrayList<> ();        armorNames.add("Leather Armor");        armorNames.add("Plate Armor");        armorNames.add("Armor of the Sun God");                int weaponNumber =(int)(Math.random() * (armorNames.size()));                String armorName = null;        int def = 0;        String desc = null;                switch (weaponNumber) {            case 0:                armorName = armorNames.get(weaponNumber);                def = 20;                desc = "Just a basic Plate Armor!";                break;            case 1:                armorName = armorNames.get(weaponNumber);                def = 40;                desc = "A nice basic Leather Armor!";                break;            case 2:                armorName = armorNames.get(weaponNumber);                def = 60;                desc = "The Ultimate Armor of the Sun God!";                break;                default:                break;         }                armorLoot = new Armor(armorName, def, desc);                //Jetzt wird abgefragt ob der Spieler die Armor haben möchte.        //Wenn ja, --> armor = armorLoot;    }    */        public void generatePotion(){        ArrayList<String> potionNames = new ArrayList<> ();        potionNames.add("Basic Potion of Healing");        potionNames.add("Bigger Potion of Healing");        potionNames.add("Huge Potion of Healing");                int weaponNumber =(int)(Math.random() * (potionNames.size()));                String potionName = null;        int healValue = 0;        int rare = 0;        String desc = null;                switch (weaponNumber) {            case 0:                potionName = potionNames.get(weaponNumber);                healValue = 15;                rare = 1;                desc = "Restores a small amount of Health!";                break;            case 1:                potionName = potionNames.get(weaponNumber);                healValue = 25;                rare = 2;                desc = "Restores quite a lot of Health!";                break;            case 2:                potionName = potionNames.get(weaponNumber);                healValue = 50;                rare = 3;                desc = "Restores a huge amount of Health!";                break;                default:                break;         }                //potionLoot = new Potion(potionName, healValue, rare, desc);                //Jetzt wird abgefragt ob der Spieler die Potion haben möchte.        //Wenn ja, --> potion = potionLoot;    }                                                        //Setter and Getter        public void setPotion(Potion potion) {        this.potion = potion;    }        public void setEnemy(Enemy enemy) {        this.enemy = enemy;    }    public void setLevel(int level) {        this.level = level;    }    public void setGoldCoins(int goldCoins) {        this.goldCoins = goldCoins;    }        public Potion getPotion() {        return potion;    }        public Enemy getEnemy() {        return enemy;    }    public int getLevel() {        return level;    }    public int getGoldCoins() {        return goldCoins;    }        public void setName(String name) {        this.name = name;    }    public void setMaxHp(int maxHp) {        this.maxHp = maxHp;    }    public void setCurrHp(int currHp) {        this.currHp = currHp;    }    public void setWeapon(Weapon weapon) {        this.weapon = weapon;    }    public void setArmor(Armor armor) {        this.armor = armor;    }        public String getName() {        return name;    }    public int getMaxHp() {        return maxHp;    }    public int getCurrHp() {        return currHp;    }    public Weapon getWeapon() {        return weapon;    }    public Armor getArmor() {        return armor;    }        public int getWeaponLvl() {        return weaponLvl;    }    public void setWeaponLvl(int weaponLvl) {        this.weaponLvl = weaponLvl;    }    public int getArmorLvl() {        return armorLvl;    }    public void setArmorLvl(int armorLvl) {        this.armorLvl = armorLvl;    }    public int getPotionLvl() {        return potionLvl;    }    public void setPotionLvl(int potionLvl) {        this.potionLvl = potionLvl;    }                }                        