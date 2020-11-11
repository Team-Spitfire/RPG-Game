package com.mycompany.eainf_rpg;import javafx.application.Application;import javafx.fxml.FXMLLoader;import javafx.scene.Parent;import javafx.scene.Scene;import javafx.stage.Stage;import java.io.IOException;/** * JavaFX App */public class App extends Application {    private static Scene scene;    private static Player player;    public static Enemy enemy1;    public static Enemy enemy2;    public static Enemy enemy3;    public static Enemy enemy4;    public static Enemy enemy5;    public static Enemy enemy6;    public static Enemy enemy7;    public static Enemy enemy8;    public static Enemy enemy9;    @Override    public void start(Stage stage) throws IOException {        scene = new Scene(loadFXML("Homescreen"), 600, 400);        stage.setScene(scene);        stage.show();    }    static void setRoot(String fxml) throws IOException {        scene.setRoot(loadFXML(fxml));    }    private static Parent loadFXML(String fxml) throws IOException {        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));        return fxmlLoader.load();    }    public static void main(String[] args) {        launch();    }    public static void createEnemies() {        enemy1 = new Enemy("Org", 100, 100, generateWeapon(), generateArmor());        enemy2 = new Enemy("Minotaur", 100, 100, generateWeapon(), generateArmor());        enemy3 = new Enemy("Org3", 100, 100, generateWeapon(), generateArmor());        enemy4 = new Enemy("Org4", 100, 100, generateWeapon(), generateArmor());        enemy5 = new Enemy("Org5", 100, 100, generateWeapon(), generateArmor());        enemy6 = new Enemy("Org6", 100, 100, generateWeapon(), generateArmor());        enemy7 = new Enemy("Org7", 100, 100, generateWeapon(), generateArmor());        enemy8 = new Enemy("Org8", 100, 100, generateWeapon(), generateArmor());        enemy9 = new Enemy("Org9", 100, 100, generateWeapon(), generateArmor());    }    public static Weapon generateWeapon() {        Weapon genWeapon = null;        Weapon weaponLvl1 = new Weapon("WeaponLvl1", 10, 1, "Lvl1");        Weapon weaponLvl2 = new Weapon("WeaponLvl2", 15, 2, "Lvl2");        Weapon weaponLvl3 = new Weapon("WeaponLvl3", 20, 3, "Lvl3");        switch (getPlayer().getLevel()) {            case 1:                genWeapon = weaponLvl1;                break;            case 2:                genWeapon = weaponLvl2;                break;            case 3:                genWeapon = weaponLvl3;                break;            default:                break;        }        return genWeapon;    }    public static Armor generateArmor() {        Armor genArmor = null;        Armor armorLvl1 = new Armor("ArmorLvl1", 10, 1, "Lvl1");        Armor armorLvl2 = new Armor("ArmorLvl2", 10, 2, "Lvl2");        Armor armorLvl3 = new Armor("ArmorLvl3", 10, 3, "Lvl3");        switch (getPlayer().getLevel()) {            case 1:                genArmor = armorLvl1;                break;            case 2:                genArmor = armorLvl2;                break;            case 3:                genArmor = armorLvl3;                break;            default:                break;        }        return genArmor;    }    public static void createPlayer() {        player = null;        player = new Player(null, 100, 100, null, null, null, null, 1, 10, false);    }    public static Player getPlayer() {        return player;    }    public static void setPlayer(Player player) {        App.player = player;    }    public static Enemy getEnemy1() {        return enemy1;    }    public static void setEnemy1(Enemy enemy1) {        App.enemy1 = enemy1;    }    public static Enemy getEnemy2() {        return enemy2;    }    public static void setEnemy2(Enemy enemy2) {        App.enemy2 = enemy2;    }    public static Enemy getEnemy3() {        return enemy3;    }    public static void setEnemy3(Enemy enemy3) {        App.enemy3 = enemy3;    }    public static Enemy getEnemy4() {        return enemy4;    }    public static void setEnemy4(Enemy enemy4) {        App.enemy4 = enemy4;    }    public static Enemy getEnemy5() {        return enemy5;    }    public static void setEnemy5(Enemy enemy5) {        App.enemy5 = enemy5;    }    public static Enemy getEnemy6() {        return enemy6;    }    public static void setEnemy6(Enemy enemy6) {        App.enemy6 = enemy6;    }    public static Enemy getEnemy7() {        return enemy7;    }    public static void setEnemy7(Enemy enemy7) {        App.enemy7 = enemy7;    }    public static Enemy getEnemy8() {        return enemy8;    }    public static void setEnemy8(Enemy enemy8) {        App.enemy8 = enemy8;    }    public static Enemy getEnemy9() {        return enemy9;    }    public static void setEnemy9(Enemy enemy9) {        App.enemy9 = enemy9;    }}