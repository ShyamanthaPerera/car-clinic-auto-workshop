package com.carclinic.car_clinic_auto_workshop.controller;

import com.carclinic.car_clinic_auto_workshop.dto.CustomerDTO;
import com.carclinic.car_clinic_auto_workshop.dto.tm.CustomerTM;
import com.carclinic.car_clinic_auto_workshop.model.CustomerModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.paint.Color;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CustomerFormController {

    public TableColumn emailCol;
    public Label lblName;
    public Label lblId;
    public Label lblAddress;
    public Label lblEmail;
    public Label lblTel;
    @FXML
    private JFXTextField txtdynamicSearch;

    @FXML
    private JFXTextField textCustomerID;

    @FXML
    private JFXTextField textCustomerName;

    @FXML
    private JFXTextField txtContactNumber;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private TableView<CustomerTM> CustomerTbl;

    @FXML
    private TableColumn<?, ?> customerIDCol;

    @FXML
    private TableColumn<?, ?> customerNameCol;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> contactCol;

    @FXML
    private TableColumn<?, ?> actionCol;

    CustomerModel customerModel = new CustomerModel();

    public void initialize(){
        setCellValueFactory();
        loadAllCustomers();
    }

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {

        String cusId = textCustomerID.getText();
        String cusName = textCustomerName.getText();
        String cusAddress = txtAddress.getText();
        String cusEmail = txtEmail.getText();
        String cusTel = txtContactNumber.getText();

        if (validateInput(cusId, cusName, cusAddress, cusTel)) {
            CustomerDTO dto = new CustomerDTO(cusId, cusName, cusAddress, cusEmail, cusTel);

            try {
                boolean isSaved = customerModel.saveCustomer(dto);

                if (isSaved){
                    new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR,"Customer not Saved").show();
                e.printStackTrace();
            }
        }
    }

    public boolean validateInput(String cusId, String cusName, String cusAddress, String cusTel) {

        if (cusName.trim().isEmpty()) {

            new Alert(Alert.AlertType.WARNING,"Customer name cannot be null").show();
            // Customer Name is empty or contains only whitespace
            return false;
        }

//        if (cusAddress.trim().isEmpty()) {
//            new Alert(Alert.AlertType.WARNING,"Customer name cannot be null").show();
//            // Customer Address is empty or contains only whitespace
//            return false;
//        }

        if (cusTel.trim().isEmpty()) {
            new Alert(Alert.AlertType.WARNING,"Customer contact number cannot be null").show();
            // Customer Telephone is empty or contains only whitespace
            return false;
        }

        // All inputs are non-empty
        return true;
    }


    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) {

        String cusId = textCustomerID.getText();
        String cusName = textCustomerName.getText();
        String cusAddress = txtAddress.getText();
        String cusEmail = txtEmail.getText();
        String cusTel = txtContactNumber.getText();

        CustomerDTO customerDTO = new CustomerDTO(cusId, cusName, cusAddress, cusEmail, cusTel);

        try {
            boolean isUpdate = customerModel.updateCustomer(customerDTO);

            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated" ).show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnDeleteCustomerOnAction(ActionEvent event) {

        String id = textCustomerID.getText();

        try {
            boolean isDelete = customerModel.deleteCustomer(id);

            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Deleted").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    public void searchOnAction(ActionEvent actionEvent) {

        String id = textCustomerID.getText();

        try {
            CustomerDTO customerDTO = customerModel.searchCustomer(id);

            if (customerDTO != null){
                textCustomerID.setText(customerDTO.getCusId());
                textCustomerName.setText(customerDTO.getCusName());
                txtAddress.setText(customerDTO.getAddress());
                txtContactNumber.setText(customerDTO.getTelNum());
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Customer not found").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void setCellValueFactory(){
        customerIDCol.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("telNum"));
        actionCol.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    private void setViewBtnAction(Button btn,CustomerDTO customerDTO) {
        btn.setOnAction((e) -> {
            System.out.println(customerDTO.getCusName());
            System.out.println(customerDTO.getEmail());

            lblName.setText(customerDTO.getCusName());
            lblId.setText(customerDTO.getCusId());
            lblAddress.setText(customerDTO.getAddress());
            lblEmail.setText(customerDTO.getEmail());
            lblTel.setText(customerDTO.getTelNum());

//            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
//            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

//            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();
//
//            if (type.orElse(no) == yes) {
////                int focusedIndex = tblOrderCart.getSelectionModel().getSelectedIndex();
////
////                obList.remove(focusedIndex);
////                tblOrderCart.refresh();
////                calculateTotal();
//            }
        });
    }

    private void setUpdateBtnAction(Button btn,CustomerDTO customerDTO) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if (type.orElse(no) == yes) {
//                int focusedIndex = tblOrderCart.getSelectionModel().getSelectedIndex();
//
//                obList.remove(focusedIndex);
//                tblOrderCart.refresh();
//                calculateTotal();
            }
        });
    }

    private void setDeleteBtnAction(Button btn,CustomerDTO customerDTO) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if (type.orElse(no) == yes) {
//                int focusedIndex = tblOrderCart.getSelectionModel().getSelectedIndex();
//
//                obList.remove(focusedIndex);
//                tblOrderCart.refresh();
//                calculateTotal();
            }
        });
    }


    public void loadAllCustomers(){
        try {
            List<CustomerDTO> dtoList = customerModel.getAllCustomer();
            mapCustomerTableVal(dtoList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields(){
        textCustomerID.setText("");
        textCustomerName.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        txtContactNumber.setText("");
    }


    @FXML
    void dynamicSearchAction(KeyEvent event) {
        if(!txtdynamicSearch.getText().trim().isEmpty()){
            try {
                List<CustomerDTO> dtoList = customerModel.getAllCustomerBySearch(txtdynamicSearch.getText());
                mapCustomerTableVal(dtoList);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            loadAllCustomers();
        }
    }


    private void mapCustomerTableVal(List<CustomerDTO> dtoList){
        ObservableList<CustomerTM> observableList = FXCollections.observableArrayList();

        for (CustomerDTO customerDTO : dtoList){
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            hbox.getChildren().addAll(createViewButton(customerDTO), createUpdateButton(customerDTO),createDeleteButton(customerDTO));
//            setGraphic(hbox);

            observableList.add(
                    new CustomerTM(
                            customerDTO.getCusId(),
                            customerDTO.getCusName(),
                            customerDTO.getAddress(),
                            customerDTO.getEmail(),
                            customerDTO.getTelNum(),
                            hbox

                    )
            );
        }
        CustomerTbl.setItems(observableList);
    }

    private JFXButton createViewButton(CustomerDTO customerDTO){
        JFXButton btn = new JFXButton();
        setViewBtnAction(btn,customerDTO);
        btn.setCursor(Cursor.HAND);
        btn.setStyle("-fx-background-color: #a29bfe;");

        Image image = new Image(getClass().getResourceAsStream("/view/images/icons8-eye-96.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(16); // Adjust the width as needed
        imageView.setFitHeight(16); // Adjust the height as needed

        // Set image as graphic content
        btn.setGraphic(imageView);
        return btn;
    }

    private JFXButton createUpdateButton(CustomerDTO customerDTO){
        JFXButton btn = new JFXButton();
        setUpdateBtnAction(btn,customerDTO);
        btn.setCursor(Cursor.HAND);
        btn.setStyle("-fx-background-color: #817703;");

        Image image = new Image(getClass().getResourceAsStream("/view/images/icons8-update-64.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(16); // Adjust the width as needed
        imageView.setFitHeight(16); // Adjust the height as needed

        // Set image as graphic content
        btn.setGraphic(imageView);
        return btn;
    }

    private JFXButton createDeleteButton(CustomerDTO customerDTO){
        JFXButton btn = new JFXButton();
        setDeleteBtnAction(btn,customerDTO);
        btn.setCursor(Cursor.HAND);
        btn.setStyle("-fx-background-color: #ff4d4d;");

        Image image = new Image(getClass().getResourceAsStream("/view/images/icons8-delete-90.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(16); // Adjust the width as needed
        imageView.setFitHeight(16); // Adjust the height as needed

        // Set image as graphic content
        btn.setGraphic(imageView);
        return btn;
    }
}
