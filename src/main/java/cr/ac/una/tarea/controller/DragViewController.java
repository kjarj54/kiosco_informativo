/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.util.DragController;
import cr.ac.una.tarea.util.DragResizer;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class DragViewController extends Controller implements Initializable {

    @FXML
    private CheckBox isDraggableBox;
    private Circle circle;
    @FXML
    private MediaView mediaView;
    
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        file = new File("C:/Users/PC/Downloads/Rick Astley - Never Gonna Give You Up (Official Music Video).mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        
        mediaPlayer.play();
        
        DragController dragController = new DragController(mediaView, true);
        dragController.isDraggableProperty().bind(isDraggableBox.selectedProperty());
        
        
    }    

    @Override
    public void initialize() {
    }
    private void Evento1(MouseEvent event) {
        circle.setFill(Color.RED);
    }

    private void Evento2(MouseEvent event) {
        circle.setFill(Color.DODGERBLUE);
    }
}
