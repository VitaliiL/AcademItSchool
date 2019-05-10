package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class View extends JFrame {
    private JButton jButtonConvert = new JButton("Convert");
    private JTextField jTextFieldInputData = new JTextField(10);
    private JTextField jTextFieldResult = new JTextField(10);

    private ButtonGroup bg = new ButtonGroup();
    private ButtonGroup bg2 = new ButtonGroup();

    public View() {
        super("Temperatures");
        jTextFieldResult.setEditable(false);
        jTextFieldResult.setHorizontalAlignment(JTextField.CENTER);
        jTextFieldInputData.setHorizontalAlignment(JTextField.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 250));
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JRadioButton buttonFromCelsius = new JRadioButton("Celsius");
        JRadioButton buttonFromKelvin = new JRadioButton("Kelvin");
        JRadioButton buttonFromFahrenheit = new JRadioButton("Fahrenheit");
        JRadioButton buttonToCelsius = new JRadioButton("Celsius");
        JRadioButton buttonToKelvin = new JRadioButton("Kelvin");
        JRadioButton buttonToFahrenheit = new JRadioButton("Fahrenheit");

        add(buttonFromCelsius, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
        add(buttonFromKelvin, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
        add(buttonFromFahrenheit, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
        add(buttonToCelsius, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
        add(buttonToKelvin, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
        add(buttonToFahrenheit, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));

        bg.add(buttonFromCelsius);
        bg.add(buttonFromKelvin);
        bg.add(buttonFromFahrenheit);

        bg2.add(buttonToCelsius);
        bg2.add(buttonToKelvin);
        bg2.add(buttonToFahrenheit);

        JLabel jLabelStart = new JLabel("Input the temperature value:");
        JLabel jLabelFrom = new JLabel("Select the temperature scale from:");
        JLabel jLabelTo = new JLabel("Select the temperature scale to:");

        add(jLabelStart, new GridBagConstraints(0, 0, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 5, 5), 0, 0));
        add(jLabelFrom, new GridBagConstraints(0, 1, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 10, 5, 5), 0, 0));
        add(jTextFieldResult, new GridBagConstraints(0, 5, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 10, 5), 0, 0));
        add(jTextFieldInputData, new GridBagConstraints(1, 0, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
        add(jLabelTo, new GridBagConstraints(1, 1, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        add(jButtonConvert, new GridBagConstraints(1, 5, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 10, 5), 0, 0));
    }

    public double getInputValue() {
        return Double.parseDouble(jTextFieldInputData.getText());
    }

    public void setSolutionValue(double value) {
        jTextFieldResult.setText(String.format("%.20s", Double.toString(value)));
    }

    public void addListener(ActionListener listenerForConvertButton) {
        jButtonConvert.addActionListener(listenerForConvertButton);
    }

    public String getInputScale() {
        for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public String getOutputScale() {
        for (Enumeration<AbstractButton> buttons = bg2.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}