package model;

public class Kelvin implements Scale {
    private double tempKelvinValue;

    @Override
    public double getTempValue() {
        return tempKelvinValue;
    }

    @Override
    public void convertTemp(double value, String outputScale) {
        if (value < 0) {
            throw new IllegalArgumentException("Kelvin can't be less 0.");
        }

        switch (outputScale) {
            case "Kelvin":
                tempKelvinValue = value;
                break;
            case "Celsius":
                tempKelvinValue = value - 273.15;
                break;
            case "Fahrenheit":
                tempKelvinValue = (value - 273.15) * ((double) 9 / 5) + 32;
                break;
        }
    }
}
