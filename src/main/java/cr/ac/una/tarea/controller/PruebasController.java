/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.util.DragResizer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author UNA-Audivisuales
 */
public class PruebasController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DragResizer dragResizer = new DragResizer(imgView,null);
        dragResizer.makeResizable(imgView);
        
    }    

    @Override
    public void initialize() {
        
    }
    
    
    
}
