package model;

public class Celsius implements Scale {
    private double tempCelsiusValue;

    @Override
    public double getTempValue() {
        return tempCelsiusValue;
    }

    @Override
    public void convertTemp(double value, String outputScale) {
        if (value < -273.15) {
            throw new IllegalArgumentException("Celsius can't be less 273.15.");
        }

        switch (outputScale) {
            case "Celsius":
                tempCelsiusValue = value;
                break;
            case "Kelvin":
                tempCelsiusValue = value + 273.15;
                break;
            case "Fahrenheit":
                tempCelsiusValue = value * ((double) 9 / 5) + 32;
                break;
        }
    }
}
