package model;

public class Celsius implements Scale {
    @Override
    public double convertToCelsius(double value) {
        return value;
    }

    @Override
    public double convertFromCelsius(double value) {
        return value;
    }
}
