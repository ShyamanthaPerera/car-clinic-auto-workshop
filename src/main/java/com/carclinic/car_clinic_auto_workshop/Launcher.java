package com.carclinic.car_clinic_auto_workshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws IOException {

        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Customer");
        stage.show();
    }
}
