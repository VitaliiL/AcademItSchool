package common;

public interface Scale {
    double convertToCelsius(double value);

    double convertFromCelsius(double value);

    void checkScaleValue(double value);

    String getScaleName();
}
