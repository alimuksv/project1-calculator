package input;

import alim.dev.calculator.Calculator;
import alim.dev.history.HistoryManager;
import alim.dev.input.InputParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputParserTest {

    Calculator calculator = new Calculator();
    HistoryManager historyManager = new HistoryManager();
    InputParser inputParser = new InputParser(calculator,historyManager);

    @Test
    public void inputParsingTest(){
        assertEquals("8.0", inputParser.parsing("4+4"));
    }

    @Test
    public void inputParserThrowsIAETest(){
        assertThrows(IllegalArgumentException.class,
                () -> inputParser.parsing("-5"));
    }

    @Test
    public void inputParserThrowsArithmeticalExceptionTest(){
        assertThrows(ArithmeticException.class,
                () -> inputParser.parsing("5/0"));
    }

    @Test
    public void inputParsingWithSpaceTest(){
        assertEquals("9.0",  inputParser.parsing(" 4.5  *  2 "));
    }
}
