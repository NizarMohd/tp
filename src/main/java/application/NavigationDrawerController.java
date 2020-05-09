package application;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class NavigationDrawerController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            System.out.println("Entered initialise");
            try {
                VBox vBox = FXMLLoader.load(Objects.requireNonNull(SidePanelController.class.getClassLoader().getResource("SidePanel.fxml")));
                drawer.setSidePane(vBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
            transition.setRate(1);
            hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
                System.out.println("Entered transition");
                transition.setRate(transition.getRate() * -1);
                transition.play();
                if (drawer.isOpened()) {
                    drawer.close();
                } else {
                    drawer.open();
                }
            });
        }
}

