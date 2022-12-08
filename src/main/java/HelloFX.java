import controllers.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Objects;

public class HelloFX extends Application {
    public static String currentPath;

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("FXML/Homepage.fxml")));
            Parent root = loader.load();

            Controller controller = loader.getController();
            controller.init();

            primaryStage.setScene(new Scene(root));
            primaryStage.setMinHeight(667);
            primaryStage.setMinWidth(375);
            primaryStage.show();
            currentPath = returnPath();
        } catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        } catch (Exception e) {
            e.printStackTrace();
        }


//        String javaVersion = System.getProperty("java.version");
//        String javafxVersion = System.getProperty("javafx.version");
//        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        Scene scene = new Scene(new StackPane(l), 640, 480);
//        stage.setScene(scene);
//        stage.show();
    }

    public static String returnPath() {
        // TeamVeganVampires\src\main\resources\edu\wpi\cs3733\d22\teamV
        String currentPath = System.getProperty("user.dir");
        if (currentPath.contains("teamV") || currentPath.contains("TeamVeganVampires")) {
            int position = currentPath.indexOf("teamV") + 65;
            if (currentPath.length() > position) {
                currentPath = currentPath.substring(0, position);
            }
            currentPath += "/src/main/resources/edu/wpi/cs3733/d22/teamV";
            System.out.println(currentPath);
        }
        return currentPath;
    }

    public static void main(String[] args) {
        launch();
    }

}
