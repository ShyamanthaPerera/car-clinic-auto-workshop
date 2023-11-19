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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class CustomerFormController {

    public TableColumn emailCol;
    public Label lblName;
    public TextArea lblId;
    public TextArea lblAddress;
    public TextArea lblEmail;
    public TextArea lblTel;
    public JFXButton customerAddBtn;
    public JFXButton customerUpdateBtn;
    @FXML
    private JFXTextField txtdynamicSearch;

    @FXML
    private TextField textCustomerID;

    @FXML
    private TextField textCustomerName;

    @FXML
    private TextField textCustomerEmail;

    @FXML
    private TextField textCustomerAddress;

    @FXML
    private TextField textCustomerNumber;

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

    ObservableList<CustomerTM> observableList = FXCollections.observableArrayList();

    public void initialize(){
        setCellValueFactory();
        loadAllCustomers();
        customerAddBtn.setDisable(true);
        customerUpdateBtn.setDisable(true);
        textCustomerID.requestFocus();
    }

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {

        String cusId = textCustomerID.getText();
        String cusName = textCustomerName.getText();
        String cusAddress = textCustomerAddress.getText();
        String cusEmail = textCustomerEmail.getText();
        String cusTel = textCustomerNumber.getText();

        if (validateInput(cusId, cusName, cusAddress, cusTel)) {
            CustomerDTO dto = new CustomerDTO(cusId, cusName, cusAddress, cusEmail, cusTel);

            try {
                boolean isSaved = customerModel.saveCustomer(dto);

                if (isSaved){
                    new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
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
        String cusAddress = textCustomerAddress.getText();
        String cusEmail = textCustomerEmail.getText();
        String cusTel = textCustomerNumber.getText();

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
                textCustomerAddress.setText(customerDTO.getAddress());
                textCustomerNumber.setText(customerDTO.getTelNum());
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
            textCustomerID.setText(customerDTO.getCusId());
            textCustomerName.setText(customerDTO.getCusName());
            textCustomerEmail.setText(customerDTO.getEmail());
            textCustomerAddress.setText(customerDTO.getAddress());
            textCustomerNumber.setText(customerDTO.getTelNum());

            customerUpdateBtn.setDisable(false);
        });
    }

    private void setDeleteBtnAction(Button btn,CustomerDTO customerDTO) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if (type.orElse(no) == yes) {

                String id = customerDTO.getCusId();

                try {
                    boolean isDelete = customerModel.deleteCustomer(id);

                    if (isDelete){
                        new Alert(Alert.AlertType.CONFIRMATION,"Customer Deleted").show();
                    }
                } catch (SQLException exception) {
                    new Alert(Alert.AlertType.ERROR,exception.getMessage()).show();
                }
                int focusedIndex = CustomerTbl.getSelectionModel().getFocusedIndex();

                observableList.remove(focusedIndex);
                CustomerTbl.refresh();
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
        textCustomerAddress.setText("");
        textCustomerEmail.setText("");
        textCustomerNumber.setText("");
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

    public void validateCusId(KeyEvent keyEvent) {
        String id = textCustomerID.getText();
        final boolean matches = Pattern.matches("[C][0-9]{3,}",id);

        if (matches) {
            textCustomerID.getParent().setStyle("-fx-border-color: green");
        }else {
            textCustomerID.getParent().setStyle("-fx-border-color: red");
        }

        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (matches){
                textCustomerName.requestFocus();
            }
        }
    }

    public void validateCusName(KeyEvent keyEvent) {
        String name = textCustomerName.getText();
        final boolean matches = Pattern.matches("([A-Z a-z])+",name);

        if (matches) {
            textCustomerName.getParent().setStyle("-fx-border-color: green");
        }else {
            textCustomerName.getParent().setStyle("-fx-border-color: red");
        }
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (matches){
                textCustomerEmail.requestFocus();
            }
        }
    }

    public void validateCusEmail(KeyEvent keyEvent) {
        String email = textCustomerEmail.getText();
        final boolean matches = Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",email);

        if (matches) {
            textCustomerEmail.getParent().setStyle("-fx-border-color: green");
        }else {
            textCustomerEmail.getParent().setStyle("-fx-border-color: red");
        }
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (matches){
                textCustomerAddress.requestFocus();
            }
        }
    }

    public void validateCusAddress(KeyEvent keyEvent) {
        String address = textCustomerAddress.getText();
        final boolean matches = Pattern.matches("[A-Za-z0-9 ,]+",address);

        if (matches) {
            textCustomerAddress.getParent().setStyle("-fx-border-color: green");
        }else {
            textCustomerAddress.getParent().setStyle("-fx-border-color: red");
        }
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (matches){
                textCustomerNumber.requestFocus();
            }
        }
    }

    public void validateCusNumber(KeyEvent keyEvent) {
        String number = textCustomerNumber.getText();
        final boolean matches = Pattern.matches("[0]\\d{9}",number);

        if (matches) {
            textCustomerNumber.getParent().setStyle("-fx-border-color: green");
            customerAddBtn.setDisable(false);
        }else {
            textCustomerNumber.getParent().setStyle("-fx-border-color: red");
            customerAddBtn.setDisable(true);
        }
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (matches){
                customerAddBtn.requestFocus();
            }else {
                customerAddBtn.setDisable(true);
            }
        }
    }

    private void generateNextCustomerId() {
        try {
            String customerId = customerModel.generateNextCustomerId();
            textCustomerID.setText(customerId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
