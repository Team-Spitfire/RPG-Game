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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
    @FXML
    private ImageView itemSlot3;
    @FXML
    private ImageView itemSlot2;
    @FXML
    private ImageView itemSlot1;
    
    
    @FXML
    static ProgressBar hpProgressBar = new ProgressBar();
    
    @FXML
    private ImageView testPerson;
    
    
    //@FXML
    //private Circle person = new Circle(10, Color.RED);
    
    //Group groupTest = new Group(person);
    
    @FXML
    Translate translateXRight = new Translate();       
    Translate translateYUp = new Translate();
    Translate translateXLeft = new Translate();       
    Translate translateYDown = new Translate();
    
    
    
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        String testtext = "hallo";
        //String currHp = Integer.toString();
        currHpLabel.setText(Integer.toString(App.getPlayer().getCurrHp()));
        maxHpLabel.setText(Integer.toString(App.getPlayer().getMaxHp()));
        hpProgressBar.setProgress(0.8);
        App.getPlayer().setCurrHp(60);
        
        //person.setCenterX(150.0f); 
        //person.setCenterY(200.0f); 
        
        translateXRight.setX(30);
        translateYUp.setY(-30);
        translateXLeft.setX(-30);
        translateYDown.setY(30);
        
        //moveCircleOnKeyPress();
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
        //person.setTranslateY(10.0);
        System.out.println("testloly");
    }
    
    public void btnMovePersonXRight(ActionEvent event) throws IOException {
        testPerson.getTransforms().addAll(translateXRight);
        //person.setTranslateX(10.0);
        System.out.println("testlolx");
    }
    
    public void btnMovePersonYDown(ActionEvent event) throws IOException {
        testPerson.getTransforms().addAll(translateYDown); 
        //person.setTranslateY(10.0);
        System.out.println("testloly");
    }
    
    public void btnMovePersonXLeft(ActionEvent event) throws IOException {
        testPerson.getTransforms().addAll(translateXLeft); 
        //person.setTranslateX(10.0);
        System.out.println("testlolx");
    }
    
    
    
        @FXML
        void keyPressed(KeyEvent event) {
            switch (event.getCode()) {
                    case W:    testPerson.getTransforms().addAll(translateYUp); break;
                    case S:  testPerson.getTransforms().addAll(translateYDown); break;
                    case A:  testPerson.getTransforms().addAll(translateXLeft); break;
                    case D: testPerson.getTransforms().addAll(translateXRight); break;
                    //case SHIFT:  break;
            default:
                break;
            }
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
