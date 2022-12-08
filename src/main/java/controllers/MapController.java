package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MapController extends Controller{

    @FXML Text titleText;
    @FXML Text infoText;
    @FXML Pane infoPane;

    private int machine = -1;
    private boolean visible = false;

    private boolean visible2 = false;
    @FXML private Pane helpPane;

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @FXML
    private void treadmillInfo(Event event){
        if (!visible) {
            machine = 0;
            visible = true;
            infoPane.setVisible(true);

            titleText.setText("Treadmill");
            infoText.setText("Info for the machine will be placed \n here eventually");

        }
        else if (machine != 0){
            machine = 0;
            titleText.setText("Treadmill");
            infoText.setText("Info for the machine will be placed \n here eventually");

        } else {
            machine = -1;
            visible = false;
            infoPane.setVisible(false);

        }
    }

    @FXML
    private void ergInfo(Event event){
        if (!visible) {
            machine = 1;
            visible = true;
            infoPane.setVisible(true);

            titleText.setText("Rowing Machine");
            infoText.setText("Info for the machine will be placed \n here eventually");

        }
        else if (machine != 1){
            machine = 1;
            titleText.setText("Rowing Machine");
            infoText.setText("Info for the machine will be placed \n here eventually");

        } else {
            machine = -1;
            visible = false;
            infoPane.setVisible(false);

        }
    }

    @FXML
    private void benchInfo(Event event){
        if (!visible) {
            machine = 2;
            visible = true;
            infoPane.setVisible(true);

            titleText.setText("Bench Press");
            infoText.setText("Info for the equipment will be placed \n here eventually");

        }
        else if (machine != 2){
            machine = 2;
            titleText.setText("Bench Press");
            infoText.setText("Info for the equipment will be placed \n here eventually");

        } else {
            machine = -1;
            visible = false;
            infoPane.setVisible(false);

        }
    }

    @FXML
    private void crunchInfo(Event event){
        if (!visible) {
            machine = 3;
            visible = true;
            infoPane.setVisible(true);

            titleText.setText("Weighted Crunch");
            infoText.setText("Info for the machine will be placed \n here eventually");

        }
        else if (machine != 3){
            machine = 3;
            titleText.setText("Weighted Crunch");
            infoText.setText("Info for the machine will be placed \n here eventually");

        } else {
            machine = -1;
            visible = false;
            infoPane.setVisible(false);

        }
    }

    @FXML
    private void inclinedInfo(Event event){
        if (!visible) {
            machine = 4;
            visible = true;
            infoPane.setVisible(true);

            titleText.setText("Inclined Sit-up");
            infoText.setText("Info for the equipment will be placed \n here eventually");

        }
        else if (machine != 4){
            machine = 4;
            titleText.setText("Inclined Sit-up");
            infoText.setText("Info for the equipment will be placed \n here eventually");

        } else {
            machine = -1;
            visible = false;
            infoPane.setVisible(false);

        }
    }

    @FXML
    private void pecFlyInfo(Event event){
        if (!visible) {
            machine = 5;
            visible = true;
            infoPane.setVisible(true);

            titleText.setText("Pec Fly Machine");
            infoText.setText("Info for the machine will be placed \n here eventually");

        }
        else if (machine != 5){
            machine = 5;
            titleText.setText("Pec Fly Machine");
            infoText.setText("Info for the machine will be placed \n here eventually");

        }
        else {
            machine = -1;
            visible = false;
            infoPane.setVisible(false);

        }
    }

    @FXML
    private void chestPressInfo(Event event){
        if (!visible) {
            machine = 6;
            visible = true;
            infoPane.setVisible(true);

            titleText.setText("Chest Press");
            infoText.setText("Info for the machine will be placed \n here eventually");

        }
        else if (machine != 6){
            machine = 6;
            titleText.setText("Chest Press");
            infoText.setText("Info for the machine will be placed \n here eventually");

        } else {
            machine = -1;
            visible = false;
            infoPane.setVisible(false);

        }
    }

    @FXML
    private void legExtensionInfo(Event event){
        if (!visible) {
            machine = 7;
            visible = true;
            infoPane.setVisible(true);

            titleText.setText("Leg Extension Machine");
            infoText.setText("Info for the machine will be placed \n here eventually");

        }
        else if (machine != 7){
            machine = 7;
            titleText.setText("Leg Extension Machine");
            infoText.setText("Info for the machine will be placed \n here eventually");

        } else {
            machine = -1;
            visible = false;
            infoPane.setVisible(false);

        }
    }

    @FXML
    private void cableInfo(Event event) {
        if (!visible) {
            machine = 8;
            visible = true;
            infoPane.setVisible(true);

            titleText.setText("Cables");
            infoText.setText("Info for the machine will be placed \n here eventually");

        } else if (machine != 8) {
            machine = 8;
            titleText.setText("Cables");
            infoText.setText("Info for the machine will be placed \n here eventually");

        } else {
            machine = -1;
            visible = false;
            infoPane.setVisible(false);

        }
    }

    @FXML
    private void squatInfo(Event event) {
        if (!visible) {
            machine = 9;
            visible = true;
            infoPane.setVisible(true);

            titleText.setText("Squat Rack");
            infoText.setText("Info for the equipment will be placed \n here eventually");

        } else if (machine != 9) {
            machine = 9;
            titleText.setText("Squat Rack");
            infoText.setText("Info for the equipment will be placed \n here eventually");

        } else {
            machine = -1;
            visible = false;
            infoPane.setVisible(false);

        }
    }

    @FXML
    private void hamCurlInfo(Event event) {
        if (!visible) {
            machine = 10;
            visible = true;
            infoPane.setVisible(true);

            titleText.setText("Hamstring Curl Machine");
            infoText.setText("Info for the machine will be placed \n here eventually");

        } else if (machine != 10) {
            machine = 10;
            titleText.setText("Hamstring Curl Machine");
            infoText.setText("Info for the machine will be placed \n here eventually");

        } else {
            machine = -1;
            visible = false;
            infoPane.setVisible(false);

        }
    }

    public void helpButton(){
        visible = !visible;
        helpPane.setVisible(visible);
    }

}
