package model;

public class FahrenheitScale implements Scale {
    @Override
    public double convertToCelsius(double value) {
        return (value - 32) * ((double) 5 / 9);
    }

    @Override
    public double convertFromCelsius(double value) {
        return value * ((double) 9 / 5) + 32;
    }
}
