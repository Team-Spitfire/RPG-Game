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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        testPerson.setX(269);
        testPerson.setY(356);
        
    }
    
    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case W:
                testPerson.setY(testPerson.getY() - 16);               
                break;
            case S:
                testPerson.setY(testPerson.getY() + 16);               
                break;
            case A:
                testPerson.setX(testPerson.getX() - 16);               
                break;
            case D:
                testPerson.setX(testPerson.getX() + 16);               
                break;

            default:
                break;
        }
    }
}
