package cr.ac.una.tarea;

import cr.ac.una.tarea.util.FlowController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FlowController.getInstance().InitializeFlow(stage,null);
        stage.getIcons().add(new Image("cr/ac/una/tarea/resources/kiosco.png"));
        stage.setTitle("UNA Tarea");
        FlowController.getInstance().goViewInWindow("Inicio");
    }

    public static void main(String[] args) {
        launch();
    }

}