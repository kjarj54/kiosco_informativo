/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.tarea.util.AppContext;
import cr.ac.una.tarea.util.DragController;
import cr.ac.una.tarea.util.DragResizer;
import cr.ac.una.tarea.util.FlowController;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    
    private File file;
    
    private Media media;
    
    private File vidFile;
    
    private MediaPlayer mediaPlayer;
    
    private List<File> listaImagenes = new ArrayList<>();
    @FXML
    private JFXButton btnSiguente;
    @FXML
    private TextFlow txtFlow;
    @FXML
    private JFXTextArea txtArea;
    
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
        listaImagenes = fileChooser.showOpenMultipleDialog(null);
        
        //comprueba y luego muestra la imagen
//        if(listaImagenes != null){
//            Image image[] = new Image[listaImagenes.size()];
//            for(int i=0;i < listaImagenes.size();i++){
//                
//                image[i] = new Image("file:"+ listaImagenes.get(i));
//                imgView.setImage(image[i]);
//                System.out.println(listaImagenes.get(i));
//            }
//            
//        }
        
    }

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
    private void onActionBtnBucarWebView(ActionEvent event) { 
        //Busca lo que se haya puesto en el textfield
        webView.getEngine().load(txtBuscarUrl.getText());
    }

    @FXML
    private void onActionBtnAceptar(ActionEvent event) {
        //abre la vista final del kiosco
        FlowController.getInstance().goViewInWindow("KioscoView");
        ((Stage) btnSalir.getScene().getWindow()).close();
    }

    @FXML
    private void onActionbtnColocarVideo(ActionEvent event) {
        if(rootVideos.getChildren().contains(mediaView) == true){
            rootAnchorPane.getChildren().add(mediaView);
            
            //Hace que el componente se pueda mover
            DragController dragController2 = new DragController(mediaView,true);
            dragController2.isDraggableProperty();
            
            //Hace Redimencionable el objeto
            DragResizer dragResizer = new DragResizer(mediaView);
            dragResizer.makeResizable(mediaView);
            
            mediaPlayer.play();
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        }
            
    }

    @FXML
    private void onActionbtnColocarSitioWeb(ActionEvent event) {
        if(rootVideos.getChildren().contains(webView) == true){
           //Posiciona el componente en otro lugar
           rootAnchorPane.getChildren().add(webView);
           
           //Hace que el componente se pueda mover       
           DragController dragController3 = new DragController(webView,true);
           dragController3.isDraggableProperty();
           
           //Hace Redimencionable el objeto
            DragResizer dragResizer = new DragResizer(webView);
            dragResizer.makeResizable(webView);
           
        }
        
            
    }

    @FXML
    private void onActionBtnColocarTexto(ActionEvent event) {
        if(true){
            rootAnchorPane.getChildren();
        }
        
    }

    @FXML
    private void onActionBtnColocarImagen(ActionEvent event) {
        if(rootAnchorImagenes.getChildren().contains(imgView)== true){
            rootAnchorPane.getChildren().add(imgView);
            
            //Hace que el componente se pueda mover
            //DragController dragController = new DragController(imgView, true);
            //dragController.isDraggableProperty();
            
            //Hace Redimencionable el objeto
            DragResizer dragResizer = new DragResizer(imgView);
            dragResizer.makeResizable(imgView);
            
            
        }
        
    }

    @FXML
    private void onActionSalir(ActionEvent event) {
        //cierra la aplicacion
        ((Stage) btnSalir.getScene().getWindow()).close();
    }

    @FXML
    private void onActionBtnQuitarTexto(ActionEvent event) {
        
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
        }        
    }

    @FXML
    private void onActionBtnQuitarWebView(ActionEvent event) {
        //Vuelve a posicionar el componente en su lugar inicial
        webView.setLayoutX(7);
        webView.setLayoutY(359);
        webView.setMaxHeight(187);
        webView.setMaxWidth(311);
        txtBuscarUrl.clear();
        
        if(rootAnchorPane.getChildren().contains(webView) == true){
           rootVideos.getChildren().add(webView);
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
    
    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 10000);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}
