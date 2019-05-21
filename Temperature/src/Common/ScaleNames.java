package Common;

import model.CelsiusScale;
import model.FahrenheitScale;
import model.KelvinScale;
import model.Scale;

public enum ScaleNames {
    CELSIUS("Celsius", new CelsiusScale()),
    KELVIN("Kelvin", new KelvinScale()),
    FAHRENHEIT("Fahrenheit", new FahrenheitScale());

    private String scaleName;
    private Scale scale;

    ScaleNames(String scaleName, Scale scale) {
        this.scaleName = scaleName;
        this.scale = scale;
    }

    public String getScaleName() {
        return scaleName;
    }

    public Scale getScale() {
        return scale;
    }
}
