package model;

import common.Scale;

public class FahrenheitScale implements Scale {
    @Override
    public double convertToCelsius(double value) {
        return (value - 32) * ((double) 5 / 9);
    }

    @Override
    public double convertFromCelsius(double value) {
        return value * ((double) 9 / 5) + 32;
    }

    @Override
    public void checkScaleValue(double value) {
        if (value < -459.67) {
            throw new IllegalArgumentException("Fahrenheit can't be less -459.67.");
        }
    }

    @Override
    public String getScaleName() {
        return "Fahrenheit";
    }
}
