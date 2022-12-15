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
import java.util.logging.Level;
import java.util.logging.Logger;
public class HelloController implements overridden {
    @FXML
    ImageView imgview;
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
    public void setImage() {
        imgview = new ImageView();
    }

    //Handle Event: Upload Button
    @FXML
    private void buttonClicked(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        selectedFile = fileChooser.showOpenDialog(null);


        Image img = new Image(selectedFile.toURI().toString());
        
        imgview.setImage(img);
        imgview.setFitHeight(100);
        imgview.setFitWidth(100);
        propertyText.setText("Width: "+ imgview.getFitWidth() + ", Height: " + imgview.getFitHeight());
    }

    //Handle Event: Download Button
    @FXML
    private void buttonClickedTwo(ActionEvent event){
        try {
            //-----Color filter-----------------

            //blue filter
            if (colorCombo.getValue() != null) {
                if (colorCombo.getValue().equals("blue")) {
                    Color targetColor = Color.web("#ff00ffff");
                    ColorAdjust colorAdjust = new ColorAdjust();
                    double hue = targetColor.getHue();
                    colorAdjust.setHue(hue);
                    imgview.setEffect(colorAdjust);
                }
                //red filter
                if (colorCombo.getValue().equals("red")) {
                    ColorAdjust colorAdjust = new ColorAdjust();
                    colorAdjust.setHue(-0.2);
                    imgview.setEffect(colorAdjust);
                }
                //green filter
                if (colorCombo.getValue().equals("green")) {
                    ColorAdjust colorAdjust = new ColorAdjust();
                    colorAdjust.setHue(0.4);
                    imgview.setEffect(colorAdjust);
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
            if (imageCombo.getValue().equals("GIF")){
                ImageIO.write(image, "gif",  new File("converted.gif"));
            }
            if (imageCombo.getValue().equals("BMP")){
                ImageIO.write(image, "bmp",  new File( "converted.bmp"));
            }
            if (imageCombo.getValue().equals("TIFF")){
                ImageIO.write(image, "tiff",  new File("converted.tiff"));
            }
            downloadTips.setText("Download successfully");
        }catch (IOException e){
            downloadTips.setText("Download failed! Try another image.");
            e.printStackTrace();
        }
    }

}
