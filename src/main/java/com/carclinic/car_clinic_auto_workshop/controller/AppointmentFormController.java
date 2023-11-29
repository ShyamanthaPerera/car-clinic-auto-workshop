package com.carclinic.car_clinic_auto_workshop.controller;

import com.carclinic.car_clinic_auto_workshop.dto.CustomerDTO;
import com.carclinic.car_clinic_auto_workshop.dto.VehicleDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class AppointmentFormController {


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
    private TextField textDate;

    @FXML
    private TextField textTime;

    @FXML
    private TextField textIssue;

    @FXML
    private JFXTextField txtdynamicSearch;

    public void getData(VehicleDTO vehicleDTO) {

        textVehicleID.setText(vehicleDTO.getVclId());
        textVehicleModel.setText(vehicleDTO.getModel());
    }

    @FXML
    void btnAddAppointmentOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddVehicleOnActionInAppointment(ActionEvent event) {

    }

    @FXML
    void btnAppointmentClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateAppointmentOnAction(ActionEvent event) {

    }

    @FXML
    void dynamicSearchAction(KeyEvent event) {

    }
}
