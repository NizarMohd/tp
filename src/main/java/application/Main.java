package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    static Stage currentStage;
    static boolean isSplashLoaded = false;
    static boolean isInitialised = false;

    @Override
    public void start(Stage stage) throws Exception {
        try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(DukeController.class.getClassLoader().getResource("login.fxml")));
                Scene scene = new Scene(root);
                stage.setTitle("Welcome to OrgaNice!");
                stage.setScene(scene);
                stage.show();
                currentStage = stage;
                isInitialised = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    static void setIsSplashLoaded() {
        isSplashLoaded = true;
    }

}