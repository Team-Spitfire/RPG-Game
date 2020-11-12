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

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class Store_ActiveController implements Initializable {

    @FXML
    private Button shopWeaponLvl2;
    @FXML
    private Button shopWeaponLvl1;
    @FXML
    private Button shopArmorLvl2;
    @FXML
    private Button shopArmorLvl1;
    @FXML
    private Button shopPotionLvl2;
    @FXML
    private Button shopPotionLvl1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buyWeaponLvl2(ActionEvent event) {
        //GameController.upgradeWeapon();
        App.getPlayer().getWeapon().setRare(3);
    }

    @FXML
    private void buyWeaponLvl1(ActionEvent event) {
        //GameController.upgradeWeapon();
        App.getPlayer().getWeapon().setRare(2);
    }

    @FXML
    private void buyArmorLvl2(ActionEvent event) {
        //GameController.upgradeArmor();
        App.getPlayer().getArmor().setRare(3);
    }

    @FXML
    private void buyArmorLvl1(ActionEvent event) {
        //GameController.upgradeArmor();
        App.getPlayer().getArmor().setRare(2);
    }

    @FXML
    private void buyPotionLvl2(ActionEvent event) {
        App.getPlayer().getPotion().setRare(3);
    }

    @FXML
    private void buyPotionLvl1(ActionEvent event) {
        App.getPlayer().getPotion().setRare(2);
    }

    @FXML
    private void btnBackToStore(ActionEvent event) throws IOException {
        App.setRoot("Store");
        
    }
    
}
