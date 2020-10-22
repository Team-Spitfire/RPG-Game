/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eainf_rpg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author hanne
 */
public class HomescreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    

        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void btnStart(ActionEvent event) throws IOException {
        App.setRoot("Charakters");
        
    }

    @FXML
    private void btnOptions(ActionEvent event) throws IOException {
        App.setRoot("Options");
    }
    
}
