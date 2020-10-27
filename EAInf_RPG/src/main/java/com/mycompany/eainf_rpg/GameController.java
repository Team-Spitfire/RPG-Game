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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
    private static ProgressBar hpProgressBar;
    @FXML
    private ProgressBar testProgressBar;
    
    
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String testtext = "hallo";
        //String currHp = Integer.toString();
        currHpLabel.setText(Integer.toString(App.getPlayer().getCurrHp()));
        maxHpLabel.setText(Integer.toString(App.getPlayer().getMaxHp()));
        hpProgressBar.setProgress(1.0);
        
   
        
    }
    
    public static void setProgress(Double progress){
        
        hpProgressBar.setProgress(progress);
    }
    
    @FXML
    private void btnSettings(ActionEvent event) throws IOException {
        App.setRoot("Options");
    }

    @FXML
    private void setHpProgressBar(ActionEvent event) {
        testProgressBar.setProgress(0.5);
    }
    
    
    
}
