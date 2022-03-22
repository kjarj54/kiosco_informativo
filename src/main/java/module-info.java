module cr.ac.una.tarea {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.logging;
    requires javafx.graphicsEmpty;
    requires java.base;
    requires javafx.media;
    requires javafx.web;
    
    opens cr.ac.una.tarea to javafx.fxml, com.jfoenix;
    opens cr.ac.una.tarea.controller to com.jfoenix,javafx.fxml,javafx.media,javafx.web;
    opens cr.ac.una.tarea.util to com.jfoenix,javafx.fxml,javafx.media;
    
    exports cr.ac.una.tarea;
    exports cr.ac.una.tarea.controller;
    exports cr.ac.una.tarea.util;

}
