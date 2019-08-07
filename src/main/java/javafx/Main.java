package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sort.SortTypes;

import java.io.IOException;


public class Main extends Application {

    private Scene mainScene;
    private SortTypes sortTypes = new SortTypes();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader();
        mainLoader.setLocation(getClass().getResource("main.fxml"));

        mainScene = new Scene(mainLoader.load());

        ((MainController)mainLoader.getController()).setSortTypes(sortTypes);

        stage.setTitle("Sort Comparison");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    Scene getMainScene() {
        return mainScene;
    }
}
