package model;

import Common.Scale;

public class KelvinScale implements Scale {
    @Override
    public double convertToCelsius(double value) {
        return value + 273.15;
    }

    @Override
    public double convertFromCelsius(double value) {
        return value - 273.15;
    }

    @Override
    public void checkScaleValue(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Kelvin can't be less 0.");
        }
    }
}
