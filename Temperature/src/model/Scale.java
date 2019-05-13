package model;

public interface Scale {
    double getTempValue();

    void convertTemp(double value, String outputScale);
}
