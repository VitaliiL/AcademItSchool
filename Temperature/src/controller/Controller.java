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
    private Map<String, Scale> myMap = createMap();

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
        return myMap.get(this.view.getInputScale());
    }

    private static Map<String, Scale> createMap() {
        Map<String, Scale> myMap = new HashMap<>();

        myMap.put("Celsius", new Celsius());
        myMap.put("Kelvin", new Kelvin());
        myMap.put("Fahrenheit", new Fahrenheit());

        return myMap;
    }
}



