/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.util.AppContext;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class KioscoViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    private List<File> listaImagenes = new ArrayList<>();
    private Media media;
    private File vidFile;
    private MediaPlayer mediaPlayer; 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
/************************************


            Codigo ImageView

***********************************/
        if((Boolean)AppContext.getInstance().get("banderaImg") == true){
            listaImagenes = (List<File>) AppContext.getInstance().get("listaDeImagenes");
            ImageView imgView = new ImageView();
            imgView.setLayoutX((double) AppContext.getInstance().get("imgLayoutX"));
            imgView.setLayoutY((double) AppContext.getInstance().get("imgLayoutY"));
            imgView.setFitHeight((double) AppContext.getInstance().get("imgFitHeight"));
            imgView.setFitWidth((double) AppContext.getInstance().get("imgFitWidth"));
            Timer timer = new Timer();
        
            TimerTask timerTask = new TimerTask() {
                int indice = 0;
                @Override
                public void run() {
                    Image image = new Image("file:"+ listaImagenes.get(indice).getAbsolutePath());
                    imgView.setImage(image);
                    indice++;
                    if(listaImagenes.size() == indice){
                        indice = 0;
                    }
                }
            };
            timer.scheduleAtFixedRate(timerTask, 0, 1000);
        
            root.getChildren().add(imgView);
        }
        

/************************************


            Codigo MediaView

***********************************/
        if((Boolean)AppContext.getInstance().get("banderaVid") == true){
            vidFile = (File) AppContext.getInstance().get("video");
            MediaView mediaView = new MediaView();
            mediaView.setLayoutX((double) AppContext.getInstance().get("mediaViewLayoutX"));
            mediaView.setLayoutY((double) AppContext.getInstance().get("mediaViewLayoutY"));
            mediaView.setFitHeight((double) AppContext.getInstance().get("mediaViewFitHeight"));
            mediaView.setFitWidth((double) AppContext.getInstance().get("mediaViewFitWidth"));
            if(vidFile != null){
                media = new Media(vidFile.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
                mediaPlayer.play();
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                root.getChildren().add(mediaView);
            }
        }
/************************************


            Codigo WedView

***********************************/ 
        if((Boolean)AppContext.getInstance().get("banderaWeb") == true){
            WebView webView = new WebView();
            webView.getEngine().load((String) AppContext.getInstance().get("urlWebView"));
            webView.setLayoutX((double) AppContext.getInstance().get("webViewLayoutX"));
            webView.setLayoutY((double) AppContext.getInstance().get("webViewLayoutY"));
            webView.setMaxHeight((double) AppContext.getInstance().get("webViewHeight"));
            webView.setMaxWidth((double) AppContext.getInstance().get("webViewWidth"));
            root.getChildren().add(webView);
        }

/************************************


            Codigo Label

***********************************/
        if((Boolean)AppContext.getInstance().get("banderaLabel") == true){
            Label label = new Label();
            label.setMaxHeight((double) AppContext.getInstance().get("txtLabelHeight"));
            label.setMaxWidth((double) AppContext.getInstance().get("txtLabelWidth"));
            label.setLayoutX((double) AppContext.getInstance().get("txtLabelLayoutX"));
            label.setLayoutY((double) AppContext.getInstance().get("txtLabelLayoutY"));
            label.setText((String) AppContext.getInstance().get("textoDigitado"));
            root.getChildren().add(label);
            animacionTexto(label);
        }
    }    

    
    public void animacionTexto(Node node){
        
        // translate
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(node);
        translate.setDuration(Duration.millis(2000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(500);
        //translate.setAutoReverse(true);
        translate.play();
    }
        
    @Override
    public void initialize() {
    }
    
}
