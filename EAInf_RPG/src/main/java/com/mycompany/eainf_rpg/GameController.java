/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eainf_rpg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author benbartel
 */
public class GameController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label currHpLabel = new Label("currHp");
    @FXML
    Label maxHpLabel = new Label("maxHp");

    static int activeScene = 5;
    static double posX = 300;
    static double posY = 150;

    @FXML
    public ImageView testPerson;

    @FXML
    private Pane evrth;
    @FXML
    private Button settingsBtn;
    @FXML
    private Pane itemSlot1;
    @FXML
    private Pane itemSlot2;
    @FXML
    private Pane itemSlot3;
    @FXML
    private Pane hpBarStuff;
    @FXML
    private Pane character;
    @FXML
    private ImageView iSlot1Lvl1;
    @FXML
    private ImageView iSlot1Lvl2;
    @FXML
    private ImageView iSlot1Lvl3;
    @FXML
    private ImageView iSlot2Lvl1;
    @FXML
    private ImageView iSlot2Lvl2;
    @FXML
    private ImageView iSlot3Lvl3;
    @FXML
    private ImageView iSlot3Lvl1;
    @FXML
    private ImageView iSlot3Lvl2;
    @FXML
    private ImageView iSlot2Lvl3;
    @FXML
    private ProgressBar hpBar;
    private ImageView enemyImg1;
    @FXML
    private Button btnWeapon;
    @FXML
    private Button btnPotion;
    @FXML
    private ImageView enemyImg;
    @FXML
    private ImageView background1;
    @FXML
    private Pane enemy1;

    //initialize 
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //itemSlot1Lvl1 = itemSlot1Lvl1;
        setPersonCoord();
        updateHpBar();
        testPerson.setX(getPosX());
        testPerson.setY(getPosY());

        
        maxHpLabel.setText(Integer.toString(App.getPlayer().getMaxHp()));
        btnWeapon.toFront();

        playerWeaponAdvance();

    }

    @FXML
    public void test4(ActionEvent event) throws IOException {
        App.getPlayer().getDamage(10);
        updateHpBar();
    }

    public void updateHpBar() {
        double barValue = App.getPlayer().getCurrHp();
        double barValueSmall = barValue / 100;
        currHpLabel.setText(Integer.toString(App.getPlayer().getCurrHp()));
        hpBar.setProgress(barValueSmall);

    }

    public boolean ifInEnemyRange() {

        boolean inRange = false;

        //Ob gegner links von spieler und in 40px entfernt ist.
        if (enemyImg.getX() < testPerson.getX() && enemyImg.getX() > testPerson.getX() - 100) {
            //ob der gegner über der person in 40px entfernt ist
            if (enemyImg.getY() < testPerson.getY() && enemyImg.getY() > testPerson.getY() - 100) {
                inRange = true;
            } else if (enemyImg.getY() > testPerson.getY() && enemyImg.getY() < testPerson.getY() + 100) {
                inRange = true;
            }
        } //Ob gegner rechts von spieler und in 40px entfernt ist.
        else if (enemyImg.getX() > testPerson.getX() && enemyImg.getX() < testPerson.getX() + 100) {
            //ob der gegner über der person in 40px entfernt ist
            if (enemyImg.getY() < testPerson.getY() && enemyImg.getY() > testPerson.getY() - 100) {
                inRange = true;
            } else if (enemyImg.getY() > testPerson.getY() && enemyImg.getY() < testPerson.getY() + 100) {
                inRange = true;
            }
        } else {
            inRange = false;
        }
        return inRange;
    }

    @FXML
    private void btnSettings(ActionEvent event) throws IOException {
        App.setRoot("Options");
    }

    @FXML
    private void btnWeapon(ActionEvent event) throws IOException {
        System.out.println("weapon");
        App.getPlayer().weaponHit();
    }

    @FXML
    private void btnPotion(ActionEvent event) throws IOException {
        System.out.println("potion");
    }

    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case W:
                testPerson.setY(testPerson.getY() - 16);
                checkPersonCoord();
                break;
            case S:
                testPerson.setY(testPerson.getY() + 16);
                checkPersonCoord();
                break;
            case A:
                testPerson.setX(testPerson.getX() - 16);
                checkPersonCoord();
                break;
            case D:
                testPerson.setX(testPerson.getX() + 16);
                checkPersonCoord();
                break;

            default:
                break;
        }
    }

    public void setPersonCoord() {
        testPerson.setX(300);
        testPerson.setY(150);
    }

    public void checkBounds() {

    }

    public void checkPersonCoord() throws IOException {

        System.out.println(testPerson.getX());
        System.out.println(testPerson.getY());

        boolean enemyNear = false;
        switch (activeScene) {
            case 1:
                enemyNear = ifInEnemyRange();
                break;
            case 3:
                enemyNear = ifInEnemyRange();
                break;
            case 7:
                enemyNear = ifInEnemyRange();
                break;
            case 9:
                enemyNear = ifInEnemyRange();
                break;

            default:
                break;
        }
        if (enemyNear) {
            System.out.println("true");
            switch (activeScene) {
                case 1:
                    App.getPlayer().setEnemy(App.getEnemy1());
                case 3:
                    App.getPlayer().setEnemy(App.getEnemy3());
                case 7:
                    App.getPlayer().setEnemy(App.getEnemy7());
                case 9:
                    App.getPlayer().setEnemy(App.getEnemy9());

            }

        }

        if ((int) testPerson.getY() >= 400 && activeScene == 1) {
            setPosY(20);
            setPosX(testPerson.getX());
            App.setRoot("Game_4");
            setActiveScene(4);
            System.out.println("unten");
            System.out.println("scene 4");

        } else if ((int) testPerson.getX() >= 600 && activeScene == 1) {
            setPosX(20);
            setPosY(testPerson.getY());
            App.setRoot("Game_2");
            setActiveScene(2);
            System.out.println("rechts");
            System.out.println("scene 2");

        } else if ((int) testPerson.getY() >= 400 && activeScene == 2) {
            setPosY(20);
            setPosX(testPerson.getX());
            App.setRoot("Game");
            setActiveScene(5);
            System.out.println("unten");
            System.out.println("scene 5");
            System.out.println(activeScene);

        } else if ((int) testPerson.getX() <= 0 && activeScene == 2) {
            setPosX(580);
            setPosY(testPerson.getY());
            App.setRoot("Game_1");
            setActiveScene(1);
            System.out.println("links");
            System.out.println("scene 1");

        } else if ((int) testPerson.getX() >= 600 && activeScene == 2) {
            setPosX(20);
            setPosY(testPerson.getY());
            App.setRoot("Game_3");
            setActiveScene(3);
            System.out.println("rechts");
            System.out.println("scene 3");

        } else if ((int) testPerson.getY() >= 400 && activeScene == 3) {
            setPosY(20);
            setPosX(testPerson.getX());
            App.setRoot("Game_6");
            setActiveScene(6);
            System.out.println("unten");
            System.out.println("scene 6");

        } else if ((int) testPerson.getX() <= 0 && activeScene == 3) {
            setPosX(580);
            setPosY(testPerson.getY());
            App.setRoot("Game_2");
            setActiveScene(2);
            System.out.println("links");
            System.out.println("scene 2");
            System.out.println(activeScene);

        } else if ((int) testPerson.getY() <= 0 && activeScene == 4) {
            setPosY(380);
            setPosX(testPerson.getX());
            App.setRoot("Game_1");
            setActiveScene(1);
            System.out.println("oben");
            System.out.println("scene 1");
            System.out.println(activeScene);

        } else if ((int) testPerson.getY() >= 400 && activeScene == 4) {
            setPosY(20);
            setPosX(testPerson.getX());
            App.setRoot("Game_7");
            setActiveScene(8);
            System.out.println("unten");
            System.out.println("scene 7");
            System.out.println(activeScene);

        } else if ((int) testPerson.getX() >= 600 && activeScene == 4) {
            setPosX(20);
            setPosY(testPerson.getY());
            App.setRoot("Game");
            setActiveScene(5);
            System.out.println("rechts");
            System.out.println("scene 5");
            System.out.println(activeScene);

        } else if ((int) testPerson.getY() <= 0 && activeScene == 5) {
            setPosY(380);
            setPosX(testPerson.getX());
            App.setRoot("Game_2");
            setActiveScene(2);
            System.out.println("oben");
            System.out.println("scene 2");
            System.out.println(activeScene);

        } else if ((int) testPerson.getY() >= 400 && activeScene == 5) {
            setPosY(20);
            setPosX(testPerson.getX());
            App.setRoot("Game_8");
            setActiveScene(8);
            System.out.println("unten");
            System.out.println("scene 8");
            System.out.println(activeScene);

        } else if ((int) testPerson.getX() <= 0 && activeScene == 5) {
            setPosX(580);
            setPosY(testPerson.getY());
            App.setRoot("Game_4");
            setActiveScene(4);
            System.out.println("links");
            System.out.println("scene 4");
            System.out.println(activeScene);

        } else if ((int) testPerson.getX() >= 600 && activeScene == 5) {
            setPosX(20);
            setPosY(testPerson.getY());
            App.setRoot("Game_6");
            setActiveScene(6);
            System.out.println("rechts");
            System.out.println("scene 6");
            System.out.println(activeScene);

        } else if ((int) testPerson.getY() <= 0 && activeScene == 6) {
            setPosY(380);
            setPosX(testPerson.getX());
            App.setRoot("Game_3");
            setActiveScene(2);
            System.out.println("oben");
            System.out.println("scene 3");
            System.out.println(activeScene);

        } else if ((int) testPerson.getY() >= 400 && activeScene == 6) {
            setPosY(20);
            setPosX(testPerson.getX());
            App.setRoot("Game_9");
            setActiveScene(9);
            System.out.println("unten");
            System.out.println("scene 9");
            System.out.println(activeScene);

        } else if ((int) testPerson.getX() <= 0 && activeScene == 6) {
            setPosX(580);
            setPosY(testPerson.getY());
            App.setRoot("Game_4");
            setActiveScene(5);
            System.out.println("links");
            System.out.println("scene 5");
            System.out.println(activeScene);

        } else if ((int) testPerson.getY() <= 0 && activeScene == 7) {
            setPosY(380);
            setPosX(testPerson.getX());
            App.setRoot("Game_4");
            setActiveScene(4);
            System.out.println("oben");
            System.out.println("scene 4");
            System.out.println(activeScene);

        } else if ((int) testPerson.getX() >= 600 && activeScene == 7) {
            setPosX(20);
            setPosY(testPerson.getY());
            App.setRoot("Game_8");
            setActiveScene(8);
            System.out.println("rechts");
            System.out.println("scene 8");
            System.out.println(activeScene);

        } else if ((int) testPerson.getY() <= 0 && activeScene == 8) {
            setPosY(380);
            setPosX(testPerson.getX());
            App.setRoot("Game");
            setActiveScene(5);
            System.out.println("oben");
            System.out.println("scene 5");
            System.out.println(activeScene);

        } else if ((int) testPerson.getX() <= 0 && activeScene == 8) {
            setPosX(580);
            setPosY(testPerson.getY());
            App.setRoot("Game_7");
            setActiveScene(7);
            System.out.println("links");
            System.out.println("scene 7");
            System.out.println(activeScene);

        } else if ((int) testPerson.getX() >= 600 && activeScene == 8) {
            setPosX(20);
            setPosY(testPerson.getY());
            App.setRoot("Game_9");
            setActiveScene(9);
            System.out.println("rechts");
            System.out.println("scene 9");
            System.out.println(activeScene);

        } else if ((int) testPerson.getY() <= 0 && activeScene == 9) {
            setPosY(380);
            setPosX(testPerson.getX());
            App.setRoot("Game_6");
            setActiveScene(6);
            System.out.println("oben");
            System.out.println("scene 6");
            System.out.println(activeScene);

        } else if ((int) testPerson.getX() <= 0 && activeScene == 9) {
            setPosX(580);
            setPosY(testPerson.getY());
            App.setRoot("Game_8");
            setActiveScene(8);
            System.out.println("links");
            System.out.println("scene 8");
            System.out.println(activeScene);

        } else {
        }
    }

    public static int getActiveScene() {
        return activeScene;
    }

    public static void setActiveScene(int activeScene) {
        GameController.activeScene = activeScene;
    }

    public static double getPosX() {
        return posX;
    }

    public static void setPosX(double posX) {
        GameController.posX = posX;
    }

    public static double getPosY() {
        return posY;
    }

    public static void setPosY(double posY) {
        GameController.posY = posY;
    }

    public double getHpProgressBar() {
        return hpBar.getProgress();
    }

    public void enemyFound() {

    }

    //the btns for upgrading weapons/armor and potions
    //not final
    @FXML
    public void test1(ActionEvent event) throws IOException {
        upgradeWeapon();
    }

    @FXML
    public void test2(ActionEvent event) throws IOException {
        upgradeArmor();
    }

    @FXML
    public void test3(ActionEvent event) throws IOException {
        upgradePotion();
    }

    //brings specific item images to front and sets opacity to 1
    //ItemSlot 1 Images To Front
    public void toFront11() {
        iSlot1Lvl1.setOpacity(1);
        iSlot1Lvl1.toFront();
    }

    public void toFront12() {
        iSlot1Lvl2.setOpacity(1);
        iSlot1Lvl2.toFront();
    }

    public void toFront13() {
        iSlot1Lvl3.setOpacity(1);
        iSlot1Lvl3.toFront();
    }

    //ItemSlot 2 Images To Front
    public void toFront21() {
        iSlot2Lvl1.setOpacity(1);
        iSlot2Lvl1.toFront();
    }

    public void toFront22() {
        iSlot2Lvl2.setOpacity(1);
        iSlot2Lvl2.toFront();
    }

    public void toFront23() {
        iSlot2Lvl3.setOpacity(1);
        iSlot2Lvl3.toFront();
    }

    //ItemSlot 3 Images To Front
    public void toFront31() {
        iSlot3Lvl1.setOpacity(1);
        iSlot3Lvl1.toFront();
    }

    public void toFront32() {
        iSlot3Lvl2.setOpacity(1);
        iSlot3Lvl2.toFront();
    }

    public void toFront33() {
        iSlot3Lvl3.setOpacity(1);
        iSlot3Lvl3.toFront();
    }

    //sets all opacities to 0, used if there is no item existing.
    public void allWeaponsOpto0() {
        iSlot1Lvl1.setOpacity(0.0);
        iSlot1Lvl2.setOpacity(0.0);
        iSlot1Lvl3.setOpacity(0.0);
    }

    public void allArmorOpto0() {
        iSlot2Lvl1.setOpacity(0.0);
        iSlot2Lvl2.setOpacity(0.0);
        iSlot2Lvl3.setOpacity(0.0);
    }

    public void allPotionOpto0() {
        iSlot3Lvl1.setOpacity(0.0);
        iSlot3Lvl2.setOpacity(0.0);
        iSlot3Lvl3.setOpacity(0.0);
    }

    //Weapon UPGRADE
    public void playerWeaponAdvance() {
        //checks if the player has a weapon
        if (App.getPlayer().getWeapon() == null) {
            //if no, all weapon images become invisible
            allWeaponsOpto0();
        } else {
            //if yes, it checks the current weapon lvl and brings the right one to the front
            switch (App.getPlayer().getWeapon().getRare()) {
                case 1:
                    toFront11();
                    break;
                case 2:
                    toFront12();
                    break;
                case 3:
                    toFront13();
                    break;
                default:
                    break;
            }
        }
    }

    //Armor UPGRADE
    public void playerArmorAdvance() {
        //same as one method above
        if (App.getPlayer().getArmor() == null) {
            allArmorOpto0();
        } else {

            switch (App.getPlayer().getArmor().getRare()) {
                case 1:
                    toFront21();
                    break;
                case 2:
                    toFront22();
                    break;
                case 3:
                    toFront23();
                    break;
                default:
                    break;
            }
        }
    }

    //Potion UPGRADE
    public void playerPotionAdvance() {
        //same as one method above
        if (App.getPlayer().getPotion() == null) {
            allPotionOpto0();
        } else {

            switch (App.getPlayer().getArmor().getRare()) {
                case 1:
                    toFront31();
                    break;
                case 2:
                    toFront32();
                    break;
                case 3:
                    toFront33();
                    break;
                default:
                    break;
            }
        }
    }

    //initates upgrade from gear
    public void upgradeWeapon() {
        //gets current lvl and adds one
        int newWeaponLvl = App.getPlayer().getWeapon().getRare() + 1;
        //sets new lvl, one added
        App.getPlayer().getWeapon().setRare(newWeaponLvl);
        //this method checks lvl and brings the correct one to front
        playerWeaponAdvance();
    }

    //same as one method above, but for Armor
    public void upgradeArmor() {
        int newArmorLvl = App.getPlayer().getArmor().getRare() + 1;
        App.getPlayer().getArmor().setRare(newArmorLvl);
        playerArmorAdvance();
    }

    //same method above, but for Potion.
    public void upgradePotion() {
        int newPotionLvl = App.getPlayer().getPotion().getRare() + 1;
        App.getPlayer().getPotion().setRare(newPotionLvl);
        playerPotionAdvance();
    }

}
