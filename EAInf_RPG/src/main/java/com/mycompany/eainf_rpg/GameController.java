/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eainf_rpg;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    
    private String pathArmor1 = "https://i.ibb.co/2K6Tz3c/Armor1.png";
    private String pathArmor2 = "https://i.ibb.co/3FxGV8x/Armor2.png";
    private String pathArmor3 = "";
    private String pathWeapon1 = "";
    private String pathWeapon2 = "";
    
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
    private ImageView imageViewTest;
    @FXML
    private ImageView itemSlot3Lvl1;
    @FXML
    private ImageView itemSlot2Lvl1;
    @FXML
    private ImageView itemSlot1Lvl1;
    @FXML
    private ImageView itemSlot1Lvl2;
    @FXML
    private ImageView itemSlot2Lvl2;
    @FXML
    private ImageView itemSlot3Lvl2;
    @FXML
    private ImageView itemSlot1Lvl3;
    @FXML
    private ImageView itemSlot2Lvl3;
    @FXML
    private ImageView itemSlot3Lvl3;
    
    
    
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //FileInputStream inputstream = new FileInputStream("Documents/Github/RPG-Game/src/main/java/pictures/Armor3.png");
        //String imagePath = "Sword1.png";
        Image image3 = new Image(pathArmor1, 100, 0, false, false);
    
        
        
        
        String testtext = "hallo";
        
        currHpLabel.setText(Integer.toString(App.getPlayer().getCurrHp()));
        maxHpLabel.setText(Integer.toString(App.getPlayer().getMaxHp()));
        hpProgressBar.setProgress(0.8);
        App.getPlayer().setCurrHp(60);
        
        
        
        translateXRight.setX(30);
        translateYUp.setY(-30);
        translateXLeft.setX(-30);
        translateYDown.setY(30);
        
    }
    
    public void hpProgressBar(){
        hpProgressBar.setProgress(App.getPlayer().getCurrHp()/100);
    }
    
    @FXML
    private void btnSettings(ActionEvent event) throws IOException {
        App.setRoot("Options");
    }
    
    
    
    
    public void btnMovePersonYUp(ActionEvent event) throws IOException {
        testPerson.getTransforms().addAll(translateYUp); 
    }
    
    public void btnMovePersonXRight(ActionEvent event) throws IOException {
        testPerson.getTransforms().addAll(translateXRight);
    }
    
    public void btnMovePersonYDown(ActionEvent event) throws IOException {
        testPerson.getTransforms().addAll(translateYDown); 
    }
    
    public void btnMovePersonXLeft(ActionEvent event) throws IOException {
        testPerson.getTransforms().addAll(translateXLeft); 
    }
    
    
    
    @FXML
    void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
                case W:    testPerson.getTransforms().addAll(translateYUp); break;
                case S:  testPerson.getTransforms().addAll(translateYDown); break;
                case A:  testPerson.getTransforms().addAll(translateXLeft); break;
                case D: testPerson.getTransforms().addAll(translateXRight);  break;
                    //case SHIFT:  break;
        default:
            break;
            }
        }
    
    public void checkPersonCoord(){
        
    }
    
    
    @FXML
    public void setHpProgressBar(){
        hpProgressBar.setProgress(0.5);
        System.out.println(getHpProgressBar());
    }
    

        
    public static double getHpProgressBar() {
        return hpProgressBar.getProgress();
    }
    
    
    
}
