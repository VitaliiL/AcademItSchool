package controller;

import model.Model;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        this.view.addJButtonConvertListener(new JButtonConvertListener());
    }

    class JButtonConvertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double temperature = view.getInputValue();
                String inputScale = view.getInputScale();
                String outputScale = view.getOutputScale();

                model.convertTemp(temperature, inputScale, outputScale);
                view.setSolutionValue(model.getTempValue());
            } catch (NumberFormatException ex) {
                view.displayErrorMessage("Check input the temperature value.");
            } catch (IllegalArgumentException ex) {
                view.displayErrorMessage(ex.getMessage());
            } catch (NullPointerException ex) {
                view.displayErrorMessage("Scale isn't selected.");
            }
        }
    }
}



