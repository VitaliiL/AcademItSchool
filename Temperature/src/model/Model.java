package model;

public class Model {
    private double tempValue;

    public double getTempValue() {
        return tempValue;
    }

    public void convertTemp(double value, String inputScale, String outputScale) {
        if (inputScale.equals(outputScale)) {
            tempValue = value;
        } else {
            switch (inputScale) {
                case "Celsius":
                    if (value < -273.15) {
                        throw new IllegalArgumentException("Celsius can't be less 273.15.");
                    }

                    if (outputScale.equals("Kelvin")) {
                        tempValue = value + 273.15;
                    } else if (outputScale.equals("Fahrenheit")) {
                        tempValue = value * ((double) 9 / 5) + 32;
                    }
                    break;

                case "Kelvin":
                    if (value < 0) {
                        throw new IllegalArgumentException("Kelvin can't be less 0.");
                    }

                    if (outputScale.equals("Celsius")) {
                        tempValue = value - 273.15;
                    } else if (outputScale.equals("Fahrenheit")) {
                        tempValue = (value - 273.15) * ((double) 9 / 5) + 32;
                    }
                    break;

                case "Fahrenheit":
                    if (value < -459.67) {
                        throw new IllegalArgumentException("Fahrenheit can't be less 459.67.");
                    }

                    if (outputScale.equals("Celsius")) {
                        tempValue = (value - 32) * ((double) 5 / 9);
                    } else if (outputScale.equals("Kelvin")) {
                        tempValue = (value - 32) * ((double) 5 / 9) + 273.15;
                    }
                    break;
            }
        }
    }
}