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
    private ImageView weaponLvl2;
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
        updateImages();
        
    }    

    public void updateImages(){
        switch (App.getPlayer().getWeapon().getRare()) {
                case 1:
                    weaponLvl2.toFront();
                    shopWeaponLvl1.toFront();
                    break;
                case 2:
                    weaponLvl3.toFront();
                    shopWeaponLvl2.toFront();
                    break;
                case 3:
                    weaponLvl3.toFront();
                    shopWeaponLvl2.toFront();
                    shopWeaponLvl2.setDisable(true);
                    shopWeaponLvl1.setDisable(true);
                    break;
                default:
                    break;
            }
        
        switch (App.getPlayer().getArmor().getRare()) {
                case 1:
                    armorLvl2.toFront();
                    shopArmorLvl1.toFront();
                    break;
                case 2:
                    armorLvl3.toFront();
                    shopArmorLvl2.toFront();
                    break;
                case 3:
                    armorLvl3.toFront();
                    shopArmorLvl2.toFront();
                    shopArmorLvl2.setDisable(true);
                    shopArmorLvl1.setDisable(true);
                    break;
                default:
                    break;
            }
        
        
        switch (App.getPlayer().getPotion().getRare()) {
                case 1:
                    potionLvl2.toFront();
                    shopPotionLvl1.toFront();
                    break;
                case 2:
                    potionLvl3.toFront();
                    shopPotionLvl2.toFront();
                    break;
                case 3:
                    potionLvl3.toFront();
                    shopPotionLvl2.toFront();
                    shopPotionLvl2.setDisable(true);
                    shopPotionLvl1.setDisable(true);
                    break;
                default:
                    break;
            }
    
    }
    
    
    
    
    
    @FXML
    private void buyWeaponLvl2(ActionEvent event) {
        //GameController.upgradeWeapon();
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 20);
        App.getPlayer().getWeapon().setRare(3);
        updateImages();
    }

    @FXML
    private void buyWeaponLvl1(ActionEvent event) {
        //GameController.upgradeWeapon();
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 7);
        App.getPlayer().getWeapon().setRare(2);
        updateImages();
        
    }

    @FXML
    private void buyArmorLvl2(ActionEvent event) {
        //GameController.upgradeArmor();
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 20);
        App.getPlayer().getArmor().setRare(3);
        updateImages();
    }

    @FXML
    private void buyArmorLvl1(ActionEvent event) {
        //GameController.upgradeArmor();
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 7);
        App.getPlayer().getArmor().setRare(2);
        updateImages();
    }

    @FXML
    private void buyPotionLvl2(ActionEvent event) {
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 25);
        App.getPlayer().getPotion().setRare(3);
        updateImages();
    }

    @FXML
    private void buyPotionLvl1(ActionEvent event) {
        App.getPlayer().setGoldCoins(App.getPlayer().getGoldCoins() - 11);
        App.getPlayer().getPotion().setRare(2);
        updateImages();
        
    }

    @FXML
    private void btnBackToStore(ActionEvent event) throws IOException {
        App.setRoot("Store");
        
    }
    
    private void adjustCoinValue(){
        goldCoinValue.setText(Integer.toString(App.getPlayer().getGoldCoins()));
    }
}
