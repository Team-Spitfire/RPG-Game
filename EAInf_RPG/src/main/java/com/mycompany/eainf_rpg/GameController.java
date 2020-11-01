/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eainf_rpg;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
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
    static ProgressBar hpProgressBar = new ProgressBar();
    
    @FXML
    private ImageView testPerson;
    
    Image image4 = new Image("file:Armor1.png", 0, 100, false, false);
    
    
    Translate translateXRight = new Translate();       
    Translate translateYUp = new Translate();
    Translate translateXLeft = new Translate();       
    Translate translateYDown = new Translate();
    
    @FXML
    private static ImageView itemSlot3Lvl1;
    @FXML
    private static ImageView itemSlot2Lvl1;
    @FXML
    private static ImageView itemSlot1Lvl1;
    @FXML
    private static ImageView itemSlot1Lvl2;
    @FXML
    private static ImageView itemSlot2Lvl2;
    @FXML
    private static ImageView itemSlot3Lvl2;
    @FXML
    private static ImageView itemSlot1Lvl3;
    @FXML
    private static ImageView itemSlot2Lvl3;
    @FXML
    private static ImageView itemSlot3Lvl3;
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
    
    
    //
    //initialize 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        currHpLabel.setText(Integer.toString(App.getPlayer().getCurrHp()));
        maxHpLabel.setText(Integer.toString(App.getPlayer().getMaxHp()));
        hpProgressBar.setProgress(0.8);
        App.getPlayer().setCurrHp(60);
        
        playerWeaponAdvance();

        translateXRight.setX(30);
        translateYUp.setY(-30);
        translateXLeft.setX(-30);
        translateYDown.setY(30);
        
    }
    //
    
    
    
    
    
    public void hpProgressBar(){
        hpProgressBar.setProgress(App.getPlayer().getCurrHp()/100);
    }
    
    @FXML
    private void btnSettings(ActionEvent event) throws IOException {
        App.setRoot("Options");
    }
    
    
    
    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
                case W:    character.getTransforms().addAll(translateYUp); checkPersonCoord(); break;
                case S:  character.getTransforms().addAll(translateYDown); checkPersonCoord(); break;
                case A:  character.getTransforms().addAll(translateXLeft); checkPersonCoord(); break;
                case D: character.getTransforms().addAll(translateXRight); checkPersonCoord(); break;
                
        default:
            break;
            }
        }
    
    public void checkPersonCoord() throws IOException{
        
        int coordY = (int) testPerson.getLayoutY();
        int coordX = (int) testPerson.getLayoutX();
        
        System.out.println(character.getTranslateX());
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
    
    
    @FXML
    public void setHpProgressBar(){
        hpProgressBar.setProgress(0.5);
        System.out.println(getHpProgressBar());
    }
    
    public static double getHpProgressBar() {
        return hpProgressBar.getProgress();
    }
    
    //Mit toFront() kann man ein Bild in den Vordergrund bringen
    //hier mit drei btns gezeigt
    @FXML
    private void iSlotLvl1ToFr(ActionEvent event) throws IOException {
        itemSlot1Lvl1.toFront();
    }
    @FXML
    private void iSlotLvl2ToFr(ActionEvent event) throws IOException {
        itemSlot1Lvl2.toFront();
    }
    @FXML
    private void iSlotLvl3ToFr(ActionEvent event) throws IOException {
        itemSlot1Lvl3.toFront();
    }
    
    
    
    
    
    
    
    
    @FXML
    public static void playerWeaponAdvance(){
        
        if(App.getPlayer().getWeapon() == null){
            itemSlot1Lvl1.setOpacity(0);
            itemSlot1Lvl2.setOpacity(0);
            itemSlot1Lvl3.setOpacity(0); 
        }
        else{
            itemSlot1Lvl1.setOpacity(1);
            itemSlot1Lvl2.setOpacity(1);
            itemSlot1Lvl3.setOpacity(1); 
            
            switch (App.getPlayer().getWeaponLvl()) {
                case 1:
                   itemSlot1Lvl1.toFront();
                    break;
                case 2:
                   itemSlot1Lvl2.toFront(); 
                    break;
                case 3:
                   itemSlot1Lvl3.toFront(); 
                    break;
                default:
                    break;
            }
        }
    }
    
    
}
