package com.carclinic.car_clinic_auto_workshop.controller;

import com.carclinic.car_clinic_auto_workshop.dto.CustomerDTO;
import com.carclinic.car_clinic_auto_workshop.dto.VehicleDTO;
import com.carclinic.car_clinic_auto_workshop.model.VehicleModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class VehicleFormController {

    @FXML
    private Label lblModel;

    @FXML
    private Label lblId;

    @FXML
    private Label lblCusName;

    @FXML
    private Label lblManufacturer;

    @FXML
    private Label lblCategory;

    @FXML
    private JFXButton vehicleUpdateBtn;

    @FXML
    private JFXButton vehicleAddBtn;

    @FXML
    private TextField textVehicleID;

    @FXML
    private TextField textCustomerID;

    @FXML
    private TextField textCustomerName;

    @FXML
    private TextField textCategory;

    @FXML
    private TextField textManufacturer;

    @FXML
    private TextField textModel;

    @FXML
    private TableView<?> vehicleTbl;

    @FXML
    private TableColumn<?, ?> vehicleIDCol;

    @FXML
    private TableColumn<?, ?> customerIDCol;

    @FXML
    private TableColumn<?, ?> customerNameCol;

    @FXML
    private TableColumn<?, ?> categoryCol;

    @FXML
    private TableColumn<?, ?> manufacturerCol;

    @FXML
    private TableColumn<?, ?> modelCol;

    @FXML
    private TableColumn<?, ?> actionCol1;

    @FXML
    private JFXTextField txtdynamicSearch;

    VehicleModel vehicleModel = new VehicleModel();

    public void initialize() {
        generateNextVehicleId();
    }

    @FXML
    void btnAddCustomerOnActionInVehicle (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CustomerForm.fxml"));
        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            CustomerFormController controller = loader.getController();
            controller.setScene(stage, this);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getData(CustomerDTO customer) {
        System.out.println(customer.getCusName());
        textCustomerID.setText(customer.getCusId());
        textCustomerName.setText(customer.getCusName());
    }

    @FXML
    void btnAddVehicleOnAction(ActionEvent event) {

        String vclId = textVehicleID.getText();
        String cusID = textCustomerID.getText();
        String vclCategory = textCategory.getText();
        String manufacturer = textManufacturer.getText();
        String model = textModel.getText();

        VehicleDTO dto = new VehicleDTO(vclId, cusID, vclCategory, manufacturer, model);

        try {
            boolean isSaved = vehicleModel.saveVehicle(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Saved").show();
                VehicleclearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }

    private void VehicleclearFields() {
    }

    @FXML
    void btnUpdateVehicleOnAction(ActionEvent event) {

    }

    @FXML
    void btnVehicleClearOnAction(ActionEvent event) {

    }

    @FXML
    void dynamicSearchAction(KeyEvent event) {

    }

    @FXML
    void validateVehicleForm(KeyEvent event) {

    }

    private void generateNextVehicleId() {
        try {
            String vehicleId = vehicleModel.generateNextVehicleId();
            textVehicleID.setText(vehicleId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
