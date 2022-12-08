package controllers;

import Objects.Reservation;
import Singleton.Context;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.util.ArrayList;

public class HomeController extends Controller{

    @FXML private TreeTableView<Reservation> reservationsTable;
    @FXML private TreeTableColumn<Reservation, String> equipmentReservationsCol;
    @FXML private TreeTableColumn<Reservation, String> dateCol;
    @FXML private TreeTableColumn<Reservation, String> timeCol;

    @Override
    public void init(){
        updateReservationTable();

    }

    @Override
    public void start(Stage primaryStage) {

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
}
