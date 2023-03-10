import org.testng.annotations.Test;
import pages.Calculator;

import static org.testng.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void addPositiveNumbersTest() {
        int numberA = 10;
        int numberB = 30;
        int actualResult = calculator.add(numberA, numberB);
        int expectedResult = 40;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void addNegativeNumbersTest() {
        int numberA = -15;
        int numberB = -22;
        int actualResult = calculator.add(numberA, numberB);
        int expectedResult = -37;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void addWrongResultTest() {
        int numberA = -30;
        int numberB = 70;
        int actualResult = calculator.add(numberA, numberB);
        int wrongResult = 100;
        assertNotEquals(actualResult, wrongResult);
    }

    @Test
    public void subtractPositiveNumbersTest() {
        int numberA = 20;
        int numberB = 5;
        int actualResult = calculator.subtract(numberA, numberB);
        int expectedResult = 15;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void subtractNegativeNumbersTest() {
        int numberA = -50;
        int numberB = -25;
        int actualResult = calculator.subtract(numberA, numberB);
        int expectedResult = -25;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void subtractWrongResultTest() {
        int numberA = 75;
        int numberB = -25;
        int actualResult = calculator.subtract(numberA, numberB);
        int expectedResult = 50;
        assertNotEquals(actualResult, expectedResult);
    }

    @Test
    public void multiplyPositiveNumbersTest() {
        int numberA = 10;
        int numberB = 30;
        int actualResult = calculator.multiply(numberA, numberB);
        int expectedResult = 300;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multiplyNegativeNumbersTest() {
        int numberA = -250;
        int numberB = -2;
        int actualResult = calculator.multiply(numberA, numberB);
        int expectedResult = 500;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multiplyWrongResultTest() {
        int numberA = 60;
        int numberB = -25;
        int actualResult = calculator.multiply(numberA, numberB);
        int wrongResult = 1500;
        assertNotEquals(actualResult, wrongResult);
    }

    @Test
    public void dividePositiveNumbersTest() {
        int numberA = 55;
        int numberB = 5;
        double actualResult = calculator.divide(numberA, numberB);
        double expectedResult = 11;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divideNegativeNumbersTest() {
        int numberA = -150;
        int numberB = -35;
        double actualResult = calculator.divide(numberA, numberB);
        double expectedResult = 4.286;
        assertEquals(actualResult, expectedResult, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void divideByZeroTest() {
        int numberA = 70;
        int numberB = 0;
        calculator.divide(numberA, numberB);
    }
}








