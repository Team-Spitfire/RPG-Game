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
import javafx.scene.image.Image;
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
    Label maxHpLabel = new Label("maxHp");
    Image image3 = new Image("https://drive.google.com/file/d/1UxU4DNQf2K7mGSKK7-mUvqAkavWLWEMG/preview", 100, 0, false, false);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String testtext = "hallo";
        //String currHp = Integer.toString();
        currHpLabel.setText(Integer.toString(App.getPlayer().getCurrHp()));
        maxHpLabel.setText(Integer.toString(App.getPlayer().getMaxHp()));
        
    }    

    
}
