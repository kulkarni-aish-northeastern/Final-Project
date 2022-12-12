package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        FileChooser fC = new FileChooser();

        fC.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files" ,"*.png" , "*.jpg" , "*.jpeg"));
        List<File> f = fC.showOpenMultipleDialog(null);//stores files in f object list of type: File
        if (f != null){
            for (File file : f) {
                System.out.println(file.getAbsoluteFile());
            }
        }
    }


}