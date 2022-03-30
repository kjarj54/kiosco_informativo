/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.tarea.util.FlowController;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class PrincipalViewController extends Controller implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private JFXButton btnBuscarImg;
    @FXML
    private ImageView imgView;
    @FXML
    private JFXButton btnBuscarMediaView;
    @FXML
    private JFXButton btnBuscarWebView;
    @FXML
    private JFXButton btnAceptar;
    @FXML
    private MediaView mediaView;
    
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    @FXML
    private WebView webView;
    
    
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
    private void onActionBtnBuscarImg(ActionEvent event) {
        
        FileChooser fileChooser = new FileChooser();//Instancia el buscador de archivo
        fileChooser.setTitle("Buscar Imagen");//Le pone un titulo a la ventala del buscador
        
        //Filtra la busqueda utilizando las extanciones jpg y png
        fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("All Images", "*.*"),new FileChooser.ExtensionFilter("JPG", "*.jpg"),new FileChooser.ExtensionFilter("PNG", "*.png"));
        
        //trae la imagen
        File imagFile = fileChooser.showOpenDialog(null);
        
        //comprueba y luego muestra la imagen
        if(imagFile != null){
            Image image = new Image("file:"+imagFile.getAbsolutePath());
            imgView.setImage(image);
        }
        
    }

    @FXML
    private void onActionBtnBucarMediaView(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();//Instancia el buscador de archivo
        fileChooser.setTitle("Buscar Video");//Le pone un titulo a la ventala del buscador
        
        //Filtra la busqueda utilizando las extanciones
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("MP4", "*.mp4"),new FileChooser.ExtensionFilter("VLC", "*.vlc"),new FileChooser.ExtensionFilter("All Images", "*.*"));
        
        //guarda el video
        File vidFile = fileChooser.showOpenDialog(null);
        
        if(vidFile != null){
            media = new Media(vidFile.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        }
               
    }

    @FXML
    private void onActionBtnBucarWebView(ActionEvent event) {

    }

    @FXML
    private void onActionBtnAceptar(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("KioscoView");
        getStage().close();
    }
    
}
