package controller;

import model.Celsius;
import model.Fahrenheit;
import model.Kelvin;
import model.Scale;
import view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    private View view;
    private Scale scale;
    private ArrayList<Scale> temperatureList = new ArrayList<>(Arrays.asList(new Celsius(), new Kelvin(), new Fahrenheit()));

    public Controller(View view) {
        this.view = view;

        view.addJButtonConvertListener(e -> {
            try {
                scale = searchScaleForConvert(this.view.getInputScale());
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

    private Scale searchScaleForConvert(String scaleName) {
        for (Scale element : temperatureList) {
            if (element.getScaleName().equals(scaleName)) {
                return element;
            }
        }

        return null;
    }
}



