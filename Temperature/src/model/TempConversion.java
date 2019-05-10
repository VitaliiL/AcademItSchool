package model;

public class TempConversion {
    private double tempValue;

    public double getTempValue() {
        return tempValue;
    }

    public void convertTemp(double value, String inputScale, String outputScale) {
        if (!inputScale.equals(outputScale)) {
            switch (inputScale) {
                case "Celsius":
                    if (outputScale.equals("Kelvin")) {
                        tempValue = value + 273.15;
                    } else if (outputScale.equals("Fahrenheit")) {
                        tempValue = value * ((double) 9 / 5) + 32;
                    }
                    break;
                case "Kelvin":
                    if (outputScale.equals("Celsius")) {
                        tempValue = value - 273.15;
                    } else if (outputScale.equals("Fahrenheit")) {
                        tempValue = (value - 273.15) * ((double) 9 / 5) + 32;
                    }
                    break;
                case "Fahrenheit":
                    if (outputScale.equals("Celsius")) {
                        tempValue = (value - 32) * ((double) 5 / 9);
                    } else if (outputScale.equals("Kelvin")) {
                        tempValue = (value - 32) * ((double) 5 / 9) + 273.15;
                    }
                    break;
            }
        } else {
            tempValue = value;
        }
    }
}