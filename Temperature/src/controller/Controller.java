package controller;

import common.Scale;
import common.ScaleNames;
import model.CelsiusScale;
import model.FahrenheitScale;
import model.KelvinScale;
import view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller implements ScaleNames {
    private View view;
    private ArrayList<Scale> scaleList = new ArrayList<>(Arrays.asList(new CelsiusScale(), new KelvinScale(), new FahrenheitScale()));

    public Controller(View view) {
        this.view = view;

        view.getConvertTemperature(e -> {
            try {
                double inputScaleValue = this.view.getInputValue();
                String inputScaleName = this.view.getInputScale();
                String outputScaleName = this.view.getOutputScale();

                Scale inputScale = getScaleObject(inputScaleName);
                Scale outputScale = getScaleObject(outputScaleName);

                inputScale.checkScaleValue(inputScaleValue);
                double inputValueToCelsius = inputScale.convertToCelsius(inputScaleValue);
                double outputValueFromCelsius = outputScale.convertFromCelsius(inputValueToCelsius);

                this.view.setSolutionValue(outputValueFromCelsius);
            } catch (NumberFormatException ex) {
                this.view.displayErrorMessage("Check input the temperature value.");
            } catch (IllegalArgumentException ex) {
                this.view.displayErrorMessage(ex.getMessage());
            }
        });
    }

    private Scale getScaleObject(String name) {
        Scale scaleObject = null;

        for (Scale scale : scaleList) {
            if (scale.getScaleName().equals(name)) {
                scaleObject = scale;
            }
        }

        return scaleObject;
    }

    @Override
    public String[] getScaleNames() {
        return scaleList.stream().map(Scale::getScaleName).toArray(String[]::new);
    }
}



