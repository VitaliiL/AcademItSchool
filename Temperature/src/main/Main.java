package main;

import controller.Controller;
import model.TempConversion;
import view.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        SwingUtilities.invokeLater(() -> {
            View view = new View();
            TempConversion tempConversion = new TempConversion();
            Controller controller = new Controller(view, tempConversion);
            view.setVisible(true);
        });
    }
}

