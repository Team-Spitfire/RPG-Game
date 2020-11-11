/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */package com.mycompany.eainf_rpg;import java.io.IOException;import java.util.ArrayList;/** * * @author benbartel *///Klasse Player wird geöffnetpublic final class Player {    public String name;    public int maxHp;    public static int currHp;    public Weapon weapon;    public Armor armor;    public Potion potion;    public Enemy enemy;    public int level;    public int goldCoins;    public boolean potionUsed;    public Player(String name, int currHp, int maxHp, Weapon weapon, Armor armor, Potion potion, Enemy enemy, int level, int goldCoins, boolean potionUsed) {        this.name = name;        this.maxHp = 100;        this.currHp = 100;        this.weapon = null;        this.armor = null;        this.potion = null;        this.enemy = null;        this.level = 1;        this.goldCoins = 10;        this.potionUsed = false;        createWeapon();        createArmor();        createPotion();    }    public void createWeapon() {        weapon = new Weapon("Sword", 15, 1, "Your basic starting Sword!");    }    public void createArmor() {        armor = new Armor("Armor", 20, 1, "Your basic starting Armor!");    }    public void createPotion() {        potion = new Potion("Potion", 15, 1, "Heals you just enough!");    }    //Weapon Hits and Damage Taking    //Zieht den Modifier der Armor schon ab    public void weaponHit() throws IOException {        App.getPlayer().getEnemy().getDamage(weapon.getAtk());    }    //rechnet die resistance aus (den erhaltenen Schaden) und bestimmt, ob der Spieler tot ist    public void getDamage(int dmg) throws IOException {        double modifier;        //setzt die Modifier je nach Rüstungsstärke        switch (armor.getDef()) {            case 20:                modifier = 0.8;                break;            case 40:                modifier = 0.6;                break;            case 60:                modifier = 0.4;                break;            default:                modifier = 0;                break;        }        System.out.println(getCurrHp());        //rechnet aus        int newDmg = (int) Math.ceil(dmg * modifier);        System.out.println("new dmg" + newDmg);        //überprüft, ob die Leben des Spielers auf 0 fallen, falls ja führt "dead" aus        currHp = currHp - newDmg;        System.out.println("new currHp" + currHp);        //dToIntProgressbar(currHp);        boolean tot = obGestorben();        if (tot == true) {            dead();        } else {        }        //GameController.updateHpBar();    }    //Abfrage ob die Hitpoints unter 0 sind.    public boolean obGestorben() {        boolean gestorben;        if (currHp <= 0) {            gestorben = true;        } else {            gestorben = false;        }        return gestorben;    }    //Methode die ausgeführt wird wenn der Spieler tot ist    //Wird beinhalten --> HP auf 100, respawn, item loss?    public void dead() throws IOException {        App.setRoot("Deads");    }    //Loot    public void loot() {        //Auswahl der Drei Item Typen        int goldCoinsLoot = 0;        int ifPotion = 0;        switch (level) {            case 1:                goldCoinsLoot = 20 + (int) (Math.random() * ((70 - 20) + 1));                ifPotion = (int) (Math.random() * ((3 - 1) + 1));                if (ifPotionInLoot(ifPotion) == true) {                    generatePotion();                }                break;            case 2:                goldCoinsLoot = 50 + (int) (Math.random() * ((120 - 50) + 1));                ifPotion = (int) (Math.random() * ((3 - 1) + 1));                if (ifPotionInLoot(ifPotion) == true) {                    generatePotion();                }                break;            case 3:                goldCoinsLoot = 100 + (int) (Math.random() * ((200 - 100) + 1));                ifPotion = (int) (Math.random() * ((3 - 1) + 1));                if (ifPotionInLoot(ifPotion) == true) {                    generatePotion();                }                break;            default:                break;        }    }    public boolean ifPotionInLoot(int ifPotion) {        boolean potionInLoot;        if (ifPotion == 3) {            potionInLoot = true;        } else {            potionInLoot = false;        }        return potionInLoot;    }    public void generatePotion() {        ArrayList<String> potionNames = new ArrayList<>();        potionNames.add("Basic Potion of Healing");        potionNames.add("Bigger Potion of Healing");        potionNames.add("Huge Potion of Healing");        int weaponNumber = (int) (Math.random() * (potionNames.size()));        String potionName = null;        int healValue = 0;        int rare = 0;        String desc = null;        switch (weaponNumber) {            case 0:                potionName = potionNames.get(weaponNumber);                healValue = 15;                rare = 1;                desc = "Restores a small amount of Health!";                break;            case 1:                potionName = potionNames.get(weaponNumber);                healValue = 25;                rare = 2;                desc = "Restores quite a lot of Health!";                break;            case 2:                potionName = potionNames.get(weaponNumber);                healValue = 50;                rare = 3;                desc = "Restores a huge amount of Health!";                break;            default:                break;        }        //potionLoot = new Potion(potionName, healValue, rare, desc);        //Jetzt wird abgefragt ob der Spieler die Potion haben möchte.        //Wenn ja, --> potion = potionLoot;    }    public void usePotion() throws IOException {        if (App.getPlayer().getPotion() == null) {            System.out.println("You do not have a Potion equipped.");        } else {            if (App.getPlayer().potionUsed) {                System.out.println("Potion was already used this Turn.");            } else {                currHp = currHp + potion.getHealValue();                potionUsed = true;                System.out.println("Potion is used!");                System.out.println(currHp);            }        }        //enemy.enemyTurn();    }    public void enemyDied() {        enemy = null;        potionUsed = false;            }    //Setter and Getter    public void setPotion(Potion potion) {        this.potion = potion;    }    public void setEnemy(Enemy enemy) {        this.enemy = enemy;    }    public void setLevel(int level) {        this.level = level;    }    public void setGoldCoins(int goldCoins) {        this.goldCoins = goldCoins;    }    public Potion getPotion() {        return potion;    }    public Enemy getEnemy() {        return enemy;    }    public int getLevel() {        return level;    }    public int getGoldCoins() {        return goldCoins;    }    public void setName(String name) {        this.name = name;    }    public void setMaxHp(int maxHp) {        this.maxHp = maxHp;    }    public void setCurrHp(int currHp) {        this.currHp = currHp;    }    public void setWeapon(Weapon weapon) {        this.weapon = weapon;    }    public void setArmor(Armor armor) {        this.armor = armor;    }    public String getName() {        return name;    }    public int getMaxHp() {        return maxHp;    }    public int getCurrHp() {        return currHp;    }    public Weapon getWeapon() {        return weapon;    }    public Armor getArmor() {        return armor;    }}