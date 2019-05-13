package controller;

import model.Celsius;
import model.Fahrenheit;
import model.Kelvin;
import model.Scale;
import view.View;

import java.util.*;

public class Controller {
    private View view;
    private Scale scale;
    private Map<String, Scale> scaleMap = createMap();

    public Controller(View view) {
        this.view = view;

        view.addJButtonConvertListener(e -> {
            try {
                scale = searchScaleForConvert();
                scale.convertTemp(this.view.getInputValue(), this.view.getOutputScale());
                this.view.setSolutionValue(scale.getTempValue());
            } catch (NumberFormatException ex) {
                this.view.displayErrorMessage("Check input the temperature value.");
            } catch (IllegalArgumentException ex) {
                this.view.displayErrorMessage(ex.getMessage());
            } catch (NullPointerException ex) {
                this.view.displayErrorMessage("Scale isn't selected.");
            }
        });
    }

    private Scale searchScaleForConvert() {
        return scaleMap.get(this.view.getInputScale());
    }

    private static Map<String, Scale> createMap() {
        Map<String, Scale> scaleMap = new HashMap<>();

        scaleMap.put("Celsius", new Celsius());
        scaleMap.put("Kelvin", new Kelvin());
        scaleMap.put("Fahrenheit", new Fahrenheit());

        return scaleMap;
    }
}



