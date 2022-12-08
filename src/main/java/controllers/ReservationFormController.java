package controllers;

import Objects.Reservation;
import Singleton.Context;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.Event;


public class ReservationFormController extends Controller{

    @FXML Text equipmentText;
    @FXML Text warningText;
    @FXML ComboBox<String> timeCBox;
    @FXML ComboBox<String> dateCBox;

    private boolean visible = false;
    @FXML private Pane helpPane;

    @Override
    public void init(){
        equipmentText.setText("Equipment: " + Context.getInstance().getEquip());

        for (int i = 6; i < 19; i++) {
            for (int j = 0; j < 60; j+= 15) {
                String time = "";
                if (j >= 10) {
                    if (i < 12) time = Integer.toString(i) + ":" + Integer.toString(j) + " am";
                    else if (i == 12) time = "12:" + Integer.toString(j) + " pm";
                    else time = Integer.toString(i - 12) + ":" + Integer.toString(j) + " pm";

                } else if (j > 0){
                    if (i < 12) time = Integer.toString(i) + ":0" + Integer.toString(j) + " am";
                    else if (i == 12) time = "12:0" + Integer.toString(j) + " pm";
                    else time = Integer.toString(i - 12) + ":0" + Integer.toString(j) + " pm";

                } else {
                    if (i < 12) time = Integer.toString(i) + ":00 am";
                    else if (i == 12) time = "12:00 pm";
                    else time = Integer.toString(i - 12) + ":00 pm";
                }

                timeCBox.getItems().addAll(time);
            }
        }
        dateCBox.getItems().addAll("12/5", "12/6", "12/7", "12/8", "12/9");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @FXML
    public void submit(Event event){
        if (timeCBox.getValue() != null && dateCBox.getValue() != null){
            if (Context.getInstance().checkReservation(dateCBox.getValue(), timeCBox.getValue())) {
                Context.getInstance().addReservation(Context.getInstance().getEquip(), dateCBox.getValue(), timeCBox.getValue());
                switchToReservations(event);
            } else {
                warningText.setText("You already have a reservation at this time");
            }
        } else {
            warningText.setText("Time or Date not selected");
        }
    }

    public void helpButton(){
        visible = !visible;
        helpPane.setVisible(visible);
    }
}
