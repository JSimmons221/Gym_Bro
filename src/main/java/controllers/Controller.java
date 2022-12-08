package controllers;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Controller extends Application {
    private Parent root;
    FXMLLoader loader = new FXMLLoader();

    @Override
    public void init() {}
    /**
     * Determines if a String is an integer or not
     *
     * @param input is a string
     * @return true if the string is an integer, false if not
     */
    protected boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Determines if a String is a double or not
     *
     * @param input is a string
     * @return true if the string is an double, false if not
     */
    protected boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Closes the program
    @Override
    public void stop() {
        System.out.println("Shutting Down");
        Platform.exit();
    }

    // Switches scene to the home page
    @FXML
    protected void switchToHome(Event event) {
        loader.setLocation(getClass().getClassLoader().getResource("FXML/Homepage.fxml"));
        switchScene(event);
    }

    @FXML
    protected void switchToReservations(Event event) {
        loader.setLocation(getClass().getClassLoader().getResource("FXML/Reservations.fxml"));
        switchScene(event);
    }

    @FXML
    protected void switchToMap(Event event) {
        loader.setLocation(getClass().getClassLoader().getResource("FXML/Map.fxml"));
        switchScene(event);
    }

    @FXML
    protected void switchToWorkouts(Event event) {
        loader.setLocation(getClass().getClassLoader().getResource("FXML/Workouts.fxml"));
        switchScene(event);
    }

    @FXML
    protected void switchToReservationForm(Event event) {
        loader.setLocation(getClass().getClassLoader().getResource("FXML/ReservationForm.fxml"));
        switchScene(event);
    }

    // Switches scene to the root
    @FXML
    protected void switchScene(Event event) {
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Controller controller = loader.getController();
        controller.init();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
