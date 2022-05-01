/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.tarea.util.FlowController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
/**
 * FXML Controller class
 *
 * @author kevin
 */
public class InicioController extends Controller implements Initializable {

    @FXML
    private JFXButton btnPasar;
    @FXML
    private BorderPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
        
    }

    @FXML
    private void onActionBtnPasar(ActionEvent event) {
       FlowController.getInstance().goMain();
       //FlowController.getInstance().goViewInWindow("Pruebas");
       getStage().close();
    }
    
}
