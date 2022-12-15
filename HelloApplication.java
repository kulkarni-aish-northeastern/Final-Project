package com.example.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class HelloApplication extends Application   {

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Final Project");
        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("sample.css")));
        //scene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }


}