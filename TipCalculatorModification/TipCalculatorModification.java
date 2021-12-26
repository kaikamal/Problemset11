package com.example.demo2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculatorModification extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TipCalculatorModification.fxml"));
        stage.setTitle("Modified Tip Calculator");
        stage.setScene(new Scene(root, 237, 152));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
