package model;

public class Fahrenheit implements Scale {
    private double tempFahrenheitValue;

    @Override
    public double getTempValue() {
        return tempFahrenheitValue;
    }

    @Override
    public void convertTemp(double value, String outputScale) {
        if (value < -459.67) {
            throw new IllegalArgumentException("Fahrenheit can't be less 459.67.");
        }

        switch (outputScale) {
            case "Fahrenheit":
                tempFahrenheitValue = value;
                break;
            case "Celsius":
                tempFahrenheitValue = (value - 32) * ((double) 5 / 9);
                break;
            case "Kelvin":
                tempFahrenheitValue = (value - 32) * ((double) 5 / 9) + 273.15;
                break;
        }
    }
}
