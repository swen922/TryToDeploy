import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.SomeWindowController;

import java.io.IOException;

public class Main extends Application {

    private Stage primary;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primary = primaryStage;

        showSomeWindow();

    }

    public void showSomeWindow() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/SomeWindow.fxml"));
            AnchorPane somePane = (AnchorPane) loader.load();

            Scene scene = new Scene(somePane);
            primary.setScene(scene);

            SomeWindowController controller = loader.getController();

            primary.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
