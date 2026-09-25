import alim.dev.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void additionReturnsCorrectResult() {
        assertEquals(8.0, calculator.calculate(5, 3, "+"), 0.001);
    }


    @Test
    void subtractionReturnsCorrectResult(){
        assertEquals(10.0, calculator.calculate(19, 9, "-"), 0.001);
    }

    @Test
    void multiplicationReturnsCorrectResult(){
        assertEquals(14, calculator.calculate(7, 2, "*"), 0.001);
    }

    @Test
    void divisionReturnsCorrectResult(){
        assertEquals(32, calculator.calculate(96, 3, "/"), 0.001);
    }

    @Test
    void divisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(5, 0, "/"));
    }

    @Test
    void substractionThrowsIllegalArgException(){
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(5, 5, "&"));
    }

}
