package ru.academits.Vector.LV.Main;

import ru.academits.Vector.LV.Vector.Vector;

import static ru.academits.Vector.LV.Vector.Vector.getScalarMultiplication;
import static ru.academits.Vector.LV.Vector.Vector.getSubtractionVectors;
import static ru.academits.Vector.LV.Vector.Vector.getSumVectors;

public class Main {
    public static void main(String[] args) {
        double[] array1 = new double[]{1, 2, 3, 4, 5};
        double[] array2 = new double[]{7, 8, 9};
        double[] array3 = new double[]{1, 6, 10};

        try {
            Vector vector1 = new Vector(array1);
            Vector vector2 = new Vector(array2);

            System.out.printf("Vector1 and vector2 sizes are %s and %s %n", vector1.getSize(), vector2.getSize());
            System.out.printf("Vector1 and vector2 are %s and %s %n%n", vector1.toString(), vector2.toString());

            Vector additionVector = new Vector(array1);
            System.out.printf("Sum res is %26s%n", additionVector.addToVector(vector2));

            Vector subtractionVector = new Vector(array1);
            System.out.printf("Sub res is %27s%n", subtractionVector.getSubtractionFromVector(vector2));

            Vector multiplicationScalar = new Vector(array1);
            System.out.printf("Scalar res is %s%n%n", multiplicationScalar.getMultiplicationScalar(5));

            Vector vectorReverse = new Vector(array1);
            System.out.printf("Reverse res is %40s%n", vectorReverse.getVectorReverse());

            System.out.printf("Length res are %15s and %s%n", vector1.getVectorLength(), vector2.getVectorLength());

            Vector componentChange = new Vector(array1);
            System.out.printf("Component change by index is %s%n", componentChange.getComponentVector(3, 100));
            System.out.printf("Change checking is %33s%n%n", componentChange.toString());

            System.out.println("Static methods checking:");
            System.out.printf("Sum is %s %n", getSumVectors(vector1, vector2));
            System.out.printf("Sub is %s %n", getSubtractionVectors(vector1, vector2));
            System.out.printf("Mul is %s %n%n", getScalarMultiplication(vector1, vector2));

            //to check not used constructors during checking of methods:
            Vector vector3 = new Vector(1);
            System.out.printf("Constructor checking: %s%n", vector3.toString());
            Vector vector4 = new Vector(0, array3);
            System.out.printf("Constructor checking: %s%n", vector4.toString());

        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Error during the program executing: " + e.getMessage());

        }
    }
}
