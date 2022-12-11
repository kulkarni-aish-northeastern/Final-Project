package com.example.finalproject;

/*import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Button;*/


/*public class HelloApplication extends Application {
    @Override

        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        Button button = new Button("My Button");
        stage.show();*/
        /*public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("HBox Experiment 1");

            Button button = new Button("My Button");

            Scene scene = new Scene(button, 200, 100);
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}*/
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class HelloApplication extends Application {
@Override
public void start(Stage stage) {
        //Creating a Button
        Button button = new Button();
        //Setting text to the button
        button.setText("Upload Image");
        //Setting the location of the button
        button.setTranslateX(150);
        button.setTranslateY(60);
        //Setting the stage
        Group root = new Group(button);
        Scene scene = new Scene(root, 595, 150, Color.BEIGE);
        stage.setTitle("Button Example");
        stage.setScene(scene);
        stage.show();
        }
public static void main(String args[]){
        launch(args);
        }
        }