/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.util.AppContext;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class KioscoViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    private MediaView mediaView;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // mediaView = new MediaView();
        
       // root.getChildren().addAll((Node[]) AppContext.getInstance().get("Video"));

    }    

    @Override
    public void initialize() {
    }
    
}
