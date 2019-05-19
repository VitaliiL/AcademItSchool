package controller;

import model.CelsiusScale;
import model.FahrenheitScale;
import model.KelvinScale;
import model.Scale;
import view.View;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private View view;
    private Map<String, Scale> scaleMap = createScaleMap();

    public Controller(View view) {
        this.view = view;

        view.getConvertTemperature(e -> {
            try {
                getInputScaleObject().checkScaleValue(this.view.getInputValue());
                double inputValue = getInputScaleObject().convertToCelsius(this.view.getInputValue());
                double outputValue = getOutputScaleObject().convertFromCelsius(inputValue);

                this.view.setSolutionValue(outputValue);
                getOutputScaleObject().checkScaleValue(outputValue);
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

        scaleMap.put("Celsius", new CelsiusScale());
        scaleMap.put("Kelvin", new KelvinScale());
        scaleMap.put("Fahrenheit", new FahrenheitScale());

        return scaleMap;
    }
}



