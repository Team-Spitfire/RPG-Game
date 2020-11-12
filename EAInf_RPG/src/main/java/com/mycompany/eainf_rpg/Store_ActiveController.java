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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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
    @FXML
    private Label goldCoinValue;
    @FXML
    private ImageView weaponLvl3;
    @FXML
    private ImageView weapomLvl2;
    @FXML
    private ImageView armorLvl3;
    @FXML
    private ImageView armorLvl2;
    @FXML
    private ImageView potionLvl3;
    @FXML
    private ImageView potionLvl2;
        

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
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 20);
        App.getPlayer().getWeapon().setRare(3);
        shopWeaponLvl2.setDisable(true);
    }

    @FXML
    private void buyWeaponLvl1(ActionEvent event) {
        //GameController.upgradeWeapon();
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 7);
        App.getPlayer().getWeapon().setRare(2);
        weaponLvl3.toFront();
        shopWeaponLvl2.toFront();
        
    }

    @FXML
    private void buyArmorLvl2(ActionEvent event) {
        //GameController.upgradeArmor();
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 20);
        App.getPlayer().getArmor().setRare(3);
        shopArmorLvl2.setDisable(true);
    }

    @FXML
    private void buyArmorLvl1(ActionEvent event) {
        //GameController.upgradeArmor();
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 7);
        App.getPlayer().getArmor().setRare(2);
        armorLvl3.toFront();
        shopArmorLvl2.toFront();
    }

    @FXML
    private void buyPotionLvl2(ActionEvent event) {
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 25);
        App.getPlayer().getPotion().setRare(3);
        shopPotionLvl2.setDisable(true);
    }

    @FXML
    private void buyPotionLvl1(ActionEvent event) {
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 11);
        App.getPlayer().getPotion().setRare(2);
        potionLvl3.toFront();
        shopPotionLvl2.toFront();
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 7);
    }

    @FXML
    private void btnBackToStore(ActionEvent event) throws IOException {
        App.setRoot("Store");
        
    }
    
    private void adjustCoinValue(){
        goldCoinValue.setText(Integer.toString(App.getPlayer().getGoldCoins()));
    }
}
