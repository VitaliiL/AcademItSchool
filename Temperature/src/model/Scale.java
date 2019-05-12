package model;

public interface Scale {
    String getScaleName();

    double getTempValue();

    void convertTemp(double value, String outputScale);
}
