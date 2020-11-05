/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eainf_rpg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author benbartel
 */
public class FightController implements Initializable {

    @FXML
    private Pane playerStuff;
    @FXML
    private ProgressBar playerHpBar;
    @FXML
    private ImageView charImage;
    @FXML
    private Pane enemyStuff;
    @FXML
    private ImageView enemyImage;
    @FXML
    private ProgressBar enemyHpBar;
    @FXML
    private Button atckBtn;
    @FXML
    private Button potionBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updatePlayerBar();
    }    

    public void updatePlayerBar(){
        double barValue = App.getPlayer().getCurrHp();
        double barValueSmall = barValue / 100;
        playerHpBar.setProgress(barValueSmall);
    }
    public void updateEnemyBar(){
        double barValue = 1;
        
        switch (App.getPlayer().getEnemy().getMaxHp()) {
            case 50:
                barValue = App.getPlayer().getEnemy().getCurrHp() * 2;
                break;
            case 80:
                barValue = App.getPlayer().getEnemy().getCurrHp() * 1.25;
                break;
            case 125:
                barValue = App.getPlayer().getEnemy().getCurrHp() * 0.8;
                break;
            default:
                break;
        }
        
        
        double barValueSmall = barValue / 100;
        enemyHpBar.setProgress(barValueSmall);
    }
    
    
    @FXML
    private void btnAtck(ActionEvent event) {
        App.getPlayer().weaponHit();
        atckBtn.setDisable(true);
        potionBtn.setDisable(true);
    }

    @FXML
    private void btnUsePotion(ActionEvent event) {
        App.getPlayer().usePotion();
        potionBtn.setDisable(true);
        atckBtn.setDisable(true);
    }
    
}
