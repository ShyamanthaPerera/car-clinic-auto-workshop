package com.carclinic.car_clinic_auto_workshop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {

    public AnchorPane root;
    @FXML
    private Label lblLogginUser;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    void btnAppointmentsOnAction(ActionEvent event) throws IOException {

//        root.getChildren().clear();
//        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/.fxml")));

    }

    @FXML
    void btnCustomersOnAction(ActionEvent event) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/CustomerForm.fxml")));

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/SlotForm.fxml")));

    }

    @FXML
    void btnEmployeesOnAction(ActionEvent event) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/EmployeeForm.fxml")));
    }

    @FXML
    void btnItemsOnAction(ActionEvent event) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ItemForm.fxml")));

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {

//        root.getChildren().clear();
//        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/.fxml")));

    }

    @FXML
    void btnSuppliersOnAction(ActionEvent event) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/SupplierForm.fxml")));

    }

    @FXML
    void btnUsersOnAction(ActionEvent event) throws IOException {

        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/UserForm.fxml")));

    }

    @FXML
    void btnVehiclesOnAction(ActionEvent event) throws IOException {

//        root.getChildren().clear();
//        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/VehicleForm.fxml")));

    }
}
