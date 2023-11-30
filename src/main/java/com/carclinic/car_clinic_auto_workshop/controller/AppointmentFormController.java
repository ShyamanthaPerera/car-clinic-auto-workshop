package com.carclinic.car_clinic_auto_workshop.controller;

import com.carclinic.car_clinic_auto_workshop.dto.CustomerDTO;
import com.carclinic.car_clinic_auto_workshop.dto.SlotDTO;
import com.carclinic.car_clinic_auto_workshop.dto.VehicleDTO;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AppointmentFormController {

    public JFXTextArea textNoteCol;
    public TextField textEmployeeID;
    public TextField textEmployeeName;
    public TableView employeeTable;
    public TableColumn employeeIdCol;
    public TableColumn EmployeeNameCol;
    public TextField textSlotNo;
    public TextField textCustomerName;
    public TextField textCustomerID;
    @FXML
    private JFXButton appointmentUpdateBtn;

    @FXML
    private JFXButton appointmentAddBtn;

    @FXML
    private TextField textAppointmentID;

    @FXML
    private TextField textVehicleID;

    @FXML
    private TextField textVehicleModel;

    @FXML
    private JFXDatePicker textDate;

    @FXML
    private JFXTimePicker textTime;

    @FXML
    private TextField textIssue;

    @FXML
    private JFXButton slot01;

    @FXML
    private JFXButton slot02;

    @FXML
    private JFXButton slot03;

    @FXML
    private JFXButton slot04;

    @FXML
    private JFXButton slot05;

    @FXML
    private JFXButton slot06;

    @FXML
    private JFXButton slot07;

    @FXML
    private JFXButton slot08;

    @FXML
    private JFXButton slot09;

    @FXML
    private JFXButton slot10;


    @FXML
    private TableView<?> appointmentTbl;

    @FXML
    private TableColumn<?, ?> appIdCol;

    @FXML
    private TableColumn<?, ?> vclIdCol;

    @FXML
    private TableColumn<?, ?> vclModelCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> timeCol;

    @FXML
    private TableColumn<?, ?> issueCol;

    @FXML
    private TableColumn<?, ?> actionCol;

    @FXML
    private JFXTextField txtdynamicSearch;

    public void getData(VehicleDTO vehicleDTO) {
        textVehicleID.setText(vehicleDTO.getVclId());
        textVehicleModel.setText(vehicleDTO.getModel());
        textCustomerID.setText(vehicleDTO.getCusId());
        textCustomerName.setText(vehicleDTO.getCusName());
    }

    public void getSlotData(SlotDTO slotDTO) {

        textSlotNo.setText(slotDTO.getSlotId());
    }

    @FXML
    void btnAddAppointmentOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddVehicleOnActionInAppointment(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VehicleForm.fxml"));
        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            VehicleFormController controller = loader.getController();
            controller.setScene(stage, this);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnAppointmentClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateAppointmentOnAction(ActionEvent event) {

    }

    public void btnAddEmployeeOnActionInAppointment(ActionEvent actionEvent) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EmployeeForm.fxml"));
        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            EmployeeFormController controller = loader.getController();
            controller.setScene(stage, this);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnAddSlotOnActionInAppointment(ActionEvent actionEvent) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SlotForm.fxml"));
        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            SlotFormController controller = loader.getController();
            controller.setScene(stage, this);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
