package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ContactsAppModification extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ContactsAppModification.fxml"));
        stage.setTitle("Contacts Application Modified");
        stage.setScene(new Scene(root, 630, 400));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

