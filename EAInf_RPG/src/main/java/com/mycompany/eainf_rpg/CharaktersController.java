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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ben bartel
 */
public class CharaktersController implements Initializable {

    @FXML
    private TextField charName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    
    
    @FXML 
    private void addChar(ActionEvent event) throws IOException {
        App.setRoot("Game");
        App.getPlayer().setName(charName.getText());
        System.out.println(App.getPlayer().getName());
    } 
    
    @FXML 
    private void btnback(ActionEvent event) throws IOException {
        App.setRoot("Homescreen");
        
    } 
    
}
