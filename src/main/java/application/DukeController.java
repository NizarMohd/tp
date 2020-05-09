package application;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;


public class DukeController {

    static Stage currentStage;
    public static final int SLEEP = 3;
    public static final int NULL_OPACITY = 0;
    public static final int FULL_OPACITY = 1;
    public static final int ONCE = 1;
     static boolean isInitialised = false;
    private static boolean isLoggedIn = false;
    static AnchorPane rootDrawer;
    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblStatus;

    public void login(ActionEvent action) {
        boolean isUserName = txtUserName.getText().equals("user");
        boolean isPassword = txtPassword.getText().equals("password");
        if (isPassword && isUserName) {
            Main.currentStage.close();
            lblStatus.setText("login success");
            isLoggedIn = true;
            try {
                loadSplashScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            lblStatus.setText("login fail");
            lblStatus.textFillProperty().setValue(Paint.valueOf("red"));
        }
    }

    public static void loadSplashScreen() throws IOException {
        currentStage = new Stage();
        Main.setIsSplashLoaded();
        AnchorPane root = FXMLLoader.load(Objects.requireNonNull(DukeController.class.getClassLoader().getResource("WelcomePage.fxml")));
        Scene scene = new Scene(root, 400, 400);
        currentStage.setScene(scene);
        currentStage.show();
        startFadeIn(root);
    }

    private static void startFadeIn(AnchorPane root) {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(SLEEP), root);
        fadeIn.setFromValue(NULL_OPACITY);
        fadeIn.setToValue(FULL_OPACITY);
        fadeIn.setCycleCount(ONCE);
        fadeIn.play();

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(SLEEP), root);
        fadeOut.setFromValue(FULL_OPACITY);
        fadeOut.setToValue(NULL_OPACITY);
        fadeOut.setCycleCount(ONCE);

        fadeIn.setOnFinished(e -> {
            fadeOut.play();
        });

        fadeOut.setOnFinished( e-> {
            currentStage.close();
            try {
                showMainPage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void showMainPage() throws IOException {
        currentStage = new Stage();
        System.out.println("load drawer");
        rootDrawer = FXMLLoader.load(Objects.requireNonNull(NavigationDrawerController.class.getClassLoader().getResource("MainPage.fxml")));
        Scene scene = new Scene(rootDrawer);
        currentStage.setScene(scene);
        currentStage.show();
    }

    public void register(ActionEvent action) {


    }


}
