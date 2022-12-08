package controllers;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class WorkoutsController extends Controller{

    @FXML ComboBox<String> workoutCBox;
    @FXML Text titleInfo;
    @FXML Text descriptionText;
    @FXML Text exercisesText;
    @FXML Text repsText;

    private boolean visible = false;
    @FXML private Pane helpPane;

    @Override
    public void init(){
        workoutCBox.getItems().addAll("Push", "Pull", "Legs");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @FXML
    public void updateInfo(){
        String s = workoutCBox.getValue();
        if (s.equals("Push")) {
            titleInfo.setText("Workout: Push");
            descriptionText.setText("Push workouts are used to focus on \naspects of your upper body such as \nyour " +
                    "chest muscles (pecs), your \ntriceps and your shoulders.");
            exercisesText.setText(
                            "Bench Press\n" +
                            "Overhead Press\n" +
                            "Inclined Press\n" +
                            "Pec Flys\n" +
                            "Tricep Press\n" +
                            "Skull Crushers\n" +
                            "Lateral Raises");
            repsText.setText(
                            "4x8\n" +
                            "4x10\n" +
                            "4x10\n" +
                            "3x10\n" +
                            "3x12\n" +
                            "3x8\n" +
                            "4x12");

        } else if (s.equals("Pull")) {
            titleInfo.setText("Workout: Pull");
            descriptionText.setText("Pull workouts are used to focus on \naspects of your upper body such as \nyour " +
                    "back muscles (lats and traps) \nand your biceps.");
            exercisesText.setText(
                            "Lat Pull down\n" +
                            "Barbell Rows\n" +
                            "Cable Rows\n" +
                            "Preacher Curls\n" +
                            "Hammer Curls\n" +
                            "Face Pulls");
            repsText.setText(
                            "4x10\n" +
                            "3x10\n" +
                            "3x10\n" +
                            "3x12\n" +
                            "3x15\n" +
                            "3x12");

        } else {
            titleInfo.setText("Workout: Legs");
            descriptionText.setText("Legs workouts are used to focus on \naspects of your lower body such as \nyour " +
                    "hamstrings, your glutes, \nyour quads and your calves");
            exercisesText.setText(
                            "Squat\n" +
                            "Leg Press\n" +
                            "Hamstring Curls\n" +
                            "Leg Extension\n" +
                            "Hip Abductors\n" +
                            "Hip Adductors\n" +
                            "Calve Raises");
            repsText.setText(
                            "4x8\n" +
                            "4x12\n" +
                            "3x12\n" +
                            "3x12\n" +
                            "3x12\n" +
                            "3x12\n" +
                            "4x12");

        }
    }

    public void helpButton(){
        visible = !visible;
        helpPane.setVisible(visible);
    }
}