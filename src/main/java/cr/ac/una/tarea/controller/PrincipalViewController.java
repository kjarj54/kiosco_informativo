/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.tarea.util.AppContext;
import cr.ac.una.tarea.util.DragController;
import cr.ac.una.tarea.util.DragResizer;
import cr.ac.una.tarea.util.FlowController;
import cr.ac.una.tarea.util.Formato;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    @FXML
    private WebView webView;
    @FXML
    private JFXTextField txtBuscarUrl;
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private JFXButton btnColocarTecto;
    @FXML
    private JFXButton btnColocarVideo;
    @FXML
    private JFXButton btnColocarSitioWeb;
    @FXML
    private AnchorPane rootAnchorImagenes;
    @FXML
    private JFXButton btnColocarImagen;
    @FXML
    private AnchorPane rootTexto;
    @FXML
    private AnchorPane rootVideos;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnQuitarTexto;
    @FXML
    private JFXButton btnQuitarImagen;
    @FXML
    private JFXButton btnQuitarVideo;
    @FXML
    private JFXButton btnQuitarWebView;
    @FXML
    private JFXButton btnSiguente;
    @FXML
    private Label laTexto;
    @FXML
    private JFXCheckBox cbMover;
    @FXML
    private JFXTextArea txtArea;
    
    private File file; 
    private Media media;    
    private File vidFile;   
    private MediaPlayer mediaPlayer;    
    private List<File> listaImagenes = new ArrayList<>();
    private Boolean flag0 = false;
    private Boolean flag1 = false;
    private Boolean flag2 = false;
    private Boolean flag3 = false;
    


    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        laTexto.setText("Texto de ejemplo");
    }    

    @Override
    public void initialize() {
     
    
    }

    @FXML
    private void onActionBtnAceptar(ActionEvent event) {
        //Guarda Informacion del ImageView
        AppContext.getInstance().set("listaDeImagenes", listaImagenes);
        AppContext.getInstance().set("imgLayoutX", imgView.getLayoutX());
        AppContext.getInstance().set("imgLayoutY", imgView.getLayoutY());
        AppContext.getInstance().set("imgFitHeight", imgView.getFitHeight());
        AppContext.getInstance().set("imgFitWidth", imgView.getFitWidth());
        
        //Guarda Informacion del MediaView
        AppContext.getInstance().set("video", vidFile);
        AppContext.getInstance().set("mediaViewLayoutX", mediaView.getLayoutX());
        AppContext.getInstance().set("mediaViewLayoutY", mediaView.getLayoutY());
        AppContext.getInstance().set("mediaViewFitHeight", mediaView.getFitHeight());
        AppContext.getInstance().set("mediaViewFitWidth", mediaView.getFitWidth());
        
        //Guarda Informacion del WebView
        AppContext.getInstance().set("urlWebView",txtBuscarUrl.getText());
        AppContext.getInstance().set("webViewLayoutX", webView.getLayoutX());
        AppContext.getInstance().set("webViewLayoutY", webView.getLayoutY());
        AppContext.getInstance().set("webViewHeight", webView.getMinHeight());
        AppContext.getInstance().set("webViewWidth", webView.getMinWidth());
        
        //Guarda Informacion del Label
        AppContext.getInstance().set("textoDigitado", laTexto.getText());
        AppContext.getInstance().set("txtLabelLayoutX", laTexto.getLayoutX());
        AppContext.getInstance().set("txtLabelLayoutY", laTexto.getLayoutY());
        AppContext.getInstance().set("txtLabelHeight", laTexto.getMaxHeight());
        AppContext.getInstance().set("txtLabelWidth", laTexto.getMaxWidth());
        
        //Banderas
        AppContext.getInstance().set("banderaImg", flag0);
        AppContext.getInstance().set("banderaVid", flag1);
        AppContext.getInstance().set("banderaWeb", flag2);
        AppContext.getInstance().set("banderaLabel", flag3);
        
        
        //abre la vista final del kiosco
        FlowController.getInstance().goViewInWindow("KioscoView");
        ((Stage) btnSalir.getScene().getWindow()).close();     
        
        
    }
    
    @FXML
    private void onActionSalir(ActionEvent event) {
        //cierra la aplicacion
        ((Stage) btnSalir.getScene().getWindow()).close();
    }
    
    @FXML
    private void onActionCbMover(ActionEvent event) {
        DragController dragController = new DragController(mediaView, true);
        dragController.isDraggableProperty().bind(cbMover.selectedProperty());
        
        DragController dragController1 = new DragController(imgView, true);
        dragController1.isDraggableProperty().bind(cbMover.selectedProperty());
        
        DragController dragController2 = new DragController(laTexto, true);
        dragController2.isDraggableProperty().bind(cbMover.selectedProperty());
        
        DragController dragController3 = new DragController(webView,true);
        dragController3.isDraggableProperty().bind(cbMover.selectedProperty());
    }
    

    
/************************************


            Codigo ImageView

***********************************/
    
    @FXML
    private void onActionBtnBuscarImg(ActionEvent event) {
        
        FileChooser fileChooser = new FileChooser();//Instancia el buscador de archivo
        fileChooser.setTitle("Buscar Imagen");//Le pone un titulo a la ventala del buscador
        
        //Filtra la busqueda utilizando las extanciones jpg y png
        fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("All Images", "*.*"),new FileChooser.ExtensionFilter("JPG", "*.jpg"),new FileChooser.ExtensionFilter("PNG", "*.png"));
        
        //trae la imagen
        listaImagenes = fileChooser.showOpenMultipleDialog(null);            
    }


    @FXML
    private void onActionBtnColocarImagen(ActionEvent event) {
        if(rootAnchorImagenes.getChildren().contains(imgView)== true){
            rootAnchorPane.getChildren().add(imgView);
            
            //Hace Redimencionable el objeto
            DragResizer dragResizer = new DragResizer(imgView,null);
            dragResizer.makeResizable(imgView);
            
            Image image = new Image("file:"+ listaImagenes.get(0).getAbsolutePath());
            imgView.setImage(image);  
            flag0 = true;
        }
        
    }
    
    @FXML
    private void onActionBtnQuitarImagen(ActionEvent event) {
        //Vuelve a posicionar el componente en su lugar inicial
        imgView.setLayoutX(24);
        imgView.setLayoutY(65);
        imgView.setFitHeight(185);
        imgView.setFitWidth(289);
        
        if(rootAnchorPane.getChildren().contains(imgView)== true){
            rootAnchorImagenes.getChildren().add(imgView);
            mediaPlayer.pause();
            flag0 = false;
            
        }
    }
    
    @FXML
    private void onActionBtnSiguente(ActionEvent event) {
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
    }


    
/************************************


            Codigo MediaView

***********************************/
    
    @FXML
    private void onActionBtnBucarMediaView(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();//Instancia el buscador de archivo
        fileChooser.setTitle("Buscar Video");//Le pone un titulo a la ventala del buscador
        
        //Filtra la busqueda utilizando las extanciones
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("MP4", "*.mp4"),new FileChooser.ExtensionFilter("VLC", "*.vlc"),new FileChooser.ExtensionFilter("All Images", "*.*"));
        
        //guarda el video
        vidFile = fileChooser.showOpenDialog(null);
        
        //comprueba y luego muestra el video
        if(vidFile != null){
            media = new Media(vidFile.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            mediaPlayer.pause();
        }
               
    }
    
    @FXML
    private void onActionbtnColocarVideo(ActionEvent event) {
        if(rootVideos.getChildren().contains(mediaView) == true){
            rootAnchorPane.getChildren().add(mediaView);
            
            //Hace Redimencionable el objeto
            DragResizer dragResizer = new DragResizer(mediaView,null);
            dragResizer.makeResizable(mediaView);
            flag1 = true;
        }
            
    }
    
    @FXML
    private void onActionBtnQuitarVideo(ActionEvent event) {
        //Vuelve a posicionar el componente en su lugar inicial
        mediaView.setLayoutX(27);
        mediaView.setLayoutY(30);
        mediaView.setFitHeight(200);
        mediaView.setFitWidth(200);
        
        if(rootAnchorPane.getChildren().contains(mediaView) == true){
            rootVideos.getChildren().add(mediaView);
            flag1 = false;
        }        
    }

 /************************************


            Codigo WebView

***********************************/
    
    @FXML
    private void onActionbtnColocarSitioWeb(ActionEvent event) {
        if(rootVideos.getChildren().contains(webView) == true){
           //Posiciona el componente en otro lugar
           rootAnchorPane.getChildren().add(webView);
           
           //Hace Redimencionable el objeto
            DragResizer dragResizer = new DragResizer(webView,null);
            dragResizer.makeResizable(webView); 
            flag2 = true;
        }               
    }
    
    @FXML
    private void onActionBtnBucarWebView(ActionEvent event) { 
        //Busca lo que se haya puesto en el textfield
        webView.getEngine().load(txtBuscarUrl.getText());
    }
    
    @FXML
    private void onActionBtnQuitarWebView(ActionEvent event) {
        //Vuelve a posicionar el componente en su lugar inicial
        webView.setLayoutX(7);
        webView.setLayoutY(359);
        webView.setMaxHeight(187);
        webView.setMaxWidth(311);
        txtBuscarUrl.clear();
        webView.getEngine().load("https://www.google.com/");
        
        if(rootAnchorPane.getChildren().contains(webView) == true){
           rootVideos.getChildren().add(webView);
           flag2 = false;
        }
    }
    
/************************************


            Codigo Label

***********************************/
    
    
    @FXML
    private void onActionBtnColocarTexto(ActionEvent event) {
        if(rootTexto.getChildren().contains(laTexto) == true){
            rootAnchorPane.getChildren().add(laTexto);
            laTexto.setText(txtArea.getText());
            
            DragResizer dragResizer = new DragResizer(laTexto,null);
            dragResizer.makeResizable(laTexto);
            
            imgView.setLayoutX(1);
            imgView.setLayoutY(600);
            
            //animacionTexto(laTexto);
            flag3 = true;
        }
        
    }
    
    @FXML
    private void onActionBtnQuitarTexto(ActionEvent event) {
        laTexto.setLayoutX(88);
        laTexto.setLayoutY(133);
        laTexto.setMaxHeight(173);
        laTexto.setMaxWidth(173);
        laTexto.setText(" ");
        if(rootAnchorPane.getChildren().contains(laTexto) == true){
           rootTexto.getChildren().add(laTexto);
           flag3 = false;
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
}
