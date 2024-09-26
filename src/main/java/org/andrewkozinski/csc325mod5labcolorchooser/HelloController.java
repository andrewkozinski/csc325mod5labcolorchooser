package org.andrewkozinski.csc325mod5labcolorchooser;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.text.NumberFormat;

public class HelloController {

    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    // instance variables for managing
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;



    public void initialize() {

        /*
        // bind TextField values to corresponding Slider values
        redTextField.textProperty().bind(
                redSlider.valueProperty().asString("%.0f"));
        greenTextField.textProperty().bind(
                greenSlider.valueProperty().asString("%.0f"));
        blueTextField.textProperty().bind(
                blueSlider.valueProperty().asString("%.0f"));
        alphaTextField.textProperty().bind(
                alphaSlider.valueProperty().asString("%.2f"));

        redSlider.valueProperty().bindBidirectional(new SimpleDoubleProperty(Double.parseDouble(redTextField.getText())));
        greenSlider.valueProperty().bindBidirectional(new SimpleDoubleProperty(Double.parseDouble(greenTextField.getText())));
        blueSlider.valueProperty().bindBidirectional(new SimpleDoubleProperty(Double.parseDouble(blueTextField.getText())));
        alphaSlider.valueProperty().bindBidirectional(new SimpleDoubleProperty(Double.parseDouble(alphaTextField.getText())));
        */


        redTextField.textProperty().bindBidirectional(redSlider.valueProperty(), NumberFormat.getInstance());
        greenTextField.textProperty().bindBidirectional(greenSlider.valueProperty(), NumberFormat.getInstance());
        blueTextField.textProperty().bindBidirectional(blueSlider.valueProperty(), NumberFormat.getInstance());
        alphaTextField.textProperty().bindBidirectional(alphaSlider.valueProperty(), NumberFormat.getInstance());



        // listeners that set Rectangle's fill based on Slider changes
        redSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        red = newValue.intValue();
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                    }
                }
        );
        greenSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        green = newValue.intValue();
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                    }
                }
        );
        blueSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        blue = newValue.intValue();
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                    }
                }
        );
        alphaSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        alpha = newValue.doubleValue();
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                    }
                }
        );

    }


}