/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eainf_rpg;

import static com.mycompany.eainf_rpg.GameController.getPosX;
import static com.mycompany.eainf_rpg.GameController.getPosY;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Paul
 */
public class StoreController implements Initializable{

    @FXML
    private Pane character;
    @FXML
    private ImageView testPerson;
    @FXML
    private Button btnToShop;
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        testPerson.setX(269);
        testPerson.setY(356);
        
    }
   
    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case W:
                btnToShop.setDisable(true);
                testPerson.setY(testPerson.getY() - 16);
                testPerson.getY();
                testPerson.getX();
                System.out.println(testPerson.getX() + " + " + testPerson.getY());
                checkBtnAccess();
                break;
            case S:
                btnToShop.setDisable(true);
                testPerson.setY(testPerson.getY() + 16);  
                testPerson.getY();
                testPerson.getX();
                System.out.println(testPerson.getX() + " + " + testPerson.getY());
                checkBtnAccess();
                break;
            case A:
                btnToShop.setDisable(true);
                testPerson.setX(testPerson.getX() - 16);  
                testPerson.getY();
                testPerson.getX();
                System.out.println(testPerson.getX() + " + " + testPerson.getY());
                checkBtnAccess();
                break;
            case D:
                btnToShop.setDisable(true);
                testPerson.setX(testPerson.getX() + 16);  
                testPerson.getY();
                testPerson.getX();
                System.out.println(testPerson.getX() + " + " + testPerson.getY());
                checkBtnAccess();
                break;

            default:
                break;
        }
    }
    
    void checkBtnAccess() throws IOException{
        if((int) testPerson.getX() >= 189 && testPerson.getX() <= 365 && (int) testPerson.getY() >= 116 && (int) testPerson.getY() <= 132){
        btnToShop.setDisable(false);
    }
    }
    
    @FXML
    private void btnShop(ActionEvent event) throws IOException {
        if((int) testPerson.getX() >= 189 && testPerson.getX() <= 365 && (int) testPerson.getY() >= 116 && (int) testPerson.getY() <= 132){
            App.setRoot("Store_Active");
        
        }
        
    }
    
}
