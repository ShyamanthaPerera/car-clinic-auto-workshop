package com.carclinic.car_clinic_auto_workshop.controller;

import com.carclinic.car_clinic_auto_workshop.dto.CustomerDTO;
import com.carclinic.car_clinic_auto_workshop.dto.SlotDTO;
import com.carclinic.car_clinic_auto_workshop.model.SlotModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class SlotFormController  {

    @FXML
    private Label lblSlotNo;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblSpace;

    @FXML
    private Label lblChargingOutlet;

    @FXML
    private JFXButton btnSlot01;

    @FXML
    private JFXButton btnSlot06;

    @FXML
    private JFXButton btnSlot02;

    @FXML
    private JFXButton btnSlot07;

    @FXML
    private JFXButton btnSlot03;

    @FXML
    private JFXButton btnSlot08;

    @FXML
    private JFXButton btnSlot04;

    @FXML
    private JFXButton btnSlot09;

    @FXML
    private JFXButton btnSlot05;

    @FXML
    private JFXButton btnSlot10;

    SlotModel slotModel = new SlotModel();

    SlotDTO slotDTO = new SlotDTO();

    public AppointmentFormController appointmentFormController;

    public Stage stage;


    public void initialize() {
        ifSlotFree();
    }

    public void loadAllSlots() {
        try {
            List<SlotDTO> dtoList = slotModel.getAllSlot();
            for (int i = 0; i < dtoList.size(); i++) {
                SlotDTO slotDTO = dtoList.get(i);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSlot01OnAction(ActionEvent event) {

        if(appointmentFormController!=null){
            appointmentFormController.getSlotData(slotDTO);
            stage.hide();
        }
    }

    @FXML
    void btnSlot02OnAction(ActionEvent event) {

    }

    @FXML
    void btnSlot03OnAction(ActionEvent event) {

    }

    @FXML
    void btnSlot04OnAction(ActionEvent event) {

    }

    @FXML
    void btnSlot05OnAction(ActionEvent event) {

    }

    @FXML
    void btnSlot06OnAction(ActionEvent event) {

    }

    @FXML
    void btnSlot07OnAction(ActionEvent event) {

    }

    @FXML
    void btnSlot08OnAction(ActionEvent event) {

    }

    @FXML
    void btnSlot09OnAction(ActionEvent event) {

    }

    @FXML
    void btnSlot10OnAction(ActionEvent event) {

    }

    public void ifSlotFree(){
        try {
            List<SlotDTO> dtoList = slotModel.getAllStatus();
            dtoList.forEach(slotDTO -> {
                switch (slotDTO.getSlotId()){
                    case "S01": make(slotDTO.getStatus(),btnSlot01);
                    break;
                    case "S02": make(slotDTO.getStatus(),btnSlot02);
                    break;
                    case "S03": make(slotDTO.getStatus(),btnSlot03);
                    break;
                    case "S04": make(slotDTO.getStatus(),btnSlot04);
                    break;
                    case "S05": make(slotDTO.getStatus(),btnSlot05);
                    break;
                    case "S06": make(slotDTO.getStatus(),btnSlot06);
                    break;
                    case "S07": make(slotDTO.getStatus(),btnSlot07);
                    break;
                    case "S08": make(slotDTO.getStatus(),btnSlot08);
                    break;
                    case "S09": make(slotDTO.getStatus(),btnSlot09);
                    break;
                    case "S10": make(slotDTO.getStatus(),btnSlot10);
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void make(String status,JFXButton button){
        Image image ;

        if(status.equals("FREE")){
            image= new Image(getClass().getResourceAsStream("/view/images/icons8-eye-96.png"));
        }else {
            image= new Image(getClass().getResourceAsStream("/view/images/icons8-car-repair-64.png"));
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
        button.setGraphic(imageView);
    }

    public void setScene(Stage stage, AppointmentFormController appointmentFormController) {
        this.appointmentFormController = appointmentFormController;
        this.stage = stage;
    }
}
