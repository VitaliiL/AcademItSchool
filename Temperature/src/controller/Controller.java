package controller;

import Common.ScaleNames;
import Common.Scale;
import view.View;

import java.util.Objects;

public class Controller {
    private View view;

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

    /*
    * the first variant as input scale works:
    *
    * */

    private Scale getInputScaleObject() {
        return ScaleNames.valueOf(this.view.getInputScale().toUpperCase()).getScale();
    }

    /*
     * Or the second variant as input scale works:
     *
     * */

    private Scale getOutputScaleObject() {
        return Objects.requireNonNull(getScaleByName(this.view.getOutputScale())).getScale();
    }

    private static ScaleNames getScaleByName(String name) {
        for (ScaleNames scaleName : ScaleNames.values()) {
            if (scaleName.getScaleName().equals(name)) {
                return scaleName;
            }
        }

        return null;
    }
}



