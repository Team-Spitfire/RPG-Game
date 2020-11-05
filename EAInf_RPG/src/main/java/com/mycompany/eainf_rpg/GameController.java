/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eainf_rpg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;

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
    
    
    
    @FXML
    private ImageView testPerson;
    
    
    
    Translate translateXRight = new Translate();       
    Translate translateYUp = new Translate();
    Translate translateXLeft = new Translate();       
    Translate translateYDown = new Translate();
    
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
    
    
    //initialize 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //itemSlot1Lvl1 = itemSlot1Lvl1;
        
        
        
        currHpLabel.setText(Integer.toString(App.getPlayer().getCurrHp()));
        maxHpLabel.setText(Integer.toString(App.getPlayer().getMaxHp()));
        //App.getPlayer().setCurrHp(60);
        
        playerWeaponAdvance();

        translateXRight.setX(60);
        translateYUp.setY(-60);
        translateXLeft.setX(-60);
        translateYDown.setY(60);
        
    }
    
    @FXML
    public void test4(ActionEvent event) throws IOException {
        App.getPlayer().getDamage(10);
        updateHpBar();
    }
    
    public void updateHpBar(){
        double barValue = App.getPlayer().getCurrHp();
        double barValueSmall = barValue / 100;
        hpBar.setProgress(barValueSmall);
        
    }
    
    
    
    
    @FXML
    private void btnSettings(ActionEvent event) throws IOException {
        App.setRoot("Options");
    }
    
    
    
    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
                case W: character.getTransforms().addAll(translateYUp); checkPersonCoord(); break;
                case S: character.getTransforms().addAll(translateYDown); checkPersonCoord(); break;
                case A: character.getTransforms().addAll(translateXLeft); checkPersonCoord(); break;
                case D: character.getTransforms().addAll(translateXRight); checkPersonCoord(); break;
                
        default:
            break;
            }
        }
    
    public void checkPersonCoord() throws IOException{
        
        int coordY = (int) testPerson.getLayoutY();
        int coordX = (int) testPerson.getLayoutX();
        
        System.out.println(coordY);
        System.out.println(character.getTranslateY());
        
        if((int) testPerson.getY() == 0){
            //App.setRoot("Game");
            System.out.println("oben" + coordY);
            //testPerson.setY(380);
            testPerson.setX(testPerson.getX());
        }
        else if ((int) testPerson.getY() > 380){
            //App.setRoot("Game");
            System.out.println("unten");
            testPerson.setY(20);
            testPerson.setX(testPerson.getX());
        }
        else if ((int) testPerson.getX() < 10){
            //App.setRoot("Game");
            System.out.println("links");
            testPerson.setX(580);
            testPerson.setY(testPerson.getY());
        }
        else if ((int) testPerson.getX() > 580){
            //App.setRoot("Game");
            System.out.println("rechts");
            testPerson.setX(20);
            testPerson.setY(testPerson.getY());
        }
        else{}
    }
    
    
    
    public double getHpProgressBar() {
        return hpBar.getProgress();
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
    public void toFront11(){
        iSlot1Lvl1.setOpacity(1);
        iSlot1Lvl1.toFront();
    }
    public void toFront12(){
        iSlot1Lvl2.setOpacity(1);
        iSlot1Lvl2.toFront();
    }
    public void toFront13(){
        iSlot1Lvl3.setOpacity(1);
        iSlot1Lvl3.toFront();
    }
    //ItemSlot 2 Images To Front
    public void toFront21(){
        iSlot2Lvl1.setOpacity(1);
        iSlot2Lvl1.toFront();
    }
    public void toFront22(){
        iSlot2Lvl2.setOpacity(1);
        iSlot2Lvl2.toFront();
    }
    public void toFront23(){
        iSlot2Lvl3.setOpacity(1);
        iSlot2Lvl3.toFront();
    }
    //ItemSlot 3 Images To Front
    public void toFront31(){
        iSlot3Lvl1.setOpacity(1);
        iSlot3Lvl1.toFront();
    }
    public void toFront32(){
        iSlot3Lvl2.setOpacity(1);
        iSlot3Lvl2.toFront();
    }
    public void toFront33(){
        iSlot3Lvl3.setOpacity(1);
        iSlot3Lvl3.toFront();
    }
    
    
    
    
    
    //sets all opacities to 0, used if there is no item existing.
    public void allWeaponsOpto0(){
            iSlot1Lvl1.setOpacity(0.0);
            iSlot1Lvl2.setOpacity(0.0);
            iSlot1Lvl3.setOpacity(0.0);
    }
    
    public void allArmorOpto0(){
            iSlot2Lvl1.setOpacity(0.0);
            iSlot2Lvl2.setOpacity(0.0);
            iSlot2Lvl3.setOpacity(0.0);
    }
    
    public void allPotionOpto0(){
            iSlot3Lvl1.setOpacity(0.0);
            iSlot3Lvl2.setOpacity(0.0);
            iSlot3Lvl3.setOpacity(0.0);
    }
    
    
    
    //Weapon UPGRADE
    public void playerWeaponAdvance(){
        //checks if the player has a weapon
        if(App.getPlayer().getWeapon() == null){
            //if no, all weapon images become invisible
            allWeaponsOpto0();
        }
        else{
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
    public void playerArmorAdvance(){
        //same as one method above
        if(App.getPlayer().getArmor() == null){
             allArmorOpto0();
        }
        else{
            
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
    public void playerPotionAdvance(){
        //same as one method above
        if(App.getPlayer().getPotion() == null){
             allPotionOpto0();
        }
        else{
            
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
    public void upgradeWeapon(){
        //gets current lvl and adds one
        int newWeaponLvl = App.getPlayer().getWeapon().getRare() + 1;
        //sets new lvl, one added
        App.getPlayer().getWeapon().setRare(newWeaponLvl);
        //this method checks lvl and brings the correct one to front
        playerWeaponAdvance();
    }
    //same as one method above, but for Armor
    public void upgradeArmor(){
        int newArmorLvl = App.getPlayer().getArmor().getRare() + 1;
        App.getPlayer().getArmor().setRare(newArmorLvl);
        playerArmorAdvance();
    }
    //same method above, but for Potion.
    public void upgradePotion(){
        int newPotionLvl = App.getPlayer().getPotion().getRare() + 1;
        App.getPlayer().getPotion().setRare(newPotionLvl);
        playerPotionAdvance();
    }
    
    
}
