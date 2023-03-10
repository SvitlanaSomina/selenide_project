package pages;

public class Calculator {

    public int add(int numberA, int numberB) {
        return numberA + numberB;
    }

    public int subtract(int numberA, int numberB) {
        return numberA - numberB;
    }

    public int multiply(int numberA, int numberB) {
        return numberA * numberB;
    }

    public double divide(int numberA, int numberB) {
        if(numberB == 0) {
            throw new IllegalArgumentException("Division by zero is not possible");
        }
        return (double) numberA / (double) numberB;
    }
}
