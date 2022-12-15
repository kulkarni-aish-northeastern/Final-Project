package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HelloController implements overridden {
    @FXML
    ImageView imageView;
    @FXML
    Text propertyText;
    @FXML
    Text downloadTips;
    @FXML
    ComboBox imageCombo;
    @FXML
    ComboBox colorCombo;
    private File selectedFile;

    @Override
    //Interface method
    public void setImage() {
        imageView = new ImageView();
    }

    //Handle Event: Upload Button
    @FXML
    private void uploadButton(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        //Set extension filter
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPEG", "*.jpeg")
        );
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        //Show open file dialog
        selectedFile = fileChooser.showOpenDialog(null);


        Image img = new Image(selectedFile.toURI().toString());

        imageView.setImage(img);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        propertyText.setText("Width: "+ imageView.getFitWidth() + ", Height: " + imageView.getFitHeight());
    }

    //Handle Event: Download Button
    @FXML
    private void downloadButton(ActionEvent event){
        try {
            //-----Color filter-----------------

            //blue filter
            if (colorCombo.getValue() != null) {
                if (colorCombo.getValue().equals("blue")) {
                    Color targetColor = Color.web("#ff00ffff");
                    ColorAdjust colorAdjust = new ColorAdjust();
                    double hue = targetColor.getHue();
                    colorAdjust.setHue(hue);
                    imageView.setEffect(colorAdjust);
                }
                //red filter
                if (colorCombo.getValue().equals("red")) {
                    ColorAdjust colorAdjust = new ColorAdjust();
                    colorAdjust.setHue(-0.2);
                    imageView.setEffect(colorAdjust);
                }
                //green filter
                if (colorCombo.getValue().equals("green")) {
                    ColorAdjust colorAdjust = new ColorAdjust();
                    colorAdjust.setHue(0.4);
                    imageView.setEffect(colorAdjust);
                }
            }

            //--------Convert Image format, then save to user file-----------------
            BufferedImage image = ImageIO.read(selectedFile);
            if (imageCombo.getValue().equals("PNG")){
                ImageIO.write(image, "png", new File( "converted.png"));
            }
            if (imageCombo.getValue().equals("JPG")){
                ImageIO.write(image, "jpg", new File( "converted.jpg"));
            }
            if (imageCombo.getValue().equals("JPEG")){
                ImageIO.write(image, "gif",  new File("converted.jpeg"));
            }

            downloadTips.setText("Download successfully");
        }
        //Exception Handling
        catch (IOException e){
            downloadTips.setText("Download failed! Try another image.");
            e.printStackTrace();
        }
    }

}
