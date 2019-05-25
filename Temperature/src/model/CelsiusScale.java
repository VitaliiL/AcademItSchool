package model;

import common.Scale;

public class CelsiusScale implements Scale {
    @Override
    public double convertToCelsius(double value) {
        return value;
    }

    @Override
    public double convertFromCelsius(double value) {
        return value;
    }

    @Override
    public void checkScaleValue(double value) {
        if (value < -273.15) {
            throw new IllegalArgumentException("Celsius can't be less -273.15.");
        }
    }

    @Override
    public String getScaleName() {
        return "Celsius";
    }
}
