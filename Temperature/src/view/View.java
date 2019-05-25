package view;

import common.ScaleNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private JFrame jFrame = new JFrame("Temperatures");
    private JButton jButtonConvert = new JButton("Convert");
    private JTextField jTextFieldInputData = new JTextField(10);
    private JTextField jTextFieldResult = new JTextField(10);
    private ButtonGroup inputScaleButtonGroup = new ButtonGroup();
    private ButtonGroup outputScaleButtonGroup = new ButtonGroup();
    private ScaleNames scaleNames;

    public View() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            setFrame();
            createJLabel();
            createJButton();
            createJTextField();
            createJRadioButtons();
        });
    }

    private void setFrame() {
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setMinimumSize(new Dimension(500, 250));
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new GridBagLayout());
        jFrame.setVisible(true);
    }

    private void createJLabel() {
        JLabel jLabelStart = new JLabel("Input the temperature value:");
        JLabel jLabelFrom = new JLabel("Select the temperature scale from:");
        JLabel jLabelTo = new JLabel("Select the temperature scale to:");

        jFrame.add(jLabelStart, new GridBagConstraints(0, 0, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 5, 5), 0, 0));
        jFrame.add(jLabelFrom, new GridBagConstraints(0, 1, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 10, 5, 5), 0, 0));
        jFrame.add(jLabelTo, new GridBagConstraints(1, 1, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    }

    private void createJButton() {
        jFrame.add(jButtonConvert, new GridBagConstraints(1, 5, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 10, 5), 0, 0));
    }

    private void createJTextField() {
        jTextFieldResult.setEditable(false);
        jTextFieldResult.setHorizontalAlignment(JTextField.CENTER);
        jTextFieldInputData.setHorizontalAlignment(JTextField.CENTER);

        jFrame.add(jTextFieldResult, new GridBagConstraints(0, 5, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 10, 5), 0, 0));
        jFrame.add(jTextFieldInputData, new GridBagConstraints(1, 0, 1, 1, 0.5, 0.5,
                GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
    }

    private void createJRadioButtons() {
        String[] scaleName = scaleNames.getScaleNames();

        for (int i = 0; i < scaleName.length; i++) {
            JRadioButton inputScaleJRadioButton = new JRadioButton(scaleName[i]);
            JRadioButton outputScaleJRadioButton = new JRadioButton(scaleName[i]);

            inputScaleButtonGroup.add(inputScaleJRadioButton);
            outputScaleButtonGroup.add(outputScaleJRadioButton);

            inputScaleJRadioButton.setActionCommand(scaleName[i]);
            outputScaleJRadioButton.setActionCommand(scaleName[i]);

            jFrame.add(inputScaleJRadioButton, new GridBagConstraints(0, i + 2, 1, 1, 1, 1,
                    GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
            jFrame.add(outputScaleJRadioButton, new GridBagConstraints(1, i + 2, 1, 1, 1, 1,
                    GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 5, 5), 0, 0));
        }
    }

    public void setScaleNames(ScaleNames scaleNames) {
        this.scaleNames = scaleNames;
    }

    public double getInputValue() {
        return Double.parseDouble(jTextFieldInputData.getText());
    }

    public void setSolutionValue(double value) {
        jTextFieldResult.setText(String.format("%.20s", Double.toString(value)));
    }

    public void getConvertTemperature(ActionListener listenerForConvertButton) {
        jButtonConvert.addActionListener(listenerForConvertButton);
    }

    public String getInputScale() {
        if (inputScaleButtonGroup.getSelection() == null) {
            throw new IllegalArgumentException("Input scale isn't selected!");
        } else {
            return inputScaleButtonGroup.getSelection().getActionCommand();
        }
    }

    public String getOutputScale() {
        if (outputScaleButtonGroup.getSelection() == null) {
            throw new IllegalArgumentException("Output scale isn't selected!");
        } else {
            return outputScaleButtonGroup.getSelection().getActionCommand();
        }
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(jFrame, errorMessage);
    }
}