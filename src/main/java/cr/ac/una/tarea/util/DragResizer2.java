/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.util;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;

/**
 *
 * @author kevin
 */
public class DragResizer2 {
    
    private static final int RESIZE_MARGIN = 5;
    private final Node node;
    private double y;
    private double x;
    private boolean initMinHeight;
    private boolean initMinWidth;
    private boolean dragging;
    
    public DragResizer2(Node aNode){
        node = aNode;
    }
    
    public static void makeResizable(Node node){
        final DragResizer2 resizer = new DragResizer2(node);
        
        node.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                resizer.mousePresseed(event);
            }           
        });
        
        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resizer.mouseDragged(event);
        }});
        
        node.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resizer.mouseOver(event);
            }});
        
        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resizer.mouseReleased(event);
            }});
        
    }

    private void mouseDragged(MouseEvent event) {
        if(!dragging) {
            return;
        }
        
        double mousey = event.getY();
        double mousex = event.getX();
         
        if(node instanceof ImageView){
            double newHeight = ((ImageView)node).getFitHeight()+ (mousey - y);
            double newWidth = ((ImageView)node).getFitWidth()+ (mousey - x);
            ((ImageView)node).setFitHeight(newHeight);  
            ((ImageView)node).setFitWidth(newWidth); 
        }
        if(node instanceof MediaView){
           double newHeight = ((MediaView)node).getFitHeight()+ (mousey - y);
           double newWidth = ((MediaView)node).getFitWidth()+ (mousey - x);
           ((MediaView)node).setFitHeight(newHeight);
           ((MediaView)node).setFitWidth(newWidth);
        }
        if(node instanceof WebView){
          double newHeight = ((WebView)node).getHeight()+ (mousey - y);
          double newWidth = ((WebView)node).getWidth()+ (mousey - x);
          ((WebView)node).setMinHeight(newHeight);
          ((WebView)node).setMinWidth(newWidth);
        }
        if(node instanceof Label){
           double newHeight = ((Label)node).getHeight()+ (mousey - y);
           double newWidth = ((Label)node).getWidth()+ (mousey - x);
           ((Label)node).setMinHeight(newHeight);
           ((Label)node).setMinWidth(newWidth);
        }

        
        
        y = mousey;
        x = mousex;
    }

    private void mousePresseed(MouseEvent event) {
       // ignore clicks outside of the draggable margin
        if(!isInDraggableZone(event)) {
            return;
        }
        
        dragging = true;
        
        // make sure that the minimum height is set to the current height once,
        // setting a min height that is smaller than the current height will
        // have no effect
        if(node instanceof ImageView){
            
           if (!initMinHeight || !initMinWidth) {
                ((ImageView)node).setFitHeight(((ImageView)node).getFitHeight());
                ((ImageView)node).setFitWidth(((ImageView)node).getFitWidth());
                initMinHeight = true;
                initMinWidth = true;
            } 
        }
        if(node instanceof MediaView){
           if (!initMinHeight || !initMinWidth) {
                ((MediaView)node).setFitHeight(((MediaView)node).getFitHeight());
                ((MediaView)node).setFitWidth(((MediaView)node).getFitWidth());
                initMinHeight = true;
                initMinWidth = true;
            } 
        }
        if(node instanceof WebView){
           if (!initMinHeight || !initMinWidth) {
                ((WebView)node).setMinHeight(((WebView)node).getHeight());
                ((WebView)node).setMinWidth(((WebView)node).getWidth());
                initMinHeight = true;
                initMinWidth = true;
            } 
        }
        if(node instanceof Label){
           if (!initMinHeight || !initMinWidth) {
                ((Label)node).setMinHeight(((Label)node).getHeight());
                ((Label)node).setMinWidth(((Label)node).getWidth());
                initMinHeight = true;
                initMinWidth = true;
            } 
        }        
        
        y = event.getY();
        x = event.getX();
    }

    private void mouseOver(MouseEvent event) {
        if(isInDraggableZone(event) || dragging) {
            node.setCursor(Cursor.S_RESIZE);
        }
        else {
            node.setCursor(Cursor.DEFAULT);
        }    }

    private void mouseReleased(MouseEvent event) {
        dragging = false;
        node.setCursor(Cursor.DEFAULT);
    }
    
    protected boolean isInDraggableZone(MouseEvent event) {
        if(node instanceof ImageView ){
            return event.getY() > (((ImageView)node).getFitHeight()- RESIZE_MARGIN);
        }
        if(node instanceof MediaView){
          return event.getY() > (((MediaView)node).getFitHeight()- RESIZE_MARGIN);  
        }
        if(node instanceof WebView){
          return event.getY() > (((WebView)node).getHeight()- RESIZE_MARGIN);  
        }
        if(node instanceof Label){
          return event.getY() > (((Label)node).getHeight()- RESIZE_MARGIN);  
        }
        
        return event.getY() > (((ImageView)node).getFitHeight() - RESIZE_MARGIN);
    }
    
    
    
}
