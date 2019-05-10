package controller;

import model.TempConversion;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private TempConversion tempConversion;

    public Controller(View view, TempConversion tempConversion) {
        this.view = view;
        this.tempConversion = tempConversion;

        this.view.addListener(new Listener());
    }

    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double temperature = view.getInputValue();
                String inputScale = view.getInputScale();
                String outputScale = view.getOutputScale();

                tempConversion.convertTemp(temperature, inputScale, outputScale);
                view.setSolutionValue(tempConversion.getTempValue());
            } catch (NumberFormatException ex) {
                view.displayErrorMessage("Check input the temperature value. (Max amount 10.)");
            } catch (NullPointerException ex) {
                view.displayErrorMessage("Check input data. Scale isn't selected.");
            }
        }
    }
}



