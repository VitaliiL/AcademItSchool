package main;

import common.ScaleNames;
import controller.Controller;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        ScaleNames controller = new Controller(view);
        view.setScaleNames(controller);
    }
}

