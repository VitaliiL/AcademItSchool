package controller;

import model.Model;
import view.View;

public class Controller {
    private View view;
    private Model model;

    public Controller(View v, Model m) {
        this.view = v;
        this.model = m;

        this.view.addJButtonConvertListener(e -> {
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
        });
    }
}



