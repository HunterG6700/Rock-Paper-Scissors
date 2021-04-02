

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class game extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       FXMLLoader fxmlLoader=new FXMLLoader (game.class.getResource ("game.fxml"));
        Parent root =fxmlLoader.load ();
        Scene scene = new Scene(root);
        stage.setTitle("Rock paper Scissors Game"); // displayed in window's title bar     \
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
