package input;

import alim.dev.calculator.Calculator;
import alim.dev.command.CommandHandler;
import alim.dev.history.HistoryManager;
import alim.dev.input.InputParser;
import alim.dev.input.UserInput;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserInputTest {



    @Test
    public void inputTest(){
        assertEquals("5+5", "5+5");
    }


    @Test
    public void inputTest2(){
        assertEquals("2 + 2", "2 + 2");
    }


}
