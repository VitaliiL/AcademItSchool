package controller;

import model.Celsius;
import model.Fahrenheit;
import model.Kelvin;
import model.Scale;
import view.View;

import java.util.*;

public class Controller {
    private View view;
    private Map<String, Scale> scaleMap = createScaleMap();

    public Controller(View view) {
        this.view = view;

        view.getConvertTemperature(e -> {
            try {
                Scale inputScale = getInputScaleObject();
                double inputValue = inputScale.convertToCelsius(this.view.getInputValue());

                Scale outputScale = getOutputScaleObject();
                double outputValue = outputScale.convertFromCelsius(inputValue);

                this.view.setSolutionValue(outputValue);
            } catch (NumberFormatException ex) {
                this.view.displayErrorMessage("Check input the temperature value.");
            } catch (IllegalArgumentException ex) {
                this.view.displayErrorMessage(ex.getMessage());
            } catch (NullPointerException ex) {
                this.view.displayErrorMessage("Scale isn't selected.");
            }
        });
    }

    private Scale getInputScaleObject() {
        return scaleMap.get(this.view.getInputScale());
    }

    private Scale getOutputScaleObject() {
        return scaleMap.get(this.view.getOutputScale());
    }

    private static Map<String, Scale> createScaleMap() {
        Map<String, Scale> scaleMap = new HashMap<>();

        scaleMap.put("Celsius", new Celsius());
        scaleMap.put("Kelvin", new Kelvin());
        scaleMap.put("Fahrenheit", new Fahrenheit());

        return scaleMap;
    }
}



