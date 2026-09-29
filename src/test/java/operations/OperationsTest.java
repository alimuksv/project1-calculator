package operations;

import alim.dev.calculator.Calculator;
import alim.dev.operations.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperationsTest {
    Calculator calculator = new Calculator();

    @Test
        public void addOperationTest(){
        Operation op = new AddOperation();
        assertEquals(10.0, op.execute(7,3), 0.001);
    }

    @Test
        public void subtractOperationTest(){
        Operation op = new SubtractOperation();
        assertEquals(7.63, op.execute(19.83, 12.2), 0.001);
    }

    @Test
        public void multiplyOperationTest(){
        Operation op = new MultiplyOperation();
        assertEquals(72.0, op.execute(8, 9), 0.001);
    }

    @Test
        public void divideOperationTest(){
        Operation op = new DivideOperation();
        assertEquals(6, op.execute(36, 6), 0.001);
    }

    @Test
        public void moduloOperationTest(){
        Operation op = new ModuloOperation();
        assertEquals(4, op.execute(12, 8), 0.001);
    }

    @Test
        public void throwsIllegalArgExceptionTest(){
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(6, 5, "{"));

    }

    @Test
        public void divideArithmeticalExceptionTest(){
            assertThrows(ArithmeticException.class,
                    () -> calculator.calculate(5, 0, "/"));
    }

    @Test
        public void moduloArithmeticalExceptionTest(){
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(7, 0, "%"));
    }
}
