package controllers;

import Objects.Reservation;
import Objects.StringHolder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import Singleton.Context;
import java.util.ArrayList;

public class ReservationsController extends Controller{

    private boolean visible2 = false;
    @FXML private Text warningText1;

    private boolean visible3 = false;
    @FXML private Text warningText2;

    @FXML private TextField searchBar;
    @FXML private TreeTableView<StringHolder> equipmentTable;
    @FXML private TreeTableColumn<StringHolder, String> equipmentCol;

    @FXML private TreeTableView<Reservation> reservationsTable;
    @FXML private TreeTableColumn<Reservation, String> equipmentReservationsCol;
    @FXML private TreeTableColumn<Reservation, String> dateCol;
    @FXML private TreeTableColumn<Reservation, String> timeCol;

    private boolean visible = false;
    @FXML private Pane helpPane;


    @Override
    public void init(){
        updateEquipmentTable();
        updateReservationTable();
        searchBar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                searchReservationTable(newValue);
            }
        });
    }

    private void updateEquipmentTable(){
        ArrayList<String> strs = Context.getInstance().getEquipment();
        ArrayList<StringHolder> sHolds = new ArrayList<>();
        for (String i : strs){
            sHolds.add(new StringHolder(i));
        }
        ArrayList<TreeItem<StringHolder>> treeItems = new ArrayList<>();

        equipmentCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("heldStr"));
        for (StringHolder s : sHolds){
            TreeItem<StringHolder> item = new TreeItem<>(s);
            treeItems.add(item);
        }
        equipmentTable.setShowRoot(false);
        TreeItem<StringHolder> root = new TreeItem<StringHolder>(sHolds.get(0));
        equipmentTable.setRoot(root);
        root.getChildren().addAll(treeItems);
    }

    private void updateReservationTable(){
        ArrayList<Reservation> res = Context.getInstance().getReservations();
        ArrayList<TreeItem<Reservation>> treeItems = new ArrayList<>();
        equipmentReservationsCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("equipment"));
        dateCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("date"));
        timeCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("time"));

        for (Reservation r : res){
            TreeItem<Reservation> item = new TreeItem<>(r);
            treeItems.add(item);
        }
        reservationsTable.setShowRoot(false);
        TreeItem<Reservation> root = new TreeItem<Reservation>(res.get(0));
        reservationsTable.setRoot(root);
        root.getChildren().addAll(treeItems);

    }

    @FXML
    public void searchReservationTable(String keyword) {
        equipmentCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("heldStr"));
        ArrayList<String> strs = Context.getInstance().getEquipment();
        ArrayList<StringHolder> sHolds = new ArrayList<>();
        for (String i : strs){
            sHolds.add(new StringHolder(i));
        }
        ArrayList<TreeItem<StringHolder>> treeItems = new ArrayList<>();

        for (StringHolder s : sHolds){
            if (s.getHeldStr().toLowerCase().contains(keyword.toLowerCase())){
                TreeItem<StringHolder> item = new TreeItem<>(s);
                treeItems.add(item);
            }
        }

        equipmentTable.setShowRoot(false);
        TreeItem<StringHolder> root = new TreeItem<StringHolder>(sHolds.get(0));
        equipmentTable.setRoot(root);
        root.getChildren().addAll(treeItems);

    }

    @FXML
    public void initReservation(Event event){
        try {
            StringHolder sHold = equipmentTable.getSelectionModel().getSelectedItem().getValue();
            Context.getInstance().setEquip(sHold.getHeldStr());
            switchToReservationForm(event);
        } catch (NullPointerException e){
            if (!visible2) {
                visible2 = true;
                warningText1.setVisible(true);
            }
            if (visible3){
                visible3 = false;
                warningText2.setVisible(false);
            }
        }
    }

    @FXML
    public void cancelReservation(Event event){
        try {
            int id = reservationsTable.getSelectionModel().getSelectedItem().getValue().getId();
            Context.getInstance().removeReservation(id);
            updateReservationTable();
        } catch (NullPointerException e) {
            if (!visible3) {
                visible3 = true;
                warningText2.setVisible(true);
            }
            if (visible2){
                visible2 = false;
                warningText1.setVisible(false);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public void helpButton(){
        visible = !visible;
        helpPane.setVisible(visible);
        if (visible3){
            visible3 = false;
            warningText2.setVisible(false);
        }
        if (visible2){
            visible2 = false;
            warningText1.setVisible(false);
        }
    }
}