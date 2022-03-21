/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class MediaViewController extends Controller implements Initializable {

    @FXML
    private JFXButton btnPlay;
    @FXML
    private JFXButton btnPause;
    @FXML
    private JFXButton btnReset;
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
        // TODO
        file = new File("D:/carpetaU/Primer semestre 2022/Progra 2/Tarea/Intento1/tarea/src/main/resources/cr/ac/una/tarea/resources/asdasdasd parte 6.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }    

    @FXML
    private void onActionBtnPlay(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    private void onActionBtnPause(ActionEvent event) {
        
    }

    @FXML
    private void onActionBtnReset(ActionEvent event) {
        
    }

    @Override
    public void initialize() {
        
    }
    
}
